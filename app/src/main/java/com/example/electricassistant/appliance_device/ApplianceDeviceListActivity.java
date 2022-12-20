package com.example.electricassistant.appliance_device;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.electricassistant.R;
import com.example.electricassistant.profile.ProfileActivity;
import com.example.electricassistant.setting_activity.DataSettingActivity;
import com.example.electricassistant.setting_activity.SettingActivity;

public class ApplianceDeviceListActivity extends AppCompatActivity {

    private TextView appliance_list_label_tv;

    private Bundle roomBundle;

    private String roomName,roomDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appliance_device_list);
        getSupportActionBar().setTitle("Electric Appliance List");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        roomBundle = getIntent().getExtras();
        roomName = roomBundle.getString("roomName","undefined room name");
        roomDescription = roomBundle.getString("roomDescription","undefined description");

        appliance_list_label_tv = findViewById(R.id.appliance_list_label_tv);
        appliance_list_label_tv.setText(roomName+" "+roomDescription);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent optionsIntent;
        switch(item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
            case R.id.setting_item:
                optionsIntent = new Intent(this, SettingActivity.class);
                startActivity(optionsIntent);
                return true;
            case R.id.setting_data_item:
                optionsIntent = new Intent(this, DataSettingActivity.class);
                startActivity(optionsIntent);
                return true;
            case R.id.setting_profile_item:
                optionsIntent = new Intent(this, ProfileActivity.class);
                startActivity(optionsIntent);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}