package com.example.electricassistant.global_data;


import com.example.electricassistant.Data.CurrencyEnum;
import com.example.electricassistant.Data.FontSizeEnum;
import com.example.electricassistant.Data.GaugeRefreshRateEnum;
import com.example.electricassistant.Data.GaugeUnitEnum;
import com.example.electricassistant.Data.GuageTypeEnum;
import com.example.electricassistant.Data.HomeData;
import com.example.electricassistant.Data.SyncRefreshRateEnum;
import com.example.electricassistant.Data.UnitEnum;
import com.example.electricassistant.Data.UserData;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class GlobalData {
    public static UserData currentUserData;
    public static List<HomeData> homeDataList = new ArrayList<HomeData>();
    public static HomeData homeSelected;

    public static void initUserData(){
        initData();
        LocalDateTime localDateTime = LocalDateTime.now();
        int indexHomeSelected = 0;
        currentUserData = new UserData(null,"Porome",localDateTime,homeDataList,indexHomeSelected,null,true,false,true,
                FontSizeEnum.Normal,CurrencyEnum.THB,GaugeUnitEnum.kilowatt,UnitEnum.kilowatt,GaugeRefreshRateEnum.sec5,SyncRefreshRateEnum.week1,GuageTypeEnum.ElectricityUsageGauge);
        homeSelected = homeDataList.get(indexHomeSelected);
        currentUserData.setHomeSelected(homeSelected);
    }


    public static void initData(){
        homeDataList.add(new HomeData("Home01","Nakhonpathom","test",true,null));
        homeDataList.add(new HomeData("Home02","Bangkok","test2",false,null));
        homeDataList.add(new HomeData("Home03","Petchburi","test3",true,null));

    }
}
