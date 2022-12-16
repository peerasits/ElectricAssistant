package com.example.electricassistant.home;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.example.electricassistant.Data.HomeData;
import com.example.electricassistant.R;
import com.example.electricassistant.global_data.GlobalData;

import java.util.List;

public class EditHomeActivity extends AppCompatActivity implements View.OnClickListener {

    private Button cancel_edit_home_btn,ok_edit_home_btn;
    private Bundle editBundle;
    private String getSelectedHomeName,getSelectedHomeAddress;
    private HomeData resultHomeData;
    private int resultHomeDataIndex = -1;

    private EditText home_edit_home_et,address_edit_home_et;
    private Switch monitoring_edit_home_switch;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_home);
        getSupportActionBar().setTitle("Edit home");

        editBundle = getIntent().getExtras();
        getSelectedHomeName = editBundle.getString("selectedHomeName");
        getSelectedHomeAddress = editBundle.getString("selectedHomeAddress");

        cancel_edit_home_btn = findViewById(R.id.cancel_edit_home_btn);
        cancel_edit_home_btn.setOnClickListener(this::onClick);
        ok_edit_home_btn = findViewById(R.id.ok_edit_home_btn);
        ok_edit_home_btn.setOnClickListener(this::onClick);

        home_edit_home_et = findViewById(R.id.home_edit_home_et);
        address_edit_home_et = findViewById(R.id.address_edit_home_et);
        monitoring_edit_home_switch = findViewById(R.id.monitoring_edit_home_switch);

        resultHomeData = findHomeDataFromGlobal();
        if(resultHomeData!= null){
            home_edit_home_et.setText(resultHomeData.getName());
            address_edit_home_et.setText(resultHomeData.getAddress());
            monitoring_edit_home_switch.setChecked(resultHomeData.isMonitoring());
        }
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.cancel_edit_home_btn:
                finish();
                break;
            case R.id.ok_edit_home_btn:
                updateHomeDataToGlobal();
                finish();
                break;
            default:
                break;
        }
    }

    private HomeData findHomeDataFromGlobal(){
        int arrHomeSize = GlobalData.currentUserData.getArrHomeData().size();
        List<HomeData> selectedHomeForFinding = GlobalData.currentUserData.getArrHomeData();
        HomeData resultHomeData = null;
        for(int i = 0 ; i<arrHomeSize;i++) {

            String resultHomeName = selectedHomeForFinding.get(i).getName();
            String resultHomeAddress = selectedHomeForFinding.get(i).getAddress();
            //Log.d("EditHome",resultHomeName);
            //Log.d("EditAddress",resultHomeAddress);
            if(resultHomeName.equals(getSelectedHomeName) && resultHomeAddress.equals(getSelectedHomeAddress)){
                resultHomeData = selectedHomeForFinding.get(i);
                resultHomeDataIndex = i;
            }
        }
        return resultHomeData;
    }

    private void updateHomeDataToGlobal(){
        HomeData selectedHomeForUpdate;
        if(resultHomeDataIndex!= -1) {
           selectedHomeForUpdate = GlobalData.currentUserData.getArrHomeData().get(resultHomeDataIndex);
           selectedHomeForUpdate.setName(home_edit_home_et.getText().toString());
           selectedHomeForUpdate.setAddress(address_edit_home_et.getText().toString());
           selectedHomeForUpdate.setMonitoring(monitoring_edit_home_switch.isChecked());
        }

    }
}