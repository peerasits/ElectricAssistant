package com.example.electricassistant.appliance_device_recycler_adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.electricassistant.R;
import com.example.electricassistant.appliance_device.ApplianceInfoActivity;
import com.example.electricassistant.data.ApplianceData;

import java.util.List;

public class ApplianceDeviceRecyclerViewAdapter extends RecyclerView.Adapter<ApplianceDeviceRecyclerViewAdapter.ViewHolder>{

    private Context context;

    private Intent applianceInfoIntent;

    private List<ApplianceData> applianceDataList;

    public ApplianceDeviceRecyclerViewAdapter(Context context, List<ApplianceData> applianceDataList) {
        this.context = context;
        this.applianceDataList = applianceDataList;
    }

    @NonNull
    @Override
    public ApplianceDeviceRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.appliancelist_device_display, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

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

        String typeOfApplianceStr = applianceDataList.get(position).getTypeOfApplianceEnum().toString().replaceAll("_"," ");

        if (position % 2 == 0)
            holder.layout_appliancelist_rv_constraint.setBackgroundColor(Color.rgb(232, 231, 231));
        holder.layout_appliancelist_rv_constraint.setOnClickListener(new ApplianceItemOnClick());
        holder.name_appliance_list_tv.setText(applianceDataList.get(position).getName());
        holder.type_appliance_list_tv.setText(typeOfApplianceStr);
        holder.description_appliance_list_tv.setText(applianceDataList.get(position).getDescription());
        if (!applianceDataList.get(position).isDeviceMonitoing())
            holder.monitoring_appliance_list_img.setVisibility(View.GONE);
        if (!applianceDataList.get(position).isNotify())
            holder.notification_appliance_list_img.setVisibility(View.GONE);
        holder.powersw_appliance_list_sw.setChecked(applianceDataList.get(position).isStatus());


    }

    @Override
    public int getItemCount() {
        return applianceDataList.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name_appliance_list_tv;
        private TextView type_appliance_list_tv;
        private TextView description_appliance_list_tv;
        private ImageView monitoring_appliance_list_img;
        private ImageView notification_appliance_list_img;
        private Switch powersw_appliance_list_sw;
        private ConstraintLayout layout_appliancelist_rv_constraint;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name_appliance_list_tv = itemView.findViewById(R.id.name_appliance_list_tv);
            type_appliance_list_tv = itemView.findViewById(R.id.type_appliance_list_tv);
            description_appliance_list_tv = itemView.findViewById(R.id.description_appliance_list_tv);
            monitoring_appliance_list_img = itemView.findViewById(R.id.monitoring_appliance_list_img);
            notification_appliance_list_img = itemView.findViewById(R.id.notification_appliance_list_img);
            powersw_appliance_list_sw = itemView.findViewById(R.id.powersw_appliance_list_sw);
            layout_appliancelist_rv_constraint = itemView.findViewById(R.id.layout_appliancelist_rv_constraint);
        }
    }
}
