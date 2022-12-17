package com.example.electricassistant.global_data;


import com.example.electricassistant.Data.CurrencyEnum;
import com.example.electricassistant.Data.FontSizeEnum;
import com.example.electricassistant.Data.GaugeRefreshRateEnum;
import com.example.electricassistant.Data.GaugeUnitEnum;
import com.example.electricassistant.Data.GuageTypeEnum;
import com.example.electricassistant.Data.HomeData;
import com.example.electricassistant.Data.MeasureEnum;
import com.example.electricassistant.Data.RoomData;
import com.example.electricassistant.Data.SyncRefreshRateEnum;
import com.example.electricassistant.Data.UnitEnum;
import com.example.electricassistant.Data.UserData;
import com.example.electricassistant.Data.VoltageEnum;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class GlobalData {
    public static UserData currentUserData;
    private static List<HomeData> homeDataList = new ArrayList<HomeData>();
    private static List<RoomData> roomDataList = new ArrayList<RoomData>();
    private static HomeData homeSelected;

    public static void initUserData(){
        ininRoomData();
        initHomeData();

        LocalDateTime localDateTime = LocalDateTime.now();
        int indexHomeSelected = 0;
        HomeData homeSeleted = homeDataList.get(indexHomeSelected);
        currentUserData = new UserData(null,"Porome",localDateTime,homeDataList,indexHomeSelected,homeSeleted,true,false,true,
                FontSizeEnum.Normal,CurrencyEnum.THB,GaugeUnitEnum.kilowatt,UnitEnum.kilowatt,GaugeRefreshRateEnum.sec5,SyncRefreshRateEnum.week1,GuageTypeEnum.ElectricityUsageGauge);

    }


    public static void initHomeData(){
        homeDataList.add(new HomeData("Home01","Nakhonpathom", MeasureEnum.Above_150, VoltageEnum._110v,true,roomDataList));
        homeDataList.add(new HomeData("Home02","Bangkok",MeasureEnum.TOU,VoltageEnum._220v,false,null));
        homeDataList.add(new HomeData("Home03","Petchburi",MeasureEnum.Not_Above_150,VoltageEnum._230v,true,null));

    }

    public static void ininRoomData(){
        roomDataList.add(new RoomData("Living room","This is an example living room",true,null));
        roomDataList.add(new RoomData("Bed room","Sleepy naja",true,null));
        roomDataList.add(new RoomData("Kitchen","Les't cook some foods or some drinks",false,null));
    }
}
