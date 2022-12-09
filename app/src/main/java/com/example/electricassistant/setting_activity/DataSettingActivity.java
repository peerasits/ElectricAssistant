package com.example.electricassistant.setting_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.electricassistant.R;

public class DataSettingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_setting);
        getSupportActionBar().setTitle("Electricity data setting");
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.data_setting_layout, new DataFragmentFragment())
                .commit();
    }
}