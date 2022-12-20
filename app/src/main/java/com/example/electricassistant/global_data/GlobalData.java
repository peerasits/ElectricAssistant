package com.example.electricassistant.global_data;


import com.example.electricassistant.data.CurrencyEnum;
import com.example.electricassistant.data.FontSizeEnum;
import com.example.electricassistant.data.GaugeRefreshRateEnum;
import com.example.electricassistant.data.GaugeUnitEnum;
import com.example.electricassistant.data.GuageTypeEnum;
import com.example.electricassistant.data.HomeData;
import com.example.electricassistant.data.MeasureEnum;
import com.example.electricassistant.data.RoomData;
import com.example.electricassistant.data.SyncRefreshRateEnum;
import com.example.electricassistant.data.TypeOfRoomEnum;
import com.example.electricassistant.data.UnitEnum;
import com.example.electricassistant.data.UserData;
import com.example.electricassistant.data.VoltageEnum;
import com.example.electricassistant.display_data.GeneralDisplayData;

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
        currentUserData = new UserData("Porome",localDateTime,homeDataList,indexHomeSelected,homeSeleted,true,false,true,
                FontSizeEnum.Normal,CurrencyEnum.THB,GaugeUnitEnum.kilowatt,UnitEnum.kilowatt,GaugeRefreshRateEnum.sec5,SyncRefreshRateEnum.week1,GuageTypeEnum.ElectricityUsageGauge);

    }


    public static void initHomeData(){
        GeneralDisplayData home01DisplayData = new GeneralDisplayData(0,0,100,LocalDateTime.now(),LocalDateTime.now(),50,0,100);
        GeneralDisplayData home02DisplayData = new GeneralDisplayData(0,0,200,LocalDateTime.now(),LocalDateTime.now(),50,0,200);
        GeneralDisplayData home03DisplayData = new GeneralDisplayData(0,0,300,LocalDateTime.now(),LocalDateTime.now(),50,0,300);
        homeDataList.add(new HomeData("Home01","Nakhonpathom", MeasureEnum.Above_150, VoltageEnum._110v,true,roomDataList,
                home01DisplayData,"https://media.esperanzahomes.com/153/2021/9/15/AUGUSTIN_Page_7.1920x1440.jpg"));
        homeDataList.add(new HomeData("Home02","Bangkok",MeasureEnum.TOU,VoltageEnum._220v,false,null,
                home02DisplayData,"https://www.realestate.com.au/blog/images/2000x1500-fit,progressive/2021/11/24151024/Rawson_Facade2_2000x1500.jpg"));
        homeDataList.add(new HomeData("Home03","Petchburi",MeasureEnum.Not_Above_150,VoltageEnum._230v,true,null,
                home03DisplayData,"https://hba-th.org/images/news/Landy_Home_ICON_460_1200x720.jpg"));

    }

    public static void ininRoomData(){
        roomDataList.add(new RoomData("Living room", TypeOfRoomEnum.Dining_Room,"This is an example living room",true,5,null));
        roomDataList.add(new RoomData("Bed room",TypeOfRoomEnum.Bathroom,"Sleepy naja",true,5,null));
        roomDataList.add(new RoomData("Kitchen",TypeOfRoomEnum.Bedroom,"Les't cook some foods or some drinks",false,5,null));
    }
}
