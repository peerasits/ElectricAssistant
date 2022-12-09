package com.example.electricassistant.ui;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.ekndev.gaugelibrary.Range;
import com.example.electricassistant.Data.CostOfElectricityDisplayData;
import com.example.electricassistant.Data.GeneralDisplayData;
import com.example.electricassistant.Data.GlobalData;
import com.example.electricassistant.MainActivity;
import com.example.electricassistant.R;
import com.example.electricassistant.dialog.DialogTemplate;
import com.example.electricassistant.setting_gauge_activity.GaugeSettingActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DashboardFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DashboardFragment extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DashboardFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DashboardFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DashboardFragment newInstance(String param1, String param2) {
        DashboardFragment fragment = new DashboardFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    final private Handler handler = new Handler();
    private com.ekndev.gaugelibrary.ArcGauge guage;
    private com.ekndev.gaugelibrary.Range range1;
    private com.ekndev.gaugelibrary.Range range2;
    private com.ekndev.gaugelibrary.Range range3;
    private ViewStub stub;
    private ViewStub stub2;
    private FloatingActionButton floatBtn;
    private Button refresh_btn;
    private boolean remove = false;
    private GeneralDisplayData generalDisplayData;
    private CostOfElectricityDisplayData costOfElectricityDisplayData;
    private TextView home_title_tv;

    //set gauge type to setting informaton layout
    private int gaugeType = 2;

    //for usage layout components
    private TextView usage_usagelayout_value_tv;
    private TextView max_usage_usagelayout_value_tv;
    private TextView max_usage_usagelayout_when_value_tv;
    private TextView min_usage_usagelayout_value_tv;
    private TextView min_usage_usagelayout_when_value_tv;
    private TextView average_usagelayout_value_tv;

    //for cost of usage layout components
    private TextView typeusage_costusagelayout_value_tv;
    private TextView reachusage_costusagelayout_value_tv;
    private TextView totalcost_costusagelayout_value_tv;
    private TextView max_cost_costusagelayout_value_tv;
    private TextView max_cost_costusagelayout_when_value_tv;
    private TextView min_cost_costusagelayout_value_tv;
    private TextView min_cost_costusagelayout_when_value_tv;
    private TextView average_costusagelayout_value_tv;


    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            generalDisplayData.generateValue();
            guage.setValue(generalDisplayData.getValue());
            if (gaugeType == 1) {
                usage_usagelayout_value_tv.setText(String.valueOf(generalDisplayData.getValue()));
                max_usage_usagelayout_value_tv.setText(String.valueOf(generalDisplayData.getMax()));
                min_usage_usagelayout_value_tv.setText(String.valueOf(generalDisplayData.getMin()));
                average_usagelayout_value_tv.setText(String.valueOf(generalDisplayData.getAverage()));
            } else if (gaugeType == 2) {
                String thbStr = " THB";
                reachusage_costusagelayout_value_tv.setText((String.valueOf(costOfElectricityDisplayData.getReachedOfCost()))+thbStr);
                totalcost_costusagelayout_value_tv.setText(String.valueOf(costOfElectricityDisplayData.getValue())+thbStr);
                max_cost_costusagelayout_value_tv.setText((String.valueOf(costOfElectricityDisplayData.getMax()))+thbStr);
                min_cost_costusagelayout_value_tv.setText((String.valueOf(costOfElectricityDisplayData.getMin()))+thbStr);
                average_costusagelayout_value_tv.setText(String.valueOf(costOfElectricityDisplayData.getAverage())+thbStr);
            }
            if (remove)
                handler.removeCallbacks(this::run);
            else
                handler.postDelayed(this::run, 1000);
        }
    };

    private void setRange(int rangeMin, int rangeMax) {
        range1 = new Range();
        range1.setColor(Color.rgb(255, 255, 0));
        range1.setFrom(rangeMin);
        range1.setTo(rangeMax / 2);

        range2 = new Range();
        range2.setColor(Color.rgb(0, 255, 0));
        range2.setFrom(rangeMax / 2 + 1);
        range2.setTo((int) (rangeMax * 0.9));

        range3 = new Range();
        range3.setColor(Color.rgb(255, 0, 0));
        range3.setFrom((int) (rangeMax * 0.9) + 1);
        range3.setTo(rangeMax);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_dashboard, container, false);

        //Example eleciticy data for testing
        costOfElectricityDisplayData = new CostOfElectricityDisplayData(0, 25, 100, null, null,
                50, 0, 200, "Type 01 : Not above 150 unit", 250, false);
        generalDisplayData = (GeneralDisplayData) costOfElectricityDisplayData;

        //Testing generate time
        LocalDateTime maxWhen = LocalDateTime.of(2022, 6, 15, 15, 56);
        LocalDateTime minWhen = LocalDateTime.of(2022, 4, 30, 15, 56);
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");


        //inflate usage_layout to dashboard fragment
        stub = v.findViewById(R.id.layout_stub);
        if (gaugeType == 1) {
            stub.setLayoutResource(R.layout.usage_layout);
            View inflated = stub.inflate();
            usage_usagelayout_value_tv = inflated.findViewById(R.id.usage_usagelayout_value_tv);
            usage_usagelayout_value_tv.setText("0");
            max_usage_usagelayout_value_tv = inflated.findViewById(R.id.max_usage_usagelayout_value_tv);
            max_usage_usagelayout_value_tv.setText("0");
            max_usage_usagelayout_when_value_tv = inflated.findViewById(R.id.max_usage_usagelayout_when_value_tv);
            max_usage_usagelayout_when_value_tv.setText(maxWhen.format(format));
            min_usage_usagelayout_value_tv = inflated.findViewById(R.id.min_usage_usagelayout_value_tv);
            min_usage_usagelayout_value_tv.setText("0");
            min_usage_usagelayout_when_value_tv = inflated.findViewById(R.id.min_usage_usagelayout_when_value_tv);
            min_usage_usagelayout_when_value_tv.setText(minWhen.format(format));
            average_usagelayout_value_tv = inflated.findViewById(R.id.average_usagelayout_value_tv);
        } else if (gaugeType == 2) {
            stub.setLayoutResource(R.layout.cost_usage_layout);
            View inflated = stub.inflate();
            typeusage_costusagelayout_value_tv = inflated.findViewById(R.id.typeusage_costusagelayout_value_tv);
            typeusage_costusagelayout_value_tv.setText(costOfElectricityDisplayData.getTypeOfUse());
            reachusage_costusagelayout_value_tv = inflated.findViewById(R.id.reachusage_costusagelayout_value_tv);
            totalcost_costusagelayout_value_tv = inflated.findViewById(R.id.totalcost_costusagelayout_value_tv);
            max_cost_costusagelayout_value_tv = inflated.findViewById(R.id.max_cost_costusagelayout_value_tv);
            max_cost_costusagelayout_when_value_tv = inflated.findViewById(R.id.max_cost_costusagelayout_when_value_tv);
            max_cost_costusagelayout_when_value_tv.setText(maxWhen.format(format));
            min_cost_costusagelayout_value_tv = inflated.findViewById(R.id.min_cost_costusagelayout_value_tv);
            min_cost_costusagelayout_when_value_tv = inflated.findViewById(R.id.min_cost_costusagelayout_when_value_tv);
            min_cost_costusagelayout_when_value_tv.setText(minWhen.format(format));
            average_costusagelayout_value_tv = inflated.findViewById(R.id.average_costusagelayout_value_tv);
        }


        stub2 = v.findViewById(R.id.layout_stub2);
        stub2.setLayoutResource(R.layout.arcgauge_display_layout);
        View inflated2 = stub2.inflate();


        int rangeMin = (int) generalDisplayData.getRangeMin();
        int rangeMax = (int) generalDisplayData.getRangeMax();
        setRange(rangeMin, rangeMax);

        guage = inflated2.findViewById(R.id.arcguage_01);
        guage.setValue(0);
        guage.setMinValue(rangeMin);
        guage.setMaxValue(rangeMax);
        guage.addRange(range1);
        guage.addRange(range2);
        guage.addRange(range3);


        floatBtn = inflated2.findViewById(R.id.setting_guage_btn);
        floatBtn.setOnClickListener(this::onClick);

        refresh_btn = v.findViewById(R.id.refresh_btn);
        refresh_btn.setOnClickListener(this::onClick);

        home_title_tv = v.findViewById(R.id.home_title_tv);


        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (GlobalData.homeSelected != null) {
            home_title_tv.setText(GlobalData.homeSelected.getName());
            remove = false;
            handler.postDelayed(runnable, 1000);
        } else {
            remove = true;
            handler.removeCallbacks(runnable);
            DialogTemplate.generateDialog(getActivity());
        }


    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.setting_guage_btn) {
            Intent intent = new Intent(getActivity(), GaugeSettingActivity.class);
            startActivity(intent);
        }
        if (view.getId() == R.id.refresh_btn) {
            Toast.makeText(getActivity(), "Refreshing", Toast.LENGTH_SHORT).show();
            guage.setValue(new Random().nextInt(1000) + 1);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        remove = true;
        handler.removeCallbacks(runnable);

    }
}