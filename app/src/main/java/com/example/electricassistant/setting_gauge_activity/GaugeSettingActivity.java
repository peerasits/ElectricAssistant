package com.example.electricassistant.setting_gauge_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.electricassistant.R;
import com.example.electricassistant.setting_activity.SettingFragment;

public class GaugeSettingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_gauge);
        getSupportActionBar().setTitle("Gauge setting");
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.gauge_setting_layout, new GaugeSettingFragment())
                .commit();

    }
}