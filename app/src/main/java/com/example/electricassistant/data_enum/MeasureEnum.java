package com.example.electricassistant.data_enum;

import java.util.Arrays;

public enum MeasureEnum {
    Not_Above_150,
    Above_150,
    TOU;

    public static String[] toArray(Class<? extends Enum<?>> e) {
        String[] result =  Arrays.stream(e.getEnumConstants()).map(Enum::name).toArray(String[]::new);

        for(int i = 0 ;i < result.length;i++){
            result[i] = result[i].replaceAll("_"," ");
        }

        return result;
    }

    public static MeasureEnum convertMeasureEnumStrToEnum(String measureEnumStr){
        MeasureEnum[] allMeasureEnumElements = MeasureEnum.values();
        String[] allStringFromMeasureEnumElements = toArray(MeasureEnum.class);
        MeasureEnum resultMeasureEnum = null;

        for(int i = 0;i<allStringFromMeasureEnumElements.length;i++){
            if(allStringFromMeasureEnumElements[i].indexOf(measureEnumStr) != -1){
                resultMeasureEnum = allMeasureEnumElements[i];
                break;
            }
        }
        return resultMeasureEnum;
    }
}
