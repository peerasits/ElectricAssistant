package com.example.electricassistant.display_data;

import java.time.LocalDateTime;

public class VoltageDisplayData extends GeneralDisplayData {
    private double typeOfVoltage;
    private double frequency;

    public VoltageDisplayData(double value, double min, double max, LocalDateTime whenMin, LocalDateTime whenMax, double average, double rangeMin, double rangeMax, double typeOfVoltage, double frequency) {
        super(value, min, max, whenMin, whenMax, average, rangeMin, rangeMax);
        this.typeOfVoltage = typeOfVoltage;
        this.frequency = frequency;
    }

    public double getTypeOfVoltage() {
        return typeOfVoltage;
    }

    public void setTypeOfVoltage(double typeOfVoltage) {
        this.typeOfVoltage = typeOfVoltage;
    }

    public double getFrequency() {
        return frequency;
    }

    public void setFrequency(double frequency) {
        this.frequency = frequency;
    }
}
