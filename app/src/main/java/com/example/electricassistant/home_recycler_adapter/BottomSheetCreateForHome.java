package com.example.electricassistant.home_recycler_adapter;

import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;


import com.example.electricassistant.Data.HomeData;
import com.example.electricassistant.Data.UserData;
import com.example.electricassistant.dialog.DialogTemplate;
import com.example.electricassistant.global_data.GlobalData;
import com.example.electricassistant.R;
import com.example.electricassistant.home.EditHomeActivity;
import com.example.electricassistant.ui.HomeSelectFragment;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.List;

public class BottomSheetCreateForHome {

    private View bottomSheetView;
    private BottomSheetDialog bottomSheetDialog;
    private BottomSheetBehavior bottomSheetBehavior;

    private TextView menu_bottom_sheet_home_select;
    private TextView menu_bottom_sheet_home_edit;
    private TextView menu_bottom_sheet_home_delete;
    private TextView menu_bottom_sheet_home_cancel;
    private HomeRecyclerViewAdapter homeAdapter = HomeSelectFragment.homeAdapter;
    private String selectedHomeName, selectedHomeAddress;
    private boolean isSelectedHome = false;

    public void create(FragmentActivity fragmentActivity, String name, String address) {

        selectedHomeName = name;
        selectedHomeAddress = address;

        bottomSheetView = fragmentActivity.getLayoutInflater().inflate(R.layout.home_bottom_sheet, null);
        bottomSheetDialog = new BottomSheetDialog(fragmentActivity);
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetBehavior = BottomSheetBehavior.from((View) bottomSheetView.getParent());

        menu_bottom_sheet_home_select = bottomSheetView.findViewById(R.id.menu_bottom_sheet_home_select);
        menu_bottom_sheet_home_edit = bottomSheetView.findViewById(R.id.menu_bottom_sheet_home_edit);
        menu_bottom_sheet_home_delete = bottomSheetView.findViewById(R.id.menu_bottom_sheet_home_delete);
        menu_bottom_sheet_home_cancel = bottomSheetDialog.findViewById(R.id.menu_bottom_sheet_home_cancel);


        menu_bottom_sheet_home_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedIndex = searchGlobalData();

                if (selectedIndex != -1)
                    GlobalData.currentUserData.setHomeSelected(GlobalData.currentUserData.getArrHomeData().get(selectedIndex));
                String resultSelect = "You selected " + name;
                bottomSheetDialog.dismiss();
                new DialogTemplate().generateSelectedDialog(fragmentActivity,resultSelect);
            }
        });
        menu_bottom_sheet_home_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(fragmentActivity, EditHomeActivity.class);
                intent.putExtra("selectedHomeName", selectedHomeName);
                intent.putExtra("selectedHomeAddress", selectedHomeAddress);
                fragmentActivity.startActivity(intent);
                bottomSheetDialog.dismiss();
            }
        });

        menu_bottom_sheet_home_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                UserData processUser = GlobalData.currentUserData;

                int deleteIndex = searchGlobalData();
                if (deleteIndex != -1) {
                    List<HomeData> getList = processUser.getArrHomeData();
                    getList.remove(deleteIndex);

                    processUser.setArrHomeData(getList);

                    //Log.d("BottomSheet", String.valueOf(isSelectedHome));
                    if (isSelectedHome)
                        processUser.setHomeSelected(null);


                    Toast.makeText(fragmentActivity, "Successfully delete", Toast.LENGTH_SHORT).show();

                    //notify recyclerView to update
                    homeAdapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(fragmentActivity, "Error delete", Toast.LENGTH_SHORT).show();
                }
                if(processUser.getArrHomeData().size()<=0){
                    HomeSelectFragment.setNoDataTextView();
                }

                bottomSheetDialog.dismiss();

            }
        });
        menu_bottom_sheet_home_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomSheetDialog.dismiss();
            }
        });

        bottomSheetDialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialogInterface) {

            }
        });

        bottomSheetDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialogInterface) {
                bottomSheetDialog.dismiss();
            }
        });


        bottomSheetDialog.show();
    }

    private int searchGlobalData() {
        int selectedIndex = -1;
        for (int i = 0; i < GlobalData.currentUserData.getArrHomeData().size(); i++) {
            if (GlobalData.currentUserData.getArrHomeData().get(i).getName().equals(selectedHomeName) &&
                    GlobalData.currentUserData.getArrHomeData().get(i).getAddress().equals(selectedHomeAddress)) {
                selectedIndex = i;
                if (GlobalData.currentUserData.getArrHomeData().get(i) == GlobalData.homeSelected)
                    isSelectedHome = true;
                break;
            }
        }

        return selectedIndex;
    }
}
