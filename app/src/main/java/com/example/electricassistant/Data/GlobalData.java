package com.example.electricassistant.Data;


import java.util.ArrayList;
import java.util.List;

public class GlobalData {
    public static List<HomeData> homeDataList = new ArrayList<HomeData>();
    public static HomeData homeSelected;


    public static void initData(){
        homeDataList.add(new HomeData("Home01","Nakhonpathom","test",true,null));
        homeDataList.add(new HomeData("Home02","Bangkok","test2",false,null));
        homeDataList.add(new HomeData("Home03","Petchburi","test3",true,null));
        homeSelected = homeDataList.get(0);
    }
}
