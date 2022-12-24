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

import com.example.electricassistant.data.HomeData;
import com.example.electricassistant.data_enum.MeasureEnum;
import com.example.electricassistant.data_enum.VoltageEnum;
import com.example.electricassistant.R;
import com.example.electricassistant.dialog.DialogTemplate;
import com.example.electricassistant.global_data.GlobalData;

public class EditHomeActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText home_edit_home_et, address_edit_home_et;
    private EditText homepic_url_title_edit_home_et;
    private Switch monitoring_edit_home_switch;
    private Spinner voltage_edit_home_spinner;
    private Spinner measure_edit_home_spinner;
    private Button cancel_edit_home_btn;
    private Button adding_edit_home_btn;

    private AlertDialog.Builder confirmToEditDialog;

    private Bundle editBundle;
    private HomeData resultHomeData;
    private String[] voltages = VoltageEnum.toArray(VoltageEnum.class);
    private int voltageIndexSpinner = -1;
    private String[] measures = MeasureEnum.toArray(MeasureEnum.class);
    private int measureIndexSpinner = -1;
    private int item;
    private int selectedIndex = -1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_home);
        getSupportActionBar().setTitle("Edit home");

        editBundle = getIntent().getExtras();
        selectedIndex = editBundle.getInt("infoIndex");

        cancel_edit_home_btn = findViewById(R.id.cancel_edit_home_btn);
        cancel_edit_home_btn.setOnClickListener(this::onClick);
        adding_edit_home_btn = findViewById(R.id.adding_edit_home_btn);
        adding_edit_home_btn.setOnClickListener(this::onClick);

        home_edit_home_et = findViewById(R.id.home_edit_home_et);
        address_edit_home_et = findViewById(R.id.address_edit_home_et);
        monitoring_edit_home_switch = findViewById(R.id.monitoring_edit_home_switch);
        homepic_url_title_edit_home_et = findViewById(R.id.homepic_url_title_edit_home_et);

        resultHomeData = GlobalData.currentUserData.getArrHomeData().get(selectedIndex);
        if (resultHomeData != null) {
            home_edit_home_et.setText(resultHomeData.getName());
            address_edit_home_et.setText(resultHomeData.getAddress());
            monitoring_edit_home_switch.setChecked(resultHomeData.isMonitoring());
            homepic_url_title_edit_home_et.setText(resultHomeData.getUrlOfHome());
        }

        VoltageEnum voltageEnum = resultHomeData.getVoltage();
        if(voltageEnum == VoltageEnum._110v){
            voltageIndexSpinner = 0;
        }else if(voltageEnum == VoltageEnum._220v){
            voltageIndexSpinner = 1;
        }else{
            voltageIndexSpinner = 2;
        }
        MeasureEnum measureEnum = resultHomeData.getMeasure();
        if (measureEnum == MeasureEnum.Not_Above_150) {
            measureIndexSpinner = 0;
        } else if (measureEnum == MeasureEnum.Above_150) {
            measureIndexSpinner = 1;
        } else {
            measureIndexSpinner = 2;
        }

        voltage_edit_home_spinner = findViewById(R.id.voltage_edit_home_spinner);

        ArrayAdapter<String> spinnerVoltageArrayAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, voltages);
        spinnerVoltageArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        voltage_edit_home_spinner.setAdapter(spinnerVoltageArrayAdapter);
        voltage_edit_home_spinner.setSelection(voltageIndexSpinner);

        measure_edit_home_spinner = findViewById(R.id.measure_edit_home_spinner);

        ArrayAdapter<String> spinnerMeasureArrayAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, measures);
        spinnerMeasureArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        measure_edit_home_spinner.setAdapter(spinnerMeasureArrayAdapter);
        measure_edit_home_spinner.setSelection(measureIndexSpinner);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.cancel_edit_home_btn:
                finish();
                break;
            case R.id.adding_edit_home_btn:
                updateHomeDataToGlobal();
                break;
            default:
                break;
        }
    }


    private void updateHomeDataToGlobal() {
        HomeData selectedHomeForUpdate;

        if (selectedIndex != -1) {
            selectedHomeForUpdate = GlobalData.currentUserData.getArrHomeData().get(selectedIndex);

            String homeNameToEdit = home_edit_home_et.getText().toString();
            String addressToEdit = address_edit_home_et.getText().toString();
            boolean isMnitoringToEdit = monitoring_edit_home_switch.isChecked();
            String homePicUrlToEdit = homepic_url_title_edit_home_et.getText().toString();
            String voltageStrToEdit = voltage_edit_home_spinner.getSelectedItem().toString();
            String measureStrToEdit = measure_edit_home_spinner.getSelectedItem().toString();

            VoltageEnum voltageEnumToEdit = VoltageEnum.convertVoltageEnumStrToEnum(voltageStrToEdit);
            MeasureEnum measureEnumToEdit = MeasureEnum.convertMeasureEnumStrToEnum(measureStrToEdit);

            String homeDataResultStr = "Home name : " + homeNameToEdit + "\n" +
                    "Address : " + addressToEdit + "\n" +
                    "Voltage  : " + voltageStrToEdit + "\n" +
                    "MeasureStr   : " + measureStrToEdit + "\n" +
                    "Monitoring : " + (isMnitoringToEdit ? "Yes" : "No") + "\n" +
                    "HomeUrl   : " + homePicUrlToEdit + "\n";
            confirmToEditDialog = new DialogTemplate().generateConfirmToEditHomeDialog(this,String.valueOf(homeDataResultStr));
            confirmToEditDialog.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                    selectedHomeForUpdate.setName(home_edit_home_et.getText().toString());
                    selectedHomeForUpdate.setAddress(address_edit_home_et.getText().toString());
                    selectedHomeForUpdate.setMonitoring(monitoring_edit_home_switch.isChecked());
                    selectedHomeForUpdate.setUrlOfHome(homepic_url_title_edit_home_et.getText().toString());
                    selectedHomeForUpdate.setVoltage(voltageEnumToEdit);
                    selectedHomeForUpdate.setMeasure(measureEnumToEdit);
                    dialogInterface.dismiss();
                    finish();
                }
            });
            confirmToEditDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });
            confirmToEditDialog.show();



        }

    }


}