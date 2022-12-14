package com.example.electricassistant.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.electricassistant.global_data.GlobalData;
import com.example.electricassistant.data.HomeData;
import com.example.electricassistant.R;
import com.example.electricassistant.home_recycler_adapter.HomeRecyclerViewAdapter;
import com.example.electricassistant.home.AddHomeActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeSelectFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeSelectFragment extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeSelectFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeSelectFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeSelectFragment newInstance(String param1, String param2) {
        HomeSelectFragment fragment = new HomeSelectFragment();
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

    private RecyclerView homelist_recyclerview;
    public static HomeRecyclerViewAdapter homeAdapter;
    private List<HomeData> homeDataList = GlobalData.currentUserData.getArrHomeData();
    private FloatingActionButton addHomeBtn;
    private Intent intent;
    private static TextView no_data_homeselect_tv;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home_select, container, false);
        homelist_recyclerview = v.findViewById(R.id.homelist_recyclerview);
        no_data_homeselect_tv = v.findViewById(R.id.no_data_homeselect_tv);
        no_data_homeselect_tv.setVisibility(View.GONE);
        setHomeRecyclerView();

        addHomeBtn = v.findViewById(R.id.add_home_btn);
        addHomeBtn.setOnClickListener(this::onClick);


        return v;
    }


    @Override
    public void onResume() {
        super.onResume();
        setHomeRecyclerView();
        setNoDataTextView();
    }

    private void setHomeRecyclerView() {
        homeAdapter = new HomeRecyclerViewAdapter(getActivity(), homeDataList);
        homeAdapter.notifyDataSetChanged();
        homelist_recyclerview.setAdapter(homeAdapter);
        homelist_recyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    public static void setNoDataTextView() {
        List<HomeData> homeDataList = GlobalData.currentUserData.getArrHomeData();
        if (homeDataList == null || GlobalData.currentUserData.getArrHomeData().size() <= 0) {
            no_data_homeselect_tv.setVisibility(View.VISIBLE);
        } else {
            no_data_homeselect_tv.setVisibility(View.GONE);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.add_home_btn:
                intent = new Intent(getActivity(), AddHomeActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}