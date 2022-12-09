package com.example.electricassistant.Data;

import java.time.LocalDateTime;
import java.util.Random;

public class GeneralDisplayData {
    private double value;
    private double min,max;
    private LocalDateTime whenMin;
    private LocalDateTime whenMax;
    private double average;
    private double rangeMin,rangeMax;

    public GeneralDisplayData(double value, double min, double max, LocalDateTime whenMin, LocalDateTime whenMax, double average, double rangeMin, double rangeMax) {
        this.value = value;
        this.min = min;
        this.max = max;
        this.whenMin = whenMin;
        this.whenMax = whenMax;
        this.average = average;
        this.rangeMin = rangeMin;
        this.rangeMax = rangeMax;
    }


    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void generateValue(){
        Random random = new Random();
        value = random.nextInt((int)rangeMax)+1;
    }

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }

    public LocalDateTime getWhenMin() {
        return whenMin;
    }

    public void setWhenMin(LocalDateTime whenMin) {
        this.whenMin = whenMin;
    }

    public LocalDateTime getWhenMax() {
        return whenMax;
    }

    public void setWhenMax(LocalDateTime whenMax) {
        this.whenMax = whenMax;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public double getRangeMin() {
        return rangeMin;
    }

    public void setRangeMin(double rangeMin) {
        this.rangeMin = rangeMin;
    }

    public double getRangeMax() {
        return rangeMax;
    }

    public void setRangeMax(double rangeMax) {
        this.rangeMax = rangeMax;
    }
}

class ElectricUsageDisplayData extends GeneralDisplayData{
    public ElectricUsageDisplayData(double value, double min, double max, LocalDateTime whenMin, LocalDateTime whenMax, double average, double rangeMin, double rangeMax) {
        super(value, min, max, whenMin, whenMax, average, rangeMin, rangeMax);
    }
}

class PowerSavedDisplayData extends GeneralDisplayData{
    public PowerSavedDisplayData(double value, double min, double max, LocalDateTime whenMin, LocalDateTime whenMax, double average, double rangeMin, double rangeMax) {
        super(value, min, max, whenMin, whenMax, average, rangeMin, rangeMax);
    }
}
class CostSavedDisplayData extends GeneralDisplayData{
    public CostSavedDisplayData(double value, double min, double max, LocalDateTime whenMin, LocalDateTime whenMax, double average, double rangeMin, double rangeMax) {
        super(value, min, max, whenMin, whenMax, average, rangeMin, rangeMax);
    }
}
class VoltageDisplayData extends GeneralDisplayData{
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
class CurrentDisplayData extends GeneralDisplayData{
    public CurrentDisplayData(double value, double min, double max, LocalDateTime whenMin, LocalDateTime whenMax, double average, double rangeMin, double rangeMax) {
        super(value, min, max, whenMin, whenMax, average, rangeMin, rangeMax);
    }
}