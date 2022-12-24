package com.example.electricassistant.home;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;


import com.example.electricassistant.data_enum.MeasureEnum;
import com.example.electricassistant.data_enum.VoltageEnum;
import com.example.electricassistant.dialog.DialogTemplate;
import com.example.electricassistant.global_data.GlobalData;
import com.example.electricassistant.data.HomeData;
import com.example.electricassistant.R;

public class AddHomeActivity extends AppCompatActivity implements View.OnClickListener {

    private Spinner voltage_add_home_spinner;
    private Spinner measure_add_home_spinner;
    private EditText name_add_home_et, address_add_home_et;
    private EditText homepic_url_title_add_home_et;
    private Button cancel_add_home_btn, ok_add_home_btn;
    private Switch monitoring_add_home_switch;

    private String[] voltages = VoltageEnum.toArray(VoltageEnum.class);
    private final int defaultVoltageIndex = 1;
    private String[] measures = MeasureEnum.toArray(MeasureEnum.class);
    private final int defaultMeasureIndex = 1;
    private int item;
    private String homeNameStr, addressStr;
    private String voltageStr, measureStr;
    private String homeUrl;
    private boolean isMonitoring;

    //Dialog section
    private AlertDialog.Builder summaryDialog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_home);

        getSupportActionBar().setTitle("Add home");


        voltage_add_home_spinner = findViewById(R.id.voltage_add_home_spinner);
        measure_add_home_spinner = findViewById(R.id.measure_add_home_spinner);
        initHomeSpinner();


        name_add_home_et = findViewById(R.id.name_add_home_et);
        address_add_home_et = findViewById(R.id.address_add_home_et);
        cancel_add_home_btn = findViewById(R.id.cancel_add_home_btn);
        cancel_add_home_btn.setOnClickListener(this::onClick);
        ok_add_home_btn = findViewById(R.id.Adding_add_home_btn);
        ok_add_home_btn.setOnClickListener(this::onClick);
        monitoring_add_home_switch = findViewById(R.id.monitoring_add_home_switch);
        monitoring_add_home_switch.setChecked(true);

        homepic_url_title_add_home_et = findViewById(R.id.homepic_url_title_add_home_et);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.cancel_add_home_btn:
                finish();
                break;
            case R.id.Adding_add_home_btn:
                homeNameStr = name_add_home_et.getText().toString();
                addressStr = address_add_home_et.getText().toString();
                voltageStr = voltage_add_home_spinner.getSelectedItem().toString();
                measureStr = measure_add_home_spinner.getSelectedItem().toString();
                isMonitoring = monitoring_add_home_switch.isChecked();
                homeUrl = homepic_url_title_add_home_et.getText().toString();
                MeasureEnum resultMeasure = MeasureEnum.convertMeasureEnumStrToEnum(measureStr);
                VoltageEnum resultVoltage = VoltageEnum.convertVoltageEnumStrToEnum(voltageStr);

                HomeData homeData = new HomeData(homeNameStr, addressStr, resultMeasure, resultVoltage, isMonitoring, null,null,homeUrl);


                summaryDialog = new DialogTemplate().generateSummaryAddHomeDialog(this,homeData.toString());
                summaryDialog.setPositiveButton("CONFIRM", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (GlobalData.currentUserData.getArrHomeData() != null) {
                            GlobalData.currentUserData.getArrHomeData().add(homeData);
                        }else{
                            Toast.makeText(getApplicationContext(), "Error to add this home.", Toast.LENGTH_SHORT).show();
                        }
                        finish();
                    }
                });
                summaryDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        finish();
                    }
                });
                summaryDialog.show();

                break;
            default:
                Toast.makeText(getApplication(), "Default case", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private void initHomeSpinner(){
        ArrayAdapter<String> spinnerMeasureArrayAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, measures);
        spinnerMeasureArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        measure_add_home_spinner.setAdapter(spinnerMeasureArrayAdapter);
        item = spinnerMeasureArrayAdapter.getPosition(measures[defaultMeasureIndex]);
        measure_add_home_spinner.setSelection(item);

        ArrayAdapter<String> spinnerVoltageArrayAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, voltages);
        spinnerVoltageArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        voltage_add_home_spinner.setAdapter(spinnerVoltageArrayAdapter);
        item = spinnerVoltageArrayAdapter.getPosition(voltages[defaultVoltageIndex]);
        voltage_add_home_spinner.setSelection(item);
    }




}