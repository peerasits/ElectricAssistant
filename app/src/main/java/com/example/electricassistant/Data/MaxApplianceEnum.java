package com.example.electricassistant.Data;

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
}
