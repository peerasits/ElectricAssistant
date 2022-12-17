package com.example.electricassistant.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.electricassistant.Data.HomeData;
import com.example.electricassistant.R;
import com.example.electricassistant.global_data.GlobalData;

public class InfoHomeActivity extends AppCompatActivity implements View.OnClickListener{

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
        info_home_textview.setText(String.valueOf(selectedHome.toString()));
        close_info_home_btn = findViewById(R.id.close_info_home_btn);
        close_info_home_btn.setOnClickListener(this::onClick);

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.close_info_home_btn:
                finish();
                break;
            default:
                break;
        }
    }
}