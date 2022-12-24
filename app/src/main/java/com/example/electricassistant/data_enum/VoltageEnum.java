package com.example.electricassistant.data_enum;


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

    public static VoltageEnum convertVoltageEnumStrToEnum(String voltageStr){
        VoltageEnum[] allVoltageEnumElements = VoltageEnum.values();
        String[] allStringFromVoltageEnumElements = toArray(VoltageEnum.class);
        VoltageEnum resultVoltageEnum = null;

        for(int i = 0;i<allStringFromVoltageEnumElements.length;i++){
            if(allStringFromVoltageEnumElements[i].indexOf(voltageStr) != -1){
                resultVoltageEnum = allVoltageEnumElements[i];
                break;
            }
        }
        return resultVoltageEnum;
    }
}


