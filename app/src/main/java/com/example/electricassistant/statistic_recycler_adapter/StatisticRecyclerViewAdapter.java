package com.example.electricassistant.statistic_recycler_adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.electricassistant.R;
import com.example.electricassistant.data.StatisticData;

import java.util.List;

public class StatisticRecyclerViewAdapter extends RecyclerView.Adapter<StatisticRecyclerViewAdapter.ViewHolder>{

    List<StatisticData> statisticDataList;
    Context context;

    public StatisticRecyclerViewAdapter(List<StatisticData> statisticDataList, Context context) {
        this.statisticDataList = statisticDataList;
        this.context = context;
    }

    @NonNull
    @Override
    public StatisticRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.statistic_list_display,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StatisticRecyclerViewAdapter.ViewHolder holder, int position) {
        holder.statistic_title_rv_tv.setText(statisticDataList.get(position).getName());
        holder.statistic_description_rv_tv.setText(statisticDataList.get(position).getDescription());

    }

    @Override
    public int getItemCount() {
        return statisticDataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView statistic_title_rv_tv;
        TextView statistic_description_rv_tv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            statistic_title_rv_tv = itemView.findViewById(R.id.statistic_title_rv_tv);
            statistic_description_rv_tv = itemView.findViewById(R.id.statistic_description_rv_tv);
        }
    }
}
