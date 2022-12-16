package com.example.electricassistant.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.electricassistant.Data.RoomData;
import com.example.electricassistant.R;
import com.example.electricassistant.global_data.GlobalData;
import com.example.electricassistant.room_recycler_adapter.RoomRecyclerViewAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RoomFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RoomFragment extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public RoomFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RoomFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RoomFragment newInstance(String param1, String param2) {
        RoomFragment fragment = new RoomFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    private RecyclerView roomlist_recyclerview;
    private RoomRecyclerViewAdapter roomRecyclerViewAdapter;
    private List<RoomData> roomData = GlobalData.currentUserData.getHomeSelected().getRooms();
    private FloatingActionButton add_room_btn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_room, container, false);
        roomlist_recyclerview = v.findViewById(R.id.roomlist_recyclerview);

        add_room_btn = v.findViewById(R.id.add_room_btn);
        add_room_btn.setOnClickListener(this::onClick);

        if(roomData == null){
            roomData = new ArrayList<RoomData>();
        }

        setRoomRecyclerView();
        return v;
    }

    private void setRoomRecyclerView(){
        roomRecyclerViewAdapter = new RoomRecyclerViewAdapter(getActivity(),roomData);
        roomRecyclerViewAdapter.notifyDataSetChanged();
        roomlist_recyclerview.setAdapter(roomRecyclerViewAdapter);
        roomlist_recyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.add_room_btn:
                Toast.makeText(getActivity(), "You clicked add button.", Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(getActivity(), "Default case.", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}