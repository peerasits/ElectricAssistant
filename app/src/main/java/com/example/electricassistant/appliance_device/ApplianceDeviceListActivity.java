package com.example.electricassistant.appliance_device;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.electricassistant.R;
import com.example.electricassistant.appliance_device_recycler_adapter.ApplianceDeviceRecyclerViewAdapter;
import com.example.electricassistant.data.ApplianceData;
import com.example.electricassistant.data.RoomData;
import com.example.electricassistant.data.TypeOfApplianceEnum;
import com.example.electricassistant.global_data.GlobalData;
import com.example.electricassistant.profile.ProfileActivity;
import com.example.electricassistant.setting_activity.DataSettingActivity;
import com.example.electricassistant.setting_activity.SettingActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class ApplianceDeviceListActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView appliance_list_name_title_tv;
    private ImageView appliance_list_pic_label_img;
    private FloatingActionButton add_appliance_list_btn;
    private RecyclerView appliance_device_list_recyclerview;
    public static ApplianceDeviceRecyclerViewAdapter applianceAdapter;

    private Bundle roomBundle;
    private Intent addApplianceIntent;

    private RoomData selectedRoom;
    private String roomName, roomDescription;
    private List<ApplianceData> applianceDataList;
    private String testURL = "https://www.thespruce.com/thmb/eUo2LkU5ac6wa106kKCO65c4VRU=/750x0/filters:no_upscale():max_bytes" +
            "(150000):strip_icc():format(webp)/10-3-623702d1d102421b9eb5c90b087e42ff.jpeg";
    private int indexOfRoom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appliance_device_list);
        getSupportActionBar().setTitle("Electric Appliance List");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        roomBundle = getIntent().getExtras();
        roomName = roomBundle.getString("roomName", "undefined room name");
        indexOfRoom = roomBundle.getInt("indexOfRoom", -1);
        roomDescription = roomBundle.getString("roomDescription", "undefined description");

        selectedRoom = GlobalData.currentUserData.getHomeSelected().getRooms().get(indexOfRoom);
        applianceDataList = selectedRoom.getApplianceList();

        appliance_list_pic_label_img = findViewById(R.id.appliance_list_pic_label_img);
        Glide.with(getApplicationContext()).load(testURL).into(appliance_list_pic_label_img);

        appliance_list_name_title_tv = findViewById(R.id.appliance_list_name_title_tv);
        appliance_list_name_title_tv.setText("  " + selectedRoom.getName());
        add_appliance_list_btn = findViewById(R.id.add_appliance_list_btn);
        add_appliance_list_btn.setOnClickListener(this::onClick);

        appliance_device_list_recyclerview = findViewById(R.id.appliance_device_list_recyclerview);
        applianceAdapter = new ApplianceDeviceRecyclerViewAdapter(getApplicationContext(), applianceDataList);
        appliance_device_list_recyclerview.setAdapter(applianceAdapter);
        appliance_device_list_recyclerview.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent optionsIntent;
        switch (item.getItemId()) {
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

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.add_appliance_list_btn:


                if (applianceDataList.size() < selectedRoom.getMaxAppliances()) {
                    addApplianceIntent = new Intent(getApplicationContext(), AddApplianceActivity.class);
                    startActivity(addApplianceIntent);
                } else {
                    Toast.makeText(getApplicationContext(), "Error to add appliance data", Toast.LENGTH_SHORT).show();
                }


                break;
            default:
                break;
        }
    }
}