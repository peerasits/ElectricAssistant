package com.example.electricassistant.util;

import com.example.electricassistant.data.MeasureEnum;
import com.example.electricassistant.data.TypeOfRoomEnum;
import com.example.electricassistant.data.VoltageEnum;

public class ConvertEnumFromString {
    public static MeasureEnum convertMeasureStrtoEnum(String measureStr) {
        MeasureEnum resultMeasure;
        if (measureStr.equals(MeasureEnum.Above_150.toString()))
            resultMeasure = MeasureEnum.Above_150;
        else if (measureStr.equals(MeasureEnum.Not_Above_150.toString()))
            resultMeasure = MeasureEnum.Not_Above_150;
        else
            resultMeasure = MeasureEnum.TOU;
        return resultMeasure;
    }

    public static VoltageEnum convertVoltageStrToEnum(String voltageStr) {
        VoltageEnum resultVoltage;
        if (voltageStr.indexOf("110") != -1) {
            resultVoltage = VoltageEnum._110v;
        } else if (voltageStr.indexOf("220") != -1) {
            resultVoltage = VoltageEnum._220v;
        } else {
            resultVoltage = VoltageEnum._230v;
        }
        return resultVoltage;
    }

    public static TypeOfRoomEnum convertTypeOfRoomToEnum(String typeOfRoomStr) {
        TypeOfRoomEnum resultTypeOfRoom;
        if (typeOfRoomStr.indexOf("Basement") != -1)
            resultTypeOfRoom = TypeOfRoomEnum.Basement;
        else if (typeOfRoomStr.indexOf("Bathroom") != -1)
            resultTypeOfRoom = TypeOfRoomEnum.Bathroom;
        else if (typeOfRoomStr.indexOf("Bedroom") != -1)
            resultTypeOfRoom = TypeOfRoomEnum.Bedroom;
        else if (typeOfRoomStr.indexOf("Dining Room") != -1)
            resultTypeOfRoom = TypeOfRoomEnum.Dining_Room;
        else if (typeOfRoomStr.indexOf("Game Room") != -1)
            resultTypeOfRoom = TypeOfRoomEnum.Game_Room;
        else if (typeOfRoomStr.indexOf("Gym") != -1)
            resultTypeOfRoom = TypeOfRoomEnum.Home_Gym;
        else if (typeOfRoomStr.indexOf("Office") != -1)
            resultTypeOfRoom = TypeOfRoomEnum.Bedroom;
        else if (typeOfRoomStr.indexOf("Theater") != -1)
            resultTypeOfRoom = TypeOfRoomEnum.Home_Theater;
        else if (typeOfRoomStr.indexOf("Kitchen") != -1)
            resultTypeOfRoom = TypeOfRoomEnum.Kitchen;
        else if (typeOfRoomStr.indexOf("Laundry Room") != -1)
            resultTypeOfRoom = TypeOfRoomEnum.Laundry_Room;
        else if (typeOfRoomStr.indexOf("Library Study") != -1)
            resultTypeOfRoom = TypeOfRoomEnum.Library_Study;
        else if (typeOfRoomStr.indexOf("Living Room") != -1)
            resultTypeOfRoom = TypeOfRoomEnum.Living_Room;
        else if (typeOfRoomStr.indexOf("Loft") != -1)
            resultTypeOfRoom = TypeOfRoomEnum.Loft;
        else if (typeOfRoomStr.indexOf("Nursery") != -1)
            resultTypeOfRoom = TypeOfRoomEnum.Nursery;
        else if (typeOfRoomStr.indexOf("Playroom") != -1)
            resultTypeOfRoom = TypeOfRoomEnum.Playroom;
        else if (typeOfRoomStr.indexOf("Storage Room") != -1)
            resultTypeOfRoom = TypeOfRoomEnum.Storage_Room;
        else
            resultTypeOfRoom = TypeOfRoomEnum.Other_Room;
        return resultTypeOfRoom;
    }
}
