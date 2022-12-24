package com.example.electricassistant.home;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.electricassistant.data.HomeData;
import com.example.electricassistant.R;
import com.example.electricassistant.global_data.GlobalData;

public class HomeInfoActivity extends AppCompatActivity implements View.OnClickListener {

    private Button close_info_home_btn;
    private TextView info_home_textview;

    private Bundle infoBundle;
    private int infoIndex;
    private HomeData selectedHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_home);
        getSupportActionBar().setTitle("Home Info");

        infoBundle = getIntent().getExtras();
        infoIndex = infoBundle.getInt("infoIndex");
        selectedHome = GlobalData.currentUserData.getArrHomeData().get(infoIndex);

        info_home_textview = findViewById(R.id.info_home_textview);
        info_home_textview.setText(generateResultOfHomeStr());
        close_info_home_btn = findViewById(R.id.close_info_home_btn);
        close_info_home_btn.setOnClickListener(this::onClick);

    }

    private String generateResultOfHomeStr() {
        String nameOfHomeStr = selectedHome.getName();
        String addressHomeStr = selectedHome.getAddress();
        String isMonitoringStr = (selectedHome.isMonitoring() ? "Yes" : "No");
        String measureHomeStr = selectedHome.getMeasure().toString().replaceAll("_"," ");
        String voltageHomeStr = selectedHome.getVoltage().toString().replaceAll("_"," ");;
        String totalRoomsOfHomeStr = String.valueOf(selectedHome.getRooms().size());
        String roomPicUrl = selectedHome.getUrlOfHome();

        String result = "Name : " + nameOfHomeStr + "\n" +
                "Address : " + addressHomeStr + "\n" +
                "Monitoring : " + isMonitoringStr + "\n" +
                "Type of measure : " + measureHomeStr + "\n" +
                "Voltage system : " + voltageHomeStr + "\n" +
                "Total rooms : " + totalRoomsOfHomeStr + "\n" +
                "Room picture URL : " + roomPicUrl;
        return result;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.close_info_home_btn:
                finish();
                break;
            default:
                break;
        }
    }
}