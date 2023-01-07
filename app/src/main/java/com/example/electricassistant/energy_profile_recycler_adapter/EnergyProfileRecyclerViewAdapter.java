package com.example.electricassistant.energy_profile_recycler_adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.electricassistant.R;
import com.example.electricassistant.data.EnergyProfileData;

import java.util.List;

public class EnergyProfileRecyclerViewAdapter extends RecyclerView.Adapter<EnergyProfileRecyclerViewAdapter.ViewHolder> {

    List<EnergyProfileData> list;
    Context context;

    public EnergyProfileRecyclerViewAdapter(Context context,List<EnergyProfileData> list) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.energyprofile_list_display,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.energyprofile_title_rv_tv.setText(list.get(position).getName());
        holder.energyprofile_description_rv_tv.setText(list.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView energyprofile_title_rv_tv;
        TextView energyprofile_description_rv_tv;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            energyprofile_title_rv_tv = itemView.findViewById(R.id.energyprofile_title_rv_tv);
            energyprofile_description_rv_tv = itemView.findViewById(R.id.energyprofile_description_rv_tv);
        }
    }
}
