package com.example.electricassistant.RecyclerAdapter;

import android.content.DialogInterface;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;

import com.example.electricassistant.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class bottomSheetCreateForHome {

    private View bottomSheetView;
    private BottomSheetDialog bottomSheetDialog;
    private BottomSheetBehavior bottomSheetBehavior;

    private TextView menu_bottom_sheet_home_select;
    private TextView menu_bottom_sheet_home_edit;
    private TextView menu_bottom_sheet_home_delete;
    private TextView menu_bottom_sheet_home_cancel;

    public void create(FragmentActivity fragmentActivity,String name){

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
                Toast.makeText(fragmentActivity, "Option2", Toast.LENGTH_SHORT).show();
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
