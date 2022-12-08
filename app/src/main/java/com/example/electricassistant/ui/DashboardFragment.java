package com.example.electricassistant.ui;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.Toast;

import com.ekndev.gaugelibrary.Range;
import com.example.electricassistant.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

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

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            guage.setValue(new Random().nextInt(1000)+1);
            if(remove)
                handler.removeCallbacks(this::run);
            else
                handler.postDelayed(this::run,1000);
        }
    };

    private void setRange(){
        range1 = new Range();
        range1.setColor(Color.rgb(255,255,0));
        range1.setFrom(0);
        range1.setTo(500);

        range2 = new Range();
        range2.setColor(Color.rgb(0,255,0));
        range2.setFrom(501);
        range2.setTo(900);

        range3 = new Range();
        range3.setColor(Color.rgb(255,0,0));
        range3.setFrom(901);
        range3.setTo(1000);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_dashboard, container, false);
        setRange();

        stub = v.findViewById(R.id.layout_stub);
        stub.setLayoutResource(R.layout.usage_layout);
        View inflated = stub.inflate();

        stub2 = v.findViewById(R.id.layout_stub2);
        stub2.setLayoutResource(R.layout.arcgauge_display_layout);
        View inflated2 = stub2.inflate();


        guage = inflated2.findViewById(R.id.arcguage_01);
        guage.setValue(0);
        guage.setMaxValue(1000);
        guage.setMinValue(0);
        guage.addRange(range1);
        guage.addRange(range2);
        guage.addRange(range3);

        floatBtn = inflated2.findViewById(R.id.setting_guage_btn);
        floatBtn.setOnClickListener(this::onClick);

        refresh_btn = v.findViewById(R.id.refresh_btn);
        refresh_btn.setOnClickListener(this::onClick);

        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        remove = false;
        handler.postDelayed(runnable,1000);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.setting_guage_btn){
            Toast.makeText(getActivity(), "Hello world", Toast.LENGTH_SHORT).show();
        }
        if(view.getId() == R.id.refresh_btn){
            Toast.makeText(getActivity(), "Refreshing", Toast.LENGTH_SHORT).show();
            guage.setValue(new Random().nextInt(1000)+1);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        remove = true;
        handler.removeCallbacks(runnable);

    }
}