package com.example.electricassistant.room_recycler_adapter;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import com.example.electricassistant.R;
import com.example.electricassistant.appliance_device.ApplianceDeviceListActivity;
import com.example.electricassistant.data.RoomData;
import com.example.electricassistant.dialog.DialogTemplate;
import com.example.electricassistant.global_data.GlobalData;
import com.example.electricassistant.room.EditRoomActivity;
import com.example.electricassistant.room.RoomInfoActivity;
import com.example.electricassistant.ui.RoomFragment;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.List;

public class BottomSheetCreateForRoom implements View.OnClickListener {

    private FragmentActivity fragmentActivity;
    private View roomBottomSheetView;
    private BottomSheetDialog roomBottomSheetDialog;
    private BottomSheetBehavior roomBottomSheetBehavior;
    private BottomSheetBehavior.BottomSheetCallback roomBottomSheetCallback;
    private TextView menu_bottom_sheet_room_select_tv;
    private TextView menu_bottom_sheet_room_info_tv;
    private TextView menu_bottom_sheet_room_edit_tv;
    private TextView menu_bottom_sheet_room_delete_tv;
    private TextView menu_bottom_sheet_room_cancel_tv;

    private Intent applianceListIntent;
    private DialogTemplate dialogTemplate;

    private String selectedRoomName, selectedRoomDescription;
    private int indexOfRoom = -1;
    private RoomRecyclerViewAdapter roomAdapter;


    public void create(FragmentActivity fragmentActivity, String name, String description, int position) {
        selectedRoomName = name;
        selectedRoomDescription = description;
        this.fragmentActivity = fragmentActivity;
        indexOfRoom = position;
        roomAdapter = RoomFragment.roomRecyclerViewAdapter;
        dialogTemplate = new DialogTemplate();


        roomBottomSheetView = fragmentActivity.getLayoutInflater().inflate(R.layout.room_botton_sheet, null);
        roomBottomSheetDialog = new BottomSheetDialog(fragmentActivity);
        roomBottomSheetDialog.setContentView(roomBottomSheetView);
        roomBottomSheetBehavior = BottomSheetBehavior.from((View) roomBottomSheetView.getParent());

        roomBottomSheetDialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialogInterface) {

            }
        });
        roomBottomSheetDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialogInterface) {

            }
        });

        roomBottomSheetCallback = new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {

            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        };

        menu_bottom_sheet_room_select_tv = roomBottomSheetView.findViewById(R.id.menu_bottom_sheet_room_select_tv);
        menu_bottom_sheet_room_select_tv.setOnClickListener(this::onClick);
        menu_bottom_sheet_room_info_tv = roomBottomSheetView.findViewById(R.id.menu_bottom_sheet_room_info_tv);
        menu_bottom_sheet_room_info_tv.setOnClickListener(this::onClick);
        menu_bottom_sheet_room_edit_tv = roomBottomSheetView.findViewById(R.id.menu_bottom_sheet_room_edit_tv);
        menu_bottom_sheet_room_edit_tv.setOnClickListener(this::onClick);
        menu_bottom_sheet_room_delete_tv = roomBottomSheetView.findViewById(R.id.menu_bottom_sheet_room_delete_tv);
        menu_bottom_sheet_room_delete_tv.setOnClickListener(this::onClick);
        menu_bottom_sheet_room_cancel_tv = roomBottomSheetView.findViewById(R.id.menu_bottom_sheet_room_cancel_tv);
        menu_bottom_sheet_room_cancel_tv.setOnClickListener(this::onClick);


        roomBottomSheetDialog.show();

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.menu_bottom_sheet_room_select_tv:
                Toast.makeText(fragmentActivity, "This is a select case", Toast.LENGTH_LONG).show();

                applianceListIntent = new Intent(fragmentActivity, ApplianceDeviceListActivity.class);
                applianceListIntent.putExtra("roomName", selectedRoomName);
                applianceListIntent.putExtra("roomDescription", selectedRoomDescription);
                applianceListIntent.putExtra("indexOfRoom", indexOfRoom);
                fragmentActivity.startActivity(applianceListIntent);

                roomBottomSheetDialog.dismiss();
                break;
            case R.id.menu_bottom_sheet_room_info_tv:
                applianceListIntent = new Intent(fragmentActivity, RoomInfoActivity.class);
                applianceListIntent.putExtra("indexOfRoom", indexOfRoom);
                fragmentActivity.startActivity(applianceListIntent);
                roomBottomSheetDialog.dismiss();
                break;
            case R.id.menu_bottom_sheet_room_edit_tv:
                applianceListIntent = new Intent(fragmentActivity, EditRoomActivity.class);
                applianceListIntent.putExtra("roomName", selectedRoomName);
                applianceListIntent.putExtra("roomDescription", selectedRoomDescription);
                applianceListIntent.putExtra("indexOfRoom", indexOfRoom);
                fragmentActivity.startActivity(applianceListIntent);
                roomBottomSheetDialog.dismiss();
                break;
            case R.id.menu_bottom_sheet_room_delete_tv:

                List<RoomData> roomDataList = GlobalData.currentUserData.getHomeSelected().getRooms();
                AlertDialog.Builder confirmTodeleteDialog = dialogTemplate.generateConfirmToDeleteRoomDialog(fragmentActivity, "Confirm to delete room?");
                class OnclickDialog implements DialogInterface.OnClickListener {

                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        switch (i) {
                            case -1:
                                if(roomDataList.get(indexOfRoom) != null){
                                    roomDataList.remove(indexOfRoom);
                                    roomAdapter.notifyDataSetChanged();
                                }
                                break;
                            case -2:
                                break;
                            default:
                                break;
                        }
                        dialogInterface.dismiss();
                    }
                }

                OnclickDialog onclickDialog = new OnclickDialog();
                confirmTodeleteDialog.setPositiveButton("Confirm", (DialogInterface.OnClickListener) onclickDialog);
                confirmTodeleteDialog.setNegativeButton("Cancel", (DialogInterface.OnClickListener) onclickDialog);
                confirmTodeleteDialog.show();
                roomBottomSheetDialog.dismiss();

                break;
            case R.id.menu_bottom_sheet_room_cancel_tv:
                roomBottomSheetDialog.dismiss();
                break;
            default:
                Toast.makeText(fragmentActivity, "This is a default case", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
