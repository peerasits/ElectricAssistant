package com.example.electricassistant.home;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;


import com.example.electricassistant.global_data.GlobalData;
import com.example.electricassistant.Data.HomeData;
import com.example.electricassistant.R;

public class AddHomeActivity extends AppCompatActivity implements View.OnClickListener {

    private Spinner voltage_add_home_spinner;
    private Spinner measure_add_home_spinner;
    private EditText home_add_home_et,address_add_home_et;
    private Button cancel_add_home_btn,ok_add_home_btn;
    private Switch monitoring_add_home_switch;
    private String[] voltages = {"110v","220v"};
    private String[] measures = {"Not above 150","Above 150","TOU : Time of Use Tariff"};
    private int item;
    private String homeNameStr,addressStr;
    private String voltageStr,typeStr;
    private boolean isMonitoring;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_home);

        getSupportActionBar().setTitle("Add home");

        voltage_add_home_spinner = findViewById(R.id.voltage_edit_home_spinner);
        ArrayAdapter<String> spinnerVoltageArrayAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, voltages);
        spinnerVoltageArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        voltage_add_home_spinner.setAdapter(spinnerVoltageArrayAdapter);
        item = spinnerVoltageArrayAdapter.getPosition("220v");
        voltage_add_home_spinner.setSelection(item);

        measure_add_home_spinner = findViewById(R.id.measure_edit_home_spinner);
        ArrayAdapter<String> spinnerMeasureArrayAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, measures);
        spinnerMeasureArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        measure_add_home_spinner.setAdapter(spinnerMeasureArrayAdapter);
        item = spinnerMeasureArrayAdapter.getPosition("Above 150");
        measure_add_home_spinner.setSelection(item);

        home_add_home_et = findViewById(R.id.home_edit_home_et);
        address_add_home_et = findViewById(R.id.address_edit_home_et);
        cancel_add_home_btn = findViewById(R.id.cancel_edit_home_btn);
        cancel_add_home_btn.setOnClickListener(this::onClick);
        ok_add_home_btn = findViewById(R.id.ok_edit_home_btn);
        ok_add_home_btn.setOnClickListener(this::onClick);
        monitoring_add_home_switch = findViewById(R.id.monitoring_edit_home_switch);
        monitoring_add_home_switch.setChecked(true);


    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.cancel_edit_home_btn:
                finish();
                break;
            case R.id.ok_edit_home_btn:
                homeNameStr = home_add_home_et.getText().toString();
                addressStr = address_add_home_et.getText().toString();
                voltageStr = voltage_add_home_spinner.getSelectedItem().toString();
                typeStr = measure_add_home_spinner.getSelectedItem().toString();
                isMonitoring = monitoring_add_home_switch.isChecked();
                if(homeNameStr != null && addressStr != null){
                    Toast.makeText(getApplication(), homeNameStr+" : "+addressStr+" : "+voltageStr+" : "+typeStr+" : "+String.valueOf(isMonitoring), Toast.LENGTH_SHORT).show();
                    HomeData homeData = new HomeData(homeNameStr,addressStr,typeStr,isMonitoring,null);
                    if(GlobalData.currentUserData.getArrHomeData() != null){
                        GlobalData.currentUserData.getArrHomeData().add(homeData);

                    }
                    finish();
                }
                break;
            default:
                Toast.makeText(getApplication(), "default case", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}