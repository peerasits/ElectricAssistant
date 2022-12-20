package com.example.electricassistant.home_recycler_adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;


import com.example.electricassistant.data.HomeData;
import com.example.electricassistant.R;

import java.util.List;

public class HomeRecyclerViewAdapter extends RecyclerView.Adapter<HomeRecyclerViewAdapter.ViewHolder> {

    List<HomeData> homeDataList;
    FragmentActivity fragmentActivity;

    public HomeRecyclerViewAdapter(FragmentActivity fragmentActivity, List<HomeData> homeDataList) {
        this.fragmentActivity = fragmentActivity;
        this.homeDataList = homeDataList;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView home_title_rv_tv;
        private TextView home_desc_rv_tv;
        private ImageView option_rv_img;
        private ImageView home_monitoring_img_rv;
        private ConstraintLayout layout_homelist_rv_constraint;


        public ViewHolder(View view) {
            super(view);

            home_title_rv_tv = view.findViewById(R.id.home_title_rv_tv);
            home_desc_rv_tv = view.findViewById(R.id.home_desc_rv_tv);
            option_rv_img = view.findViewById(R.id.option_home_rv_img);
            home_monitoring_img_rv = view.findViewById(R.id.home_monitoring_img_rv);
            layout_homelist_rv_constraint = view.findViewById(R.id.layout_homelist_rv_constraint);

        }


    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.homelist_display, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (position % 2 == 0)
            holder.layout_homelist_rv_constraint.setBackgroundColor(Color.rgb(232, 231, 231));
        holder.home_title_rv_tv.setText(homeDataList.get(position).getName());
        holder.home_desc_rv_tv.setText(homeDataList.get(position).getAddress());

        holder.option_rv_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new BottomSheetCreateForHome().create(fragmentActivity, homeDataList.get(position).getName(), homeDataList.get(position).getAddress());
            }
        });

        if (homeDataList.get(position).isMonitoring()) {
            holder.home_monitoring_img_rv.setVisibility(View.VISIBLE);
            holder.home_monitoring_img_rv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(fragmentActivity, "This house is being monitored", Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            holder.home_monitoring_img_rv.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return homeDataList.size();
    }


}
