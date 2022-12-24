package com.example.electricassistant.home_recycler_adapter;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;


import com.example.electricassistant.data.HomeData;
import com.example.electricassistant.data.UserData;
import com.example.electricassistant.dialog.DialogTemplate;
import com.example.electricassistant.global_data.GlobalData;
import com.example.electricassistant.R;
import com.example.electricassistant.home.EditHomeActivity;
import com.example.electricassistant.home.HomeInfoActivity;
import com.example.electricassistant.ui.HomeSelectFragment;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.List;

public class BottomSheetCreateForHome {

    private View bottomSheetView;
    private BottomSheetDialog bottomSheetDialog;
    private BottomSheetBehavior bottomSheetBehavior;
    private TextView menu_bottom_sheet_home_select;
    private TextView menu_bottom_sheet_home_info;
    private TextView menu_bottom_sheet_home_edit;
    private TextView menu_bottom_sheet_home_delete;
    private TextView menu_bottom_sheet_home_cancel;
    private HomeRecyclerViewAdapter homeAdapter = HomeSelectFragment.homeAdapter;

    private int selectedIndex = -1;
    private boolean isSelectedHome = false;
    private HomeData homeSelected;
    private HomeData homeToDelete;

    public void create(FragmentActivity fragmentActivity, int index) {

        selectedIndex = index;

        bottomSheetView = fragmentActivity.getLayoutInflater().inflate(R.layout.home_bottom_sheet, null);
        bottomSheetDialog = new BottomSheetDialog(fragmentActivity);
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetBehavior = BottomSheetBehavior.from((View) bottomSheetView.getParent());

        menu_bottom_sheet_home_select = bottomSheetView.findViewById(R.id.menu_bottom_sheet_home_select);
        menu_bottom_sheet_home_info = bottomSheetView.findViewById(R.id.menu_bottom_sheet_home_info);
        menu_bottom_sheet_home_edit = bottomSheetView.findViewById(R.id.menu_bottom_sheet_home_edit);
        menu_bottom_sheet_home_delete = bottomSheetView.findViewById(R.id.menu_bottom_sheet_home_delete);
        menu_bottom_sheet_home_cancel = bottomSheetDialog.findViewById(R.id.menu_bottom_sheet_home_cancel);


        menu_bottom_sheet_home_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (selectedIndex != -1)
                    GlobalData.currentUserData.setHomeSelected(GlobalData.currentUserData.getArrHomeData().get(selectedIndex));
                String resultSelect = "You selected " + GlobalData.currentUserData.getArrHomeData().get(selectedIndex).getName();
                bottomSheetDialog.dismiss();
                new DialogTemplate().generateSelectedDialog(fragmentActivity, resultSelect);
            }
        });
        menu_bottom_sheet_home_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(fragmentActivity, HomeInfoActivity.class);
                intent.putExtra("infoIndex", selectedIndex);
                fragmentActivity.startActivity(intent);

                bottomSheetDialog.dismiss();
            }
        });

        menu_bottom_sheet_home_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(fragmentActivity, EditHomeActivity.class);
                intent.putExtra("infoIndex", selectedIndex);
                fragmentActivity.startActivity(intent);

                bottomSheetDialog.dismiss();
            }
        });

        menu_bottom_sheet_home_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                homeSelected = GlobalData.currentUserData.getHomeSelected();
                homeToDelete = GlobalData.currentUserData.getArrHomeData().get(selectedIndex);

                List<HomeData> homeDataList = GlobalData.currentUserData.getArrHomeData();
                class OnclickDialog implements DialogInterface.OnClickListener {

                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        switch (i) {
                            case -1:
                                if (homeSelected.getName().equals(homeToDelete.getName()) && homeSelected.getAddress().equals(homeToDelete.getAddress())) {
                                    GlobalData.currentUserData.setHomeSelected(null);
                                }
                                if (homeDataList.get(selectedIndex) != null) {
                                    homeDataList.remove(selectedIndex);
                                    homeAdapter.notifyDataSetChanged();
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

                AlertDialog.Builder confirmTodeleteHomeDialog = new DialogTemplate()
                        .generateConfirmToDeleteHomeDialog(fragmentActivity, "Confirm to delete this home");
                confirmTodeleteHomeDialog.setPositiveButton("Confirm", new OnclickDialog());
                confirmTodeleteHomeDialog.setNegativeButton("Cancel", new OnclickDialog());
                confirmTodeleteHomeDialog.show();


                if (GlobalData.currentUserData.getArrHomeData().size() <= 0) {
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

}
