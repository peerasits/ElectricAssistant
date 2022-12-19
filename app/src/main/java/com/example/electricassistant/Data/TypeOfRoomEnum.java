package com.example.electricassistant.Data;

import java.util.Arrays;

public enum TypeOfRoomEnum {
    Basement,
    Bathroom,
    Bedroom,
    Dining_Room,
    Game_Room,
    Home_Gym,
    Home_Office,
    Home_Theater,
    Kitchen,
    Laundry_Room,
    Library_Study,
    Living_Room,
    Loft,
    Nursery,
    Playroom,
    Storage_Room,
    Other_Room;

    public static String[] toArray(Class<? extends Enum<?>> e) {
        String[] result = Arrays.stream(e.getEnumConstants()).map(Enum::name).toArray(String[]::new);

        for (int i = 0; i < result.length; i++) {
            result[i] = result[i].replaceAll("_", " ");
        }

        return result;
    }
}