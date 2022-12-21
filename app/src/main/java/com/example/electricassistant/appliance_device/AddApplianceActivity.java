package com.example.electricassistant.appliance_device;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import com.example.electricassistant.R;
import com.example.electricassistant.data.TypeOfApplianceEnum;

public class AddApplianceActivity extends AppCompatActivity {

    private EditText name_appliance_add_et;
    private EditText description_appliance_add_et;
    private Switch monitoring_appliance_add_sw;
    private CheckBox current_sensor_appliance_chb;
    private CheckBox voltage_sensor_appliance_add_chb;
    private Spinner type_appliance_add_spinner;

    private int defaultTypeOfAppliance;
    private int item;
    String[] typeOfApplianceArr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_appliance_data);
        getSupportActionBar().setTitle("Add electricity appliance");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        typeOfApplianceArr = TypeOfApplianceEnum.toArray(TypeOfApplianceEnum.class);
        defaultTypeOfAppliance = typeOfApplianceArr.length-1;

        name_appliance_add_et = findViewById(R.id.name_appliance_add_et);
        description_appliance_add_et = findViewById(R.id.description_appliance_add_et);
        type_appliance_add_spinner = findViewById(R.id.type_appliance_add_spinner);
        monitoring_appliance_add_sw = findViewById(R.id.monitoring_appliance_add_sw);
        current_sensor_appliance_chb = findViewById(R.id.current_sensor_appliance_chb);
        voltage_sensor_appliance_add_chb = findViewById(R.id.voltage_sensor_appliance_add_chb);

        monitoring_appliance_add_sw.setChecked(true);
        current_sensor_appliance_chb.setChecked(true);

        ArrayAdapter<String> spinnerTypeOfApplianceArrayAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item,typeOfApplianceArr);
        spinnerTypeOfApplianceArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        type_appliance_add_spinner.setAdapter(spinnerTypeOfApplianceArrayAdapter);
        item = spinnerTypeOfApplianceArrayAdapter.getPosition(typeOfApplianceArr[defaultTypeOfAppliance]);
        type_appliance_add_spinner.setSelection(item);


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.home:
                finish();
                return true;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}