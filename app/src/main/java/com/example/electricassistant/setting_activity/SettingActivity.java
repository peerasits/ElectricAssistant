package com.example.electricassistant.setting_activity;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;

import com.example.electricassistant.R;

public class SettingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        getSupportActionBar().setTitle("Setting");
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.idFrameLayout, new SettingFragment())
                .commit();


    }
}