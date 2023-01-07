package com.example.electricassistant.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.electricassistant.R;
import com.example.electricassistant.data.EnergyProfileData;
import com.example.electricassistant.energy_profile_recycler_adapter.EnergyProfileRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EnergyProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EnergyProfileFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public EnergyProfileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment EnergyProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static EnergyProfileFragment newInstance(String param1, String param2) {
        EnergyProfileFragment fragment = new EnergyProfileFragment();
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
    private RecyclerView energyprofilelist_recyclerview;
    private EnergyProfileRecyclerViewAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        EnergyProfileData energyProfileData = new EnergyProfileData("save","this is an save option",false,false,true,10,true,10);
        List<EnergyProfileData> energyProfileDataList = new ArrayList<EnergyProfileData>();
        energyProfileDataList.add(energyProfileData);
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_energy_profile, container, false);

        energyprofilelist_recyclerview = v.findViewById(R.id.energyprofilelist_recyclerview);
        adapter = new EnergyProfileRecyclerViewAdapter(getActivity(),energyProfileDataList);
        adapter.notifyDataSetChanged();
        energyprofilelist_recyclerview.setAdapter(adapter);
        energyprofilelist_recyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));


        return v;
    }
}