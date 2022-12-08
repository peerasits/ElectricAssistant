package com.example.electricassistant.RecyclerAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.electricassistant.Data.HomeData;
import com.example.electricassistant.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.List;

public class HomeRecyclerviewAdapter extends RecyclerView.Adapter<HomeRecyclerviewAdapter.ViewHolder> {

    List<HomeData> homeDataList;
    FragmentActivity fragmentActivity;

    public HomeRecyclerviewAdapter(FragmentActivity fragmentActivity,List<HomeData> homeDataList) {
        this.fragmentActivity = fragmentActivity;
        this.homeDataList = homeDataList;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView home_title_rv_tv;
        private TextView home_desc_rv_tv;
        private ImageView option_rv_img;


        public ViewHolder(View view) {
            super(view);

            home_title_rv_tv = view.findViewById(R.id.home_title_rv_tv);
            home_desc_rv_tv = view.findViewById(R.id.home_desc_rv_tv);
            option_rv_img = view.findViewById(R.id.option_rv_img);

        }


    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.homelist_display,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.home_title_rv_tv.setText(homeDataList.get(position).getName());
        holder.home_desc_rv_tv.setText(homeDataList.get(position).getAddress());
        holder.option_rv_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new bottomSheetCreateForHome().create(fragmentActivity,homeDataList.get(position).getName());
            }
        });
    }

    @Override
    public int getItemCount() {
        return homeDataList.size();
    }



}
