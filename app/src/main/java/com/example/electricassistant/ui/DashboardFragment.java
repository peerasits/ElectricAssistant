package com.example.electricassistant.ui;

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

import com.ekndev.gaugelibrary.HalfGauge;
import com.ekndev.gaugelibrary.Range;
import com.example.electricassistant.data_enum.GuageTypeEnum;
import com.example.electricassistant.data_enum.MeasureEnum;
import com.example.electricassistant.display_data.CostOfElectricityDisplayData;
import com.example.electricassistant.display_data.GeneralDisplayData;
import com.example.electricassistant.display_data.VoltageDisplayData;
import com.example.electricassistant.global_data.GlobalData;
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
    private com.ekndev.gaugelibrary.ArcGauge arcGauge;
    private HalfGauge halfGauge;
    private com.ekndev.gaugelibrary.Range range1;
    private com.ekndev.gaugelibrary.Range range2;
    private com.ekndev.gaugelibrary.Range range3;
    private ViewStub stub;
    private ViewStub stub2;
    private FloatingActionButton floatBtn;
    private Button refresh_btn;
    private boolean remove = false;

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

    //for gauge title
    private TextView total_title_tv;



    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            GeneralDisplayData generalDisplayDataObject = GlobalData.currentUserData.getHomeSelected().getDisplayData();
            generalDisplayDataObject.generateValue();

            if (gaugeType == 1) {
                arcGauge.setValue(generalDisplayDataObject.getValue());
                //GeneralDisplayData generalDisplayDataObject = GlobalData.currentUserData.getDisplayData();
                usage_usagelayout_value_tv.setText(String.valueOf(generalDisplayDataObject.getValue()));
                max_usage_usagelayout_value_tv.setText(String.valueOf(generalDisplayDataObject.getMax()));
                min_usage_usagelayout_value_tv.setText(String.valueOf(generalDisplayDataObject.getMin()));
                average_usagelayout_value_tv.setText(String.valueOf(generalDisplayDataObject.getAverage()));
            } else if (gaugeType == 2) {
                arcGauge.setValue(generalDisplayDataObject.getValue());
                String thbStr = " THB";
                CostOfElectricityDisplayData costOfElectricityDisplayDataObject = (CostOfElectricityDisplayData) GlobalData.currentUserData.getHomeSelected().getDisplayData();
                reachusage_costusagelayout_value_tv.setText((String.valueOf(costOfElectricityDisplayDataObject.getReachedOfCost())) + thbStr);
                totalcost_costusagelayout_value_tv.setText(String.valueOf(costOfElectricityDisplayDataObject.getValue()) + thbStr);
                max_cost_costusagelayout_value_tv.setText((String.valueOf(costOfElectricityDisplayDataObject.getMax())) + thbStr);
                min_cost_costusagelayout_value_tv.setText((String.valueOf(costOfElectricityDisplayDataObject.getMin())) + thbStr);
                average_costusagelayout_value_tv.setText(String.valueOf(costOfElectricityDisplayDataObject.getAverage()) + thbStr);
            }else if(gaugeType == 3){
                halfGauge.setValue(generalDisplayDataObject.getValue());
            }
            if (remove)
                handler.removeCallbacks(this::run);
            else
                handler.postDelayed(this::run, 1000);
        }
    };

    private void setRange(int rangeMin, int rangeMax) {
        range1 = new Range();
        range1.setColor(Color.rgb(255, 255, 102));
        range1.setFrom(rangeMin);
        range1.setTo(rangeMax / 4);

        range2 = new Range();
        range2.setColor(Color.rgb(0, 204, 0));
        range2.setFrom(rangeMax / 4 + 1);
        range2.setTo((int) (rangeMax * 0.9));

        range3 = new Range();
        range3.setColor(Color.rgb(255, 51, 51));
        range3.setFrom((int) (rangeMax * 0.9) + 1);
        range3.setTo(rangeMax);
    }

    private void setRangeForHalfGauge(int rangeMin, int rangeMax){
        range1 = new Range();
        range1.setColor(Color.rgb(255, 255, 102));
        range1.setFrom(rangeMin);
        range1.setTo(rangeMax / 1.25);

        range2 = new Range();
        range2.setColor(Color.rgb(0, 204, 0));
        range2.setFrom(rangeMax / 1.25 + 1);
        range2.setTo((int) (rangeMax * 0.9));

        range3 = new Range();
        range3.setColor(Color.rgb(255, 51, 51));
        range3.setFrom((int) (rangeMax * 0.9) + 1);
        range3.setTo(rangeMax);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_dashboard, container, false);

        //Generate test time
        LocalDateTime maxWhen = LocalDateTime.of(2022, 6, 15, 15, 56);
        LocalDateTime minWhen = LocalDateTime.of(2022, 4, 30, 15, 56);

        CostOfElectricityDisplayData costOfElectricityDisplayData = new CostOfElectricityDisplayData(0, 25, 100, minWhen, maxWhen,
                50, 0, 200, "Type 01 : Not above 150 unit", 250, false);

        GeneralDisplayData generalDisplayData = (GeneralDisplayData) costOfElectricityDisplayData;
        //Generate time with formetter
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        VoltageDisplayData voltageDisplayData = new VoltageDisplayData(0,0,260,minWhen,maxWhen,110,0,260,220,50);



        switch (gaugeType) {
            case 1:
                GlobalData.currentUserData.setGuageType(GuageTypeEnum.ElectricityUsageGauge);
                GlobalData.currentUserData.getHomeSelected().setDisplayData(generalDisplayData);
                break;
            case 2:
                GlobalData.currentUserData.setGuageType(GuageTypeEnum.CostofElectricityUsageGauge);
                GlobalData.currentUserData.getHomeSelected().setDisplayData(costOfElectricityDisplayData);
                break;
            case 3:
                GlobalData.currentUserData.setGuageType(GuageTypeEnum.VoltageGauge);
                GlobalData.currentUserData.getHomeSelected().setDisplayData(voltageDisplayData);
            default:
                break;
        }
        View inflated2 = null;
        int rangeMin = (int) GlobalData.currentUserData.getHomeSelected().getDisplayData().getRangeMin();
        int rangeMax = (int) GlobalData.currentUserData.getHomeSelected().getDisplayData().getRangeMax();

        //inflate usage_layout to dashboard fragment
        stub = v.findViewById(R.id.layout_stub);
        if (gaugeType == 1) {
            stub2 = v.findViewById(R.id.layout_stub2);
            stub2.setLayoutResource(R.layout.arcgauge_display_layout);
            inflated2 = stub2.inflate();

            arcGauge = inflated2.findViewById(R.id.arcguage_01);
            arcGauge.setValue(0);
            arcGauge.setMinValue(rangeMin);
            arcGauge.setMaxValue(rangeMax);
            setRange(rangeMin, rangeMax);
            arcGauge.addRange(range1);
            arcGauge.addRange(range2);
            arcGauge.addRange(range3);

            stub.setLayoutResource(R.layout.usage_layout);
            View inflated = stub.inflate();
            usage_usagelayout_value_tv = inflated.findViewById(R.id.usage_usagelayout_value_tv);
            usage_usagelayout_value_tv.setText("0");
            max_usage_usagelayout_value_tv = inflated.findViewById(R.id.max_usage_usagelayout_value_tv);
            max_usage_usagelayout_value_tv.setText("0");
            max_usage_usagelayout_when_value_tv = inflated.findViewById(R.id.max_usage_usagelayout_when_value_tv);
            max_usage_usagelayout_when_value_tv.setText(GlobalData.currentUserData.getHomeSelected().getDisplayData().getWhenMax().format(formatter));
            min_usage_usagelayout_value_tv = inflated.findViewById(R.id.min_usage_usagelayout_value_tv);
            min_usage_usagelayout_value_tv.setText("0");
            min_usage_usagelayout_when_value_tv = inflated.findViewById(R.id.min_usage_usagelayout_when_value_tv);
            min_usage_usagelayout_when_value_tv.setText(GlobalData.currentUserData.getHomeSelected().getDisplayData().getWhenMin().format(formatter));
            average_usagelayout_value_tv = inflated.findViewById(R.id.average_usagelayout_value_tv);

            floatBtn = inflated2.findViewById(R.id.setting_guage_btn);
            floatBtn.setOnClickListener(this::onClick);
        } else if (gaugeType == 2) {
            stub2 = v.findViewById(R.id.layout_stub2);
            stub2.setLayoutResource(R.layout.arcgauge_display_layout);
            inflated2 = stub2.inflate();

            arcGauge = inflated2.findViewById(R.id.arcguage_01);
            arcGauge.setValue(0);
            arcGauge.setMinValue(rangeMin);
            arcGauge.setMaxValue(rangeMax);
            setRange(rangeMin, rangeMax);
            arcGauge.addRange(range1);
            arcGauge.addRange(range2);
            arcGauge.addRange(range3);

            stub.setLayoutResource(R.layout.cost_usage_layout);
            View inflated = stub.inflate();
            CostOfElectricityDisplayData cObject = (CostOfElectricityDisplayData) GlobalData.currentUserData.getHomeSelected().getDisplayData();

            String typeUsageStr;
            if(GlobalData.currentUserData.getHomeSelected().getMeasure() == MeasureEnum.Above_150){
                typeUsageStr = "Not above 150";
            }else if(GlobalData.currentUserData.getHomeSelected().getMeasure() == MeasureEnum.Not_Above_150){
                typeUsageStr = "Above 150";
            }else{
                typeUsageStr = "TOU";
            }
            typeusage_costusagelayout_value_tv = inflated.findViewById(R.id.typeusage_costusagelayout_value_tv);
            typeusage_costusagelayout_value_tv.setText(typeUsageStr);
            reachusage_costusagelayout_value_tv = inflated.findViewById(R.id.reachusage_costusagelayout_value_tv);
            totalcost_costusagelayout_value_tv = inflated.findViewById(R.id.totalcost_costusagelayout_value_tv);
            max_cost_costusagelayout_value_tv = inflated.findViewById(R.id.max_cost_costusagelayout_value_tv);
            max_cost_costusagelayout_when_value_tv = inflated.findViewById(R.id.max_cost_costusagelayout_when_value_tv);
            max_cost_costusagelayout_when_value_tv.setText(GlobalData.currentUserData.getHomeSelected().getDisplayData().getWhenMax().format(formatter));
            min_cost_costusagelayout_value_tv = inflated.findViewById(R.id.min_cost_costusagelayout_value_tv);
            min_cost_costusagelayout_when_value_tv = inflated.findViewById(R.id.min_cost_costusagelayout_when_value_tv);
            min_cost_costusagelayout_when_value_tv.setText(GlobalData.currentUserData.getHomeSelected().getDisplayData().getWhenMin().format(formatter));
            average_costusagelayout_value_tv = inflated.findViewById(R.id.average_costusagelayout_value_tv);

            floatBtn = inflated2.findViewById(R.id.setting_guage_btn);
            floatBtn.setOnClickListener(this::onClick);


        }
        else if(gaugeType == 3){
            stub2 = v.findViewById(R.id.layout_stub2);
            stub2.setLayoutResource(R.layout.halfgauge_display_layout);
            inflated2 = stub2.inflate();

            halfGauge = inflated2.findViewById(R.id.halfgauge_01);
            halfGauge.setMaxValue(rangeMin);
            halfGauge.setMaxValue(rangeMax);
            setRangeForHalfGauge(rangeMin,rangeMax);
            halfGauge.addRange(range1);
            halfGauge.addRange(range2);
            halfGauge.addRange(range3);

            floatBtn = inflated2.findViewById(R.id.setting_half_guage_btn);
            floatBtn.setOnClickListener(this::onClick);

        }

        total_title_tv = inflated2.findViewById(R.id.total_title_tv);



        if(GlobalData.currentUserData.getGuageType() == GuageTypeEnum.ElectricityUsageGauge)
            total_title_tv.setText("Total usage (KWh)");
        else if(GlobalData.currentUserData.getGuageType() == GuageTypeEnum.CostofElectricityUsageGauge)
            total_title_tv.setText("Total price of usage (baht)");
        else if (GlobalData.currentUserData.getGuageType() == GuageTypeEnum.VoltageGauge)
            total_title_tv.setText("Voltage (volt)");



        refresh_btn = v.findViewById(R.id.refresh_btn);
        refresh_btn.setOnClickListener(this::onClick);

        home_title_tv = v.findViewById(R.id.home_title_tv);
        home_title_tv.setText(GlobalData.currentUserData.getHomeSelected().getName());

        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (GlobalData.currentUserData.getHomeSelected() != null) {
            remove = false;
            handler.postDelayed(runnable, 1000);
        } else {
            remove = true;
            handler.removeCallbacks(runnable);
            new DialogTemplate().generateDialog(getActivity());
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
            arcGauge.setValue(new Random().nextInt(1000) + 1);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        remove = true;
        handler.removeCallbacks(runnable);

    }
}