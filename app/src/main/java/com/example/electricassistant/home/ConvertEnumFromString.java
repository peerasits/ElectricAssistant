package com.example.electricassistant.home;

import com.example.electricassistant.Data.MeasureEnum;
import com.example.electricassistant.Data.VoltageEnum;

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
}
