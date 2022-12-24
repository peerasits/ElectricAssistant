package com.example.electricassistant.room;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import com.example.electricassistant.data.ApplianceData;
import com.example.electricassistant.data_enum.MaxApplianceEnum;
import com.example.electricassistant.data.RoomData;
import com.example.electricassistant.data_enum.TypeOfRoomEnum;
import com.example.electricassistant.R;
import com.example.electricassistant.dialog.DialogTemplate;
import com.example.electricassistant.global_data.GlobalData;

import java.util.ArrayList;
import java.util.List;

public class AddRoomActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText room_add_room_et;
    private EditText description_add_room_tv;
    private Spinner type_add_room_spinner, max_appliance_add_room_spinner;
    private Switch monitoring_add_room_switch;
    private Button cancel_add_room_btn, adding_add_room_btn;

    private List<RoomData> selectedRoom;
    private String[] maxApplianceArr = MaxApplianceEnum.toArray(MaxApplianceEnum.class);
    private int defaultMaxApplianceIndex = 0;
    private String[] typeOfRoomArr = TypeOfRoomEnum.toArray(TypeOfRoomEnum.class);
    private int defaultTypeOfRoomIndex = 2;
    private boolean defaultMonitoring = true;

    private AlertDialog.Builder confirmAddRoomDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_room);
        getSupportActionBar().setTitle("Add room");

        selectedRoom = GlobalData.currentUserData.getHomeSelected().getRooms();

        room_add_room_et = findViewById(R.id.room_add_room_et);
        description_add_room_tv = findViewById(R.id.description_add_room_tv);
        type_add_room_spinner = findViewById(R.id.type_add_room_spinner);
        max_appliance_add_room_spinner = findViewById(R.id.max_appliance_add_room_spinner);
        monitoring_add_room_switch = findViewById(R.id.monitoring_add_room_switch);
        monitoring_add_room_switch.setChecked(defaultMonitoring);
        cancel_add_room_btn = findViewById(R.id.cancel_add_room_btn);
        cancel_add_room_btn.setOnClickListener(this::onClick);
        adding_add_room_btn = findViewById(R.id.adding_add_room_btn);
        adding_add_room_btn.setOnClickListener(this::onClick);

        type_add_room_spinner = findViewById(R.id.type_add_room_spinner);
        max_appliance_add_room_spinner = findViewById(R.id.max_appliance_add_room_spinner);
        initRoomSpinners();


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.cancel_add_room_btn:
                finish();
                break;
            case R.id.adding_add_room_btn:
                addRoomToList();
                break;
            default:
                Toast.makeText(getApplicationContext(), "Default case", Toast.LENGTH_SHORT).show();
        }
    }

    private void initRoomSpinners() {
        int item;
        ArrayAdapter<String> spinnerTypeOfRoomArrayAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, typeOfRoomArr);
        spinnerTypeOfRoomArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        type_add_room_spinner.setAdapter(spinnerTypeOfRoomArrayAdapter);
        item = spinnerTypeOfRoomArrayAdapter.getPosition(typeOfRoomArr[defaultTypeOfRoomIndex]);
        type_add_room_spinner.setSelection(item);


        ArrayAdapter<String> spinnerMaxApplianceArrayAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, maxApplianceArr);
        spinnerMaxApplianceArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        max_appliance_add_room_spinner.setAdapter(spinnerMaxApplianceArrayAdapter);
        item = spinnerMaxApplianceArrayAdapter.getPosition(maxApplianceArr[defaultMaxApplianceIndex]);
        max_appliance_add_room_spinner.setSelection(item);

    }

    private void addRoomToList() {
        String roomNameStr = room_add_room_et.getText().toString();
        String descriptionOfRoomStr = description_add_room_tv.getText().toString();
        String typeOfRoomStr = type_add_room_spinner.getSelectedItem().toString();
        boolean isMonitoringOfRoom = monitoring_add_room_switch.isChecked();
        int maxApplianceValue = Integer.parseInt(max_appliance_add_room_spinner.getSelectedItem().toString());
        TypeOfRoomEnum typeOfRoomEnum = TypeOfRoomEnum.convertTypeOfRoomStrToEnum(typeOfRoomStr);

        RoomData roomData = new RoomData(roomNameStr, typeOfRoomEnum, descriptionOfRoomStr, isMonitoringOfRoom, maxApplianceValue, new ArrayList<ApplianceData>(),null);

        String roomDataResultStr = "Room name : "+roomNameStr+"\n"+
                "Description : "+descriptionOfRoomStr+"\n"+
                "Type of room  : "+typeOfRoomStr+"\n"+
                "Monitoring : "+(isMonitoringOfRoom ? "Yes" : "No")+"\n"+
                "Max Appliance : "+String.valueOf(maxApplianceValue);
        confirmAddRoomDialog = new DialogTemplate().generateSummaryAddRoomDialog(this,roomDataResultStr);

        confirmAddRoomDialog.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (selectedRoom == null) {
                    selectedRoom = new ArrayList<RoomData>();
                }
                selectedRoom.add(roomData);
                Toast.makeText(getApplicationContext(), "Add room data successfully", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        confirmAddRoomDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        confirmAddRoomDialog.show();

    }

}