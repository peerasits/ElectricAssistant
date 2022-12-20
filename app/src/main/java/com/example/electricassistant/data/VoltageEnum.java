package com.example.electricassistant.data;


import java.util.Arrays;

public enum VoltageEnum {
    _110v,
    _220v,
    _230v;

    public static String[] toArray(Class<? extends Enum<?>> e){
        String[] result = Arrays.stream(e.getEnumConstants()).map(Enum::name).toArray(String[]::new);
        for(int i = 0 ;i < result.length;i++){
            result[i] = result[i].replaceAll("_"," ");
        }

        return result;
    }
}


