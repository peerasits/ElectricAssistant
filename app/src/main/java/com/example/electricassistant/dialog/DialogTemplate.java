package com.example.electricassistant.dialog;




import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;

import com.example.electricassistant.MainActivity;

public class DialogTemplate {

    public static void generateDialog(Activity activity){
        new AlertDialog.Builder(activity)
                .setTitle("Error")
                .setMessage("No home selected.Please select home first.")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                }).show();
    }


}
