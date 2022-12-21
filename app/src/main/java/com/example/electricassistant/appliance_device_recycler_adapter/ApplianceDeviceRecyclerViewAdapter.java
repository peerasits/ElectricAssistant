package com.example.electricassistant.appliance_device_recycler_adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.electricassistant.R;
import com.example.electricassistant.appliance_device.ApplianceInfoActivity;
import com.example.electricassistant.data.ApplianceData;

public class ApplianceDeviceRecyclerViewAdapter extends RecyclerView.Adapter<ApplianceDeviceRecyclerViewAdapter.ViewHolder>{

    private Context context;

    private Intent applianceInfoIntent;

    private ApplianceData[] applianceDataArr;

    public ApplianceDeviceRecyclerViewAdapter(Context context, ApplianceData[] applianceDataArr) {
        this.context = context;
        this.applianceDataArr = applianceDataArr;
    }

    @NonNull
    @Override
    public ApplianceDeviceRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.appliance_device_display, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ApplianceDeviceRecyclerViewAdapter.ViewHolder holder, int position) {

        class ApplianceItemOnClick implements View.OnClickListener{
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.layout_appliancelist_rv_constraint:
                        applianceInfoIntent = new Intent(context, ApplianceInfoActivity.class);
                        applianceInfoIntent.putExtra("applianceIndex",position);
                        context.startActivity(applianceInfoIntent);
                        break;
                    default:
                        break;
                }
            }
        }

        if (position % 2 == 0)
            holder.layout_appliancelist_rv_constraint.setBackgroundColor(Color.rgb(232, 231, 231));
        holder.layout_appliancelist_rv_constraint.setOnClickListener(new ApplianceItemOnClick());
        holder.name_appliance_list_tv.setText(applianceDataArr[position].getName());
        holder.type_appliance_list_tv.setText(applianceDataArr[position].getType());
        holder.description_appliance_list_tv.setText(applianceDataArr[position].getDescription());
        if (!applianceDataArr[position].isDeviceMonitoing())
            holder.monitoring_appliance_list_img.setVisibility(View.GONE);
        if (!applianceDataArr[position].isNotify())
            holder.notification_appliance_list_img.setVisibility(View.GONE);



    }

    @Override
    public int getItemCount() {
        return applianceDataArr.length;
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name_appliance_list_tv;
        private TextView type_appliance_list_tv;
        private TextView description_appliance_list_tv;
        private ImageView monitoring_appliance_list_img;
        private ImageView notification_appliance_list_img;
        private ConstraintLayout layout_appliancelist_rv_constraint;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name_appliance_list_tv = itemView.findViewById(R.id.name_appliance_list_tv);
            type_appliance_list_tv = itemView.findViewById(R.id.type_appliance_list_tv);
            description_appliance_list_tv = itemView.findViewById(R.id.description_appliance_list_tv);
            monitoring_appliance_list_img = itemView.findViewById(R.id.monitoring_appliance_list_img);
            notification_appliance_list_img = itemView.findViewById(R.id.notification_appliance_list_img);
            layout_appliancelist_rv_constraint = itemView.findViewById(R.id.layout_appliancelist_rv_constraint);
        }
    }
}
