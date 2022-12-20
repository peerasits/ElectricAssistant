package com.example.electricassistant.util;

import com.example.electricassistant.data.RoomData;
import com.example.electricassistant.data.TypeOfRoomEnum;

public class ConvertStringFromEnum {
    public static int itemDefineFromTypeOfRoomSpinner(RoomData roomSelected){
        int resultValue = -1;
        TypeOfRoomEnum typeOfRoomEnum = roomSelected.getTypeOfRoom();
        switch (typeOfRoomEnum) {
            case Basement:
                resultValue = 0;
                break;
            case Bathroom:
                resultValue = 1;
                break;
            case Bedroom:
                resultValue = 2;
                break;
            case Dining_Room:
                resultValue = 3;
                break;
            case Game_Room:
                resultValue = 4;
                break;
            case Home_Gym:
                resultValue = 5;
                break;
            case Home_Office:
                resultValue = 6;
                break;
            case Home_Theater:
                resultValue = 7;
                break;
            case Kitchen:
                resultValue = 8;
                break;
            case Laundry_Room:
                resultValue = 9;
                break;
            case Library_Study:
                resultValue = 10;
                break;
            case Living_Room:
                resultValue = 11;
                break;
            case Loft:
                resultValue = 12;
                break;
            case Nursery:
                resultValue = 13;
                break;
            case Playroom:
                resultValue = 14;
                break;
            case Storage_Room:
                resultValue = 15;
                break;
            case Other_Room:
                resultValue = 16;
                break;
            default:
                break;
        }
        return resultValue;
    }

    public static int itemDefineFromMaxApplianceSpinner(RoomData roomSelected){
        int maxApplienceValue = roomSelected.getMaxAppliances();
        int resultValue = -1;
        switch(maxApplienceValue){
            case 5:
                resultValue = 0;
                break;
            case 10:
                resultValue = 1;
                break;
            default:
                break;
        }
        return resultValue;
    }
}
