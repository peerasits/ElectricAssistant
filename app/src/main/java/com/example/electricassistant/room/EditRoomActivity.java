package com.example.electricassistant.room;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import com.example.electricassistant.R;
import com.example.electricassistant.data_enum.MaxApplianceEnum;
import com.example.electricassistant.data.RoomData;
import com.example.electricassistant.data_enum.TypeOfRoomEnum;
import com.example.electricassistant.dialog.DialogTemplate;
import com.example.electricassistant.global_data.GlobalData;
import com.example.electricassistant.util.ConvertStringFromEnum;

public class EditRoomActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView room_edit_room_et;
    private TextView description_edit_room_tv;
    private Switch monitoring_edit_room_switch;
    private Spinner type_edit_room_spinner;
    private Spinner max_appliance_edit_room_spinner;
    private Button cancel_edit_room_btn;
    private Button editing_edit_room_btn;

    private Bundle editRoomBundle;
    private AlertDialog.Builder confirmEditRoomDialog;

    private int indexOfRoom = -1;
    private RoomData roomSelected;
    private String[] maxApplianceArr = MaxApplianceEnum.toArray(MaxApplianceEnum.class);
    private String[] typeOfRoomArr = TypeOfRoomEnum.toArray(TypeOfRoomEnum.class);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_room);
        getSupportActionBar().setTitle("Edit room");

        editRoomBundle = getIntent().getExtras();
        indexOfRoom = editRoomBundle.getInt("indexOfRoom", indexOfRoom);

        if (indexOfRoom != -1)
            roomSelected = GlobalData.currentUserData.getHomeSelected().getRooms().get(indexOfRoom);

        room_edit_room_et = findViewById(R.id.room_edit_room_et);
        description_edit_room_tv = findViewById(R.id.description_edit_room_tv);
        monitoring_edit_room_switch = findViewById(R.id.monitoring_edit_room_switch);
        type_edit_room_spinner = findViewById(R.id.type_edit_room_spinner);
        max_appliance_edit_room_spinner = findViewById(R.id.max_appliance_edit_room_spinner);
        cancel_edit_room_btn = findViewById(R.id.cancel_edit_room_btn);
        editing_edit_room_btn = findViewById(R.id.editing_edit_room_btn);


        room_edit_room_et.setText(roomSelected.getName());
        description_edit_room_tv.setText(roomSelected.getDescription());
        monitoring_edit_room_switch.setChecked(roomSelected.isMonitoring());
        initRoomSpinners();
        cancel_edit_room_btn.setOnClickListener(this::onClick);
        editing_edit_room_btn.setOnClickListener(this::onClick);


    }

    private void initRoomSpinners() {

        int item = TypeOfRoomEnum.getIndexOfTypeOfRoomEnumFromRoomObj(roomSelected);

        ArrayAdapter<String> spinnerTypeOfRoomArrayAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, typeOfRoomArr);
        spinnerTypeOfRoomArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        type_edit_room_spinner.setAdapter(spinnerTypeOfRoomArrayAdapter);
        type_edit_room_spinner.setSelection(item);

        item = MaxApplianceEnum.getIndexOfMaxApplianceEnumFromRoomObj(roomSelected);
        ArrayAdapter<String> spinnerMaxApplianceArrayAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, maxApplianceArr);
        spinnerMaxApplianceArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        max_appliance_edit_room_spinner.setAdapter(spinnerMaxApplianceArrayAdapter);
        max_appliance_edit_room_spinner.setSelection(item);

    }

    private void updateRoomData(){
        String namedOfRoomEditedStr =  room_edit_room_et.getText().toString();
        String descriptiondOfRoomEditedStr = description_edit_room_tv.getText().toString();
        boolean monitoringOfRoomEditedBool = monitoring_edit_room_switch.isChecked();
        String typeOfRoomEnumEditedValue = type_edit_room_spinner.getSelectedItem().toString();
        int maxApplianceEdited = Integer.parseInt(max_appliance_edit_room_spinner.getSelectedItem().toString());


        TypeOfRoomEnum typeOfRoomEnumEdited = TypeOfRoomEnum.convertTypeOfRoomStrToEnum(typeOfRoomEnumEditedValue);

        String roomDataResultStr = "Room name : "+namedOfRoomEditedStr+"\n"+
                "Description : "+descriptiondOfRoomEditedStr+"\n"+
                "Type of room  : "+typeOfRoomEnumEditedValue+"\n"+
                "Monitoring : "+(monitoringOfRoomEditedBool ? "Yes" : "No")+"\n"+
                "Max Appliance : "+String.valueOf(maxApplianceEdited);

        confirmEditRoomDialog = new DialogTemplate().generateConfirmToEditRoomDialog(this,roomDataResultStr);
        confirmEditRoomDialog.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                roomSelected.setName(namedOfRoomEditedStr);
                roomSelected.setDescription(descriptiondOfRoomEditedStr);
                roomSelected.setMonitoring(monitoringOfRoomEditedBool);
                roomSelected.setTypeOfRoom(typeOfRoomEnumEdited);
                roomSelected.setMaxAppliances(maxApplianceEdited);
                dialogInterface.dismiss();
                finish();
            }
        });
        confirmEditRoomDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        confirmEditRoomDialog.show();


    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.editing_edit_room_btn:
                updateRoomData();
                break;
            case R.id.cancel_edit_room_btn:
                finish();
                break;
            default:
                break;
        }
    }
}