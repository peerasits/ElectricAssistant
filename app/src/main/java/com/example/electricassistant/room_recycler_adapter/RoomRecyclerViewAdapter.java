package com.example.electricassistant.room_recycler_adapter;

import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.electricassistant.appliance_device.ApplianceDeviceListActivity;
import com.example.electricassistant.data.RoomData;
import com.example.electricassistant.R;

import java.util.List;

public class RoomRecyclerViewAdapter extends RecyclerView.Adapter<RoomRecyclerViewAdapter.ViewHolder> {

    private Intent applianceListIntent;

    private FragmentActivity fragmentActivity;
    private List<RoomData> rooms;
    private BottomSheetCreateForRoom bottomSheetCreateForRoom;


    public RoomRecyclerViewAdapter(FragmentActivity fragmentActivity,List<RoomData> rooms) {
        bottomSheetCreateForRoom = new BottomSheetCreateForRoom();
        this.fragmentActivity = fragmentActivity;
        this.rooms = rooms;
    }

    @NonNull
    @Override
    public RoomRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.roomlist_display,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RoomRecyclerViewAdapter.ViewHolder holder, int position) {

        String roomNameToSent = rooms.get(position).getName();
        String descriptionToSent = rooms.get(position).getDescription();

        class OnClickSelf implements View.OnClickListener{

            @Override
            public void onClick(View view) {
                bottomSheetCreateForRoom.create(fragmentActivity,roomNameToSent,descriptionToSent,position);
            }
        }
        if(position%2 == 0)
            holder.layout_roomlist_rv_constraint.setBackgroundColor(Color.rgb(232,231,231));
        holder.room_title_rv_tv.setText(rooms.get(position).getName());
        holder.room_desc_rv_tv.setText(rooms.get(position).getDescription());
        holder.option_room_rv_img.setOnClickListener(new OnClickSelf());

        holder.layout_roomlist_rv_constraint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                applianceListIntent = new Intent(fragmentActivity, ApplianceDeviceListActivity.class);
                applianceListIntent.putExtra("roomName", roomNameToSent);
                applianceListIntent.putExtra("roomDescription", descriptionToSent);
                applianceListIntent.putExtra("indexOfRoom", position);
                fragmentActivity.startActivity(applianceListIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return rooms.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView room_title_rv_tv;
        TextView room_desc_rv_tv;
        ImageView option_room_rv_img;
        ConstraintLayout layout_roomlist_rv_constraint;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            room_title_rv_tv = itemView.findViewById(R.id.room_title_rv_tv);
            room_desc_rv_tv = itemView.findViewById(R.id.room_desc_rv_tv);
            option_room_rv_img = itemView.findViewById(R.id.option_room_rv_img);
            layout_roomlist_rv_constraint = itemView.findViewById(R.id.layout_roomlist_rv_constraint);
        }
    }
}
