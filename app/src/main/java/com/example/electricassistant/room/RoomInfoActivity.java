package com.example.electricassistant.room;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.electricassistant.R;

public class RoomInfoActivity extends AppCompatActivity implements View.OnClickListener {

    private Button ok_room_info_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_info);
        getSupportActionBar().setTitle("Room info");

        ok_room_info_btn = findViewById(R.id.ok_room_info_btn);
        ok_room_info_btn.setOnClickListener(this::onClick);

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