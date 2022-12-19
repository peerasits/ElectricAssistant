package com.example.electricassistant.dialog;




import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;

import com.example.electricassistant.MainActivity;

public class DialogTemplate {

    public void generateDialog(Activity activity){
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

    public void generateSelectedDialog(Activity activity,String message){
        new AlertDialog.Builder(activity)
                .setTitle("Notification")
                .setMessage(message)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                }).show();
    }

    public AlertDialog.Builder generateSummaryAddHomeDialog(Activity activity,String message){
        return new AlertDialog.Builder(activity)
                .setTitle("Confirm data to adding?")
                .setMessage(message)
                ;
    }




}
