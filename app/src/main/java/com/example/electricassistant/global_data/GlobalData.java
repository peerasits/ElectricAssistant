package com.example.electricassistant.global_data;


import com.example.electricassistant.data.ApplianceData;
import com.example.electricassistant.data_enum.CurrencyEnum;
import com.example.electricassistant.data_enum.FontSizeEnum;
import com.example.electricassistant.data_enum.GaugeRefreshRateEnum;
import com.example.electricassistant.data_enum.GaugeUnitEnum;
import com.example.electricassistant.data_enum.GuageTypeEnum;
import com.example.electricassistant.data.HomeData;
import com.example.electricassistant.data_enum.MeasureEnum;
import com.example.electricassistant.data.RoomData;
import com.example.electricassistant.data_enum.SyncRefreshRateEnum;
import com.example.electricassistant.data_enum.TypeOfApplianceEnum;
import com.example.electricassistant.data_enum.TypeOfRoomEnum;
import com.example.electricassistant.data_enum.UnitEnum;
import com.example.electricassistant.data.UserData;
import com.example.electricassistant.data_enum.VoltageEnum;
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
        List<ApplianceData> applianceData = new ArrayList<ApplianceData>();
        applianceData.add(new ApplianceData("My device 01", TypeOfApplianceEnum.Air_conditioner, true, true, true, false, false, true, "My example device"
                , VoltageEnum._220v, 5));
        applianceData.add(new ApplianceData("My device 02", TypeOfApplianceEnum.Electric_fan, true, true, true, true, false, true, "My example device 2 naja"
                , VoltageEnum._110v, 5));
        applianceData.add(new ApplianceData("My device 03", TypeOfApplianceEnum.Lantern_Torch, true, true, true, true, false, false, "My pc eiei"
                , VoltageEnum._230v, 5));
        applianceData.add(new ApplianceData("My device 04", TypeOfApplianceEnum.Kitchen_hood, true, true, true, false, false, true, "My pc eiei"
                , VoltageEnum._220v, 5));
        //applianceData.add(new ApplianceData("My device 05", TypeOfApplianceEnum.Clothes_iron, true, true, true, false, false, false, "My pc eiei"
               // , 220, 5));


        roomDataList.add(new RoomData("Living room", TypeOfRoomEnum.Dining_Room,"This is an example living room",true,5,applianceData,
                "https://www.thespruce.com/thmb/eUo2LkU5ac6wa106kKCO65c4VRU=/750x0/filters:no_upscale():max_bytes" +
                        "(150000):strip_icc():format(webp)/10-3-623702d1d102421b9eb5c90b087e42ff.jpeg"));
        roomDataList.add(new RoomData("Bedroom",TypeOfRoomEnum.Bathroom,"Sleepy naja",true,10,new ArrayList<ApplianceData>(),
                "https://www.ikea.com/images/a-light-grey-slattum-upholstered-bed-and-white-nordli-chests-3b97d440fc5abb6b33ebb5a5a8ebca5b.jpg?f=l"));
        roomDataList.add(new RoomData("Kitchen",TypeOfRoomEnum.Bedroom,"Les't cook some foods or some drinks",false,5,new ArrayList<ApplianceData>(),
                "https://foyr.com/learn/wp-content/uploads/2021/06/one-wall-kitchen-design.jpg"));
    }
}
