package com.example.electricassistant.data_enum;

import com.example.electricassistant.data.RoomData;

import java.util.Arrays;

public enum MaxApplianceEnum {
    m5,
    m10;

    public static String[] toArray(Class<? extends Enum<?>> e) {
        String[] result = Arrays.stream(e.getEnumConstants()).map(Enum::name).toArray(String[]::new);

        for (int i = 0; i < result.length; i++) {
            result[i] = result[i].replaceAll("m", "");
        }

        return result;
    }

    public static int getIndexOfMaxApplianceEnumFromRoomObj(RoomData selectRoom){
        MaxApplianceEnum[] allOfMaxApplianceEnumElements = MaxApplianceEnum.values();
        for(int i = 0 ;i<allOfMaxApplianceEnumElements.length;i++){
            if(allOfMaxApplianceEnumElements[i].toString().indexOf(String.valueOf(selectRoom.getMaxAppliances()))!= -1){
                return i;
            }
        }
        return -1;
    }


}
