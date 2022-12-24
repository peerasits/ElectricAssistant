package com.example.electricassistant.room;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.electricassistant.R;
import com.example.electricassistant.data.RoomData;
import com.example.electricassistant.global_data.GlobalData;

public class RoomInfoActivity extends AppCompatActivity implements View.OnClickListener {



    private Button ok_room_info_btn;
    private TextView room_info_data_tv;
    private RoomData roomData;

    private Bundle infoBundle;

    private int indexOfRoom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_room);
        getSupportActionBar().setTitle("Room info");

        infoBundle = getIntent().getExtras();
        indexOfRoom = infoBundle.getInt("indexOfRoom",-1);

        roomData = GlobalData.currentUserData.getHomeSelected().getRooms().get(indexOfRoom);

        ok_room_info_btn = findViewById(R.id.ok_room_info_btn);
        ok_room_info_btn.setOnClickListener(this::onClick);

        room_info_data_tv = findViewById(R.id.room_info_data_tv);
        room_info_data_tv.setText(generateResultOfRoomStr());

    }

    private String generateResultOfRoomStr(){
        String nameOfRoomStr = roomData.getName();
        String descriptionStr = roomData.getDescription();
        String typeOfRoomStr = roomData.getTypeOfRoom().toString().replaceAll("_"," ");
        String isMonitoringStr = (roomData.isMonitoring() ? "Yes" : "No");
        String maxApplianceStr = String.valueOf(roomData.getMaxAppliances());
        String roomPicUrl = roomData.getRoomPicUrl();

        String result = "Name : " + nameOfRoomStr + "\n" +
                "Description : " + descriptionStr + "\n" +
                "Type of room " + typeOfRoomStr + "\n"+
                "Monitoring : "+isMonitoringStr+"\n"+
                "Max Appliance devices : " + maxApplianceStr+"\n"+
                "Room picture URL : " + roomPicUrl;
        return result;
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.ok_room_info_btn:
                finish();
                break;
            default:
                break;
        }
    }
}