package com.example.electricassistant.appliance_device;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.electricassistant.R;
import com.example.electricassistant.profile.ProfileActivity;
import com.example.electricassistant.setting_activity.DataSettingActivity;
import com.example.electricassistant.setting_activity.SettingActivity;

public class ApplianceInfoActivity extends AppCompatActivity {

    private TextView appliance_info_test_tv;

    private Bundle applianceInfoBundle;
    private int applianceIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appliance_info);
        getSupportActionBar().setTitle("Room");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        appliance_info_test_tv = findViewById(R.id.appliance_info_test_tv);

        applianceInfoBundle = getIntent().getExtras();
        applianceIndex = applianceInfoBundle.getInt("applianceIndex",-1);
        appliance_info_test_tv.setText(String.valueOf(applianceIndex));
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}