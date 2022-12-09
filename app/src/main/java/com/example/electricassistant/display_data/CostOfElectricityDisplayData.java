package com.example.electricassistant.display_data;

import java.time.LocalDateTime;

public class CostOfElectricityDisplayData extends GeneralDisplayData {
    private String typeOfUse;
    private double reachedOfCost;
    private boolean isReached;

    public CostOfElectricityDisplayData(double value, double min, double max, LocalDateTime whenMin, LocalDateTime whenMax, double average, double rangeMin, double rangeMax, String typeOfUse, double reachedOfCost, boolean isReached) {
        super(value, min, max, whenMin, whenMax, average, rangeMin, rangeMax);
        this.typeOfUse = typeOfUse;
        this.reachedOfCost = reachedOfCost;
        this.isReached = isReached;
    }

    public String getTypeOfUse() {
        return typeOfUse;
    }

    public void setTypeOfUse(String typeOfUse) {
        this.typeOfUse = typeOfUse;
    }

    public double getReachedOfCost() {
        return reachedOfCost;
    }

    public void setReachedOfCost(double reachedOfCost) {
        this.reachedOfCost = reachedOfCost;
    }

    public boolean isReached() {
        return isReached;
    }

    public void setReached(boolean reached) {
        isReached = reached;
    }
}
