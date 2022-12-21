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
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.electricassistant.R;
import com.example.electricassistant.appliance_device_recycler_adapter.ApplianceDeviceRecyclerViewAdapter;
import com.example.electricassistant.data.ApplianceData;
import com.example.electricassistant.data.RoomData;
import com.example.electricassistant.global_data.GlobalData;
import com.example.electricassistant.profile.ProfileActivity;
import com.example.electricassistant.setting_activity.DataSettingActivity;
import com.example.electricassistant.setting_activity.SettingActivity;

public class ApplianceDeviceListActivity extends AppCompatActivity {

    private TextView appliance_list_name_title_tv;
    private ImageView appliance_list_pic_label_img;
    private static RecyclerView appliance_device_list_recyclerview;

    private Bundle roomBundle;
    private ApplianceDeviceRecyclerViewAdapter applianceAdapter;

    private RoomData selectedRoom ;
    private String roomName,roomDescription;
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
        roomName = roomBundle.getString("roomName","undefined room name");
        indexOfRoom = roomBundle.getInt("indexOfRoom",-1);
        roomDescription = roomBundle.getString("roomDescription","undefined description");

        selectedRoom = GlobalData.currentUserData.getHomeSelected().getRooms().get(indexOfRoom);

        appliance_list_pic_label_img = findViewById(R.id.appliance_list_pic_label_img);
        Glide.with(getApplicationContext()).load(testURL).into(appliance_list_pic_label_img);

        appliance_list_name_title_tv = findViewById(R.id.appliance_list_name_title_tv);
        appliance_list_name_title_tv.setText("  "+selectedRoom.getName());

        appliance_device_list_recyclerview = findViewById(R.id.appliance_device_list_recyclerview);
        ApplianceData[] applianceDataArr = new ApplianceData[5];
        applianceDataArr[0] = new ApplianceData("My device 01","FAN",true,true,true,false,false,true,"My example device"
                ,220,5);
        applianceDataArr[1] = new ApplianceData("My device 02","Air conditioner",true,true,true,true,false,true,"My example device 2 naja"
                ,220,5);
        applianceDataArr[2] = new ApplianceData("My device 03","Computer",true,true,true,true,false,false,"My pc eiei"
                ,220,5);
        applianceDataArr[3] = new ApplianceData("My device 03","Computer",true,true,true,false,false,true,"My pc eiei"
                ,220,5);
        applianceDataArr[4] = new ApplianceData("My device 03","Computer",true,true,true,false,false,false,"My pc eiei"
                ,220,5);
        applianceAdapter = new ApplianceDeviceRecyclerViewAdapter(getApplicationContext(),applianceDataArr);
        appliance_device_list_recyclerview.setAdapter(applianceAdapter);
        appliance_device_list_recyclerview.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

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