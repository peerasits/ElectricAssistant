package com.example.electricassistant.appliance_device;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import com.example.electricassistant.R;
import com.example.electricassistant.data.AmountOfHour;
import com.example.electricassistant.data.ApplianceData;
import com.example.electricassistant.data.CurrentUnitEnum;
import com.example.electricassistant.data.TypeOfApplianceEnum;
import com.example.electricassistant.data.VoltageEnum;

public class AddApplianceActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText name_appliance_add_et;
    private EditText description_appliance_add_et;
    private EditText current_value_appliance_app_et;
    private Switch monitoring_appliance_add_sw;
    private Switch notification_appliance_sw;
    private Switch limit_hours_appliance_sw;
    private CheckBox current_sensor_appliance_chb;
    private CheckBox voltage_sensor_appliance_add_chb;
    private Spinner type_appliance_add_spinner;
    private Spinner current_unit_add_spinner;
    private Spinner amount_hour_appliance_spinner;
    private Button add_appliance_add_btn;

    private int defaultTypeOfAppliance;
    private int item;
    private String[] typeOfApplianceArr;
    private String[] currentUnitArr;
    private String[] amountOfHour;
    private ApplianceData applianceData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_appliance_data);
        getSupportActionBar().setTitle("Add electricity appliance");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        typeOfApplianceArr = TypeOfApplianceEnum.toArray(TypeOfApplianceEnum.class);
        defaultTypeOfAppliance = typeOfApplianceArr.length-1;
        currentUnitArr = VoltageEnum.toArray(CurrentUnitEnum.class);
        amountOfHour = CurrentUnitEnum.toArray(AmountOfHour.class);

        name_appliance_add_et = findViewById(R.id.name_appliance_add_et);
        description_appliance_add_et = findViewById(R.id.description_appliance_add_et);
        current_value_appliance_app_et = findViewById(R.id.current_value_appliance_app_et);
        type_appliance_add_spinner = findViewById(R.id.type_appliance_add_spinner);
        monitoring_appliance_add_sw = findViewById(R.id.monitoring_appliance_add_sw);
        notification_appliance_sw = findViewById(R.id.notification_appliance_sw);
        limit_hours_appliance_sw = findViewById(R.id.limit_hours_appliance_sw);
        current_sensor_appliance_chb = findViewById(R.id.current_sensor_appliance_chb);
        voltage_sensor_appliance_add_chb = findViewById(R.id.voltage_sensor_appliance_add_chb);
        current_unit_add_spinner = findViewById(R.id.current_unit_add_spinner);
        amount_hour_appliance_spinner = findViewById(R.id.amount_hour_appliance_spinner);
        add_appliance_add_btn = findViewById(R.id.add_appliance_add_btn);

        monitoring_appliance_add_sw.setChecked(true);
        current_sensor_appliance_chb.setChecked(true);

        ArrayAdapter<String> spinnerTypeOfApplianceArrayAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item,typeOfApplianceArr);
        spinnerTypeOfApplianceArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        type_appliance_add_spinner.setAdapter(spinnerTypeOfApplianceArrayAdapter);
        item = spinnerTypeOfApplianceArrayAdapter.getPosition(typeOfApplianceArr[defaultTypeOfAppliance]);
        type_appliance_add_spinner.setSelection(item);

        ArrayAdapter<String> spinnerCurrentUnitArrayAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, currentUnitArr);
        spinnerCurrentUnitArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        current_unit_add_spinner.setAdapter(spinnerCurrentUnitArrayAdapter);
        item = spinnerTypeOfApplianceArrayAdapter.getPosition(currentUnitArr[0]);
        current_unit_add_spinner.setSelection(item);

        ArrayAdapter<String> spinnerAmountOfHourArrayAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item,amountOfHour);
        spinnerAmountOfHourArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        amount_hour_appliance_spinner.setAdapter(spinnerAmountOfHourArrayAdapter);
        item = spinnerAmountOfHourArrayAdapter.getPosition("1");
        amount_hour_appliance_spinner.setSelection(item);

        add_appliance_add_btn.setOnClickListener(this::onClick);

    }



    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.add_appliance_add_btn:
                finish();
                return true;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.add_appliance_add_btn:
                String nameToAddStr = name_appliance_add_et.getText().toString();
                String typeOfAplianceToAddStr = type_appliance_add_spinner.getSelectedItem().toString();
                String descriptionToAddStr = description_appliance_add_et.getText().toString();
                boolean monitoringToAddBool = monitoring_appliance_add_sw.isChecked();
                boolean currentSensorToAddBool = current_sensor_appliance_chb.isChecked();
                String currentValueToAddStr = current_value_appliance_app_et.getText().toString();
                boolean voltageSencorToAddBool = voltage_sensor_appliance_add_chb.isChecked();
                boolean notificationToAddBool = notification_appliance_sw.isChecked();
                boolean limitHourToAddBool = limit_hours_appliance_sw.isChecked();
                String amountOfHourToAddStr = amount_hour_appliance_spinner.getSelectedItem().toString();


                String resultToBeToast = nameToAddStr+ " " + typeOfAplianceToAddStr+" "+descriptionToAddStr+" "+String.valueOf(monitoringToAddBool)+
                        String.valueOf(currentSensorToAddBool)+" "+currentValueToAddStr+" "+String.valueOf(voltageSencorToAddBool)+
                        String.valueOf(notificationToAddBool)+" "+String.valueOf(limitHourToAddBool)+" "+amountOfHourToAddStr;
                Toast.makeText(getApplicationContext(),resultToBeToast, Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}