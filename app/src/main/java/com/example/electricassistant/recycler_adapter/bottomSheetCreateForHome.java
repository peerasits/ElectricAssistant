package com.example.electricassistant.recycler_adapter;

import android.content.DialogInterface;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;


import com.example.electricassistant.Data.HomeData;
import com.example.electricassistant.global_data.GlobalData;
import com.example.electricassistant.R;
import com.example.electricassistant.ui.HomeSelectFragment;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.List;

public class bottomSheetCreateForHome {

    private View bottomSheetView;
    private BottomSheetDialog bottomSheetDialog;
    private BottomSheetBehavior bottomSheetBehavior;

    private TextView menu_bottom_sheet_home_select;
    private TextView menu_bottom_sheet_home_edit;
    private TextView menu_bottom_sheet_home_delete;
    private TextView menu_bottom_sheet_home_cancel;
    private HomeRecyclerviewAdapter homeAdapter = HomeSelectFragment.homeAdapter;
    private String selectedName,selectedAddress;

    public void create(FragmentActivity fragmentActivity,String name,String address){

        selectedName = name;
        selectedAddress = address;

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
                Toast.makeText(fragmentActivity, "You selected " + name, Toast.LENGTH_SHORT).show();

                int selectedIndex  = searchGlobalData();

                if(selectedIndex != -1)
                    GlobalData.currentUserData.setHomeSelected(GlobalData.currentUserData.getArrHomeData().get(selectedIndex));
                bottomSheetDialog.dismiss();
            }
        });
        menu_bottom_sheet_home_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(fragmentActivity, "Option1", Toast.LENGTH_SHORT).show();
            }
        });

        menu_bottom_sheet_home_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                int deleteIndex = searchGlobalData();
                if(deleteIndex!=-1){
                    List<HomeData> getList = GlobalData.currentUserData.getArrHomeData();
                    getList.remove(deleteIndex);
                    GlobalData.currentUserData.setArrHomeData(getList);
                    GlobalData.currentUserData.setHomeSelected(null);
                    Toast.makeText(fragmentActivity, "Successfully delete", Toast.LENGTH_SHORT).show();
                    homeAdapter.notifyDataSetChanged();
                }else{
                    Toast.makeText(fragmentActivity, "Error delete", Toast.LENGTH_SHORT).show();
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

    private int searchGlobalData(){
        int selectedIndex = -1;
        for(int i = 0; i< GlobalData.homeDataList.size(); i++){
            if(GlobalData.homeDataList.get(i).getName().equals(selectedName) && GlobalData.homeDataList.get(i).getAddress().equals(selectedAddress)){
                selectedIndex = i;
                break;
            }
        }

        return selectedIndex;
    }
}
