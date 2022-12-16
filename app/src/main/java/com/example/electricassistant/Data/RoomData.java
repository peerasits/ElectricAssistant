package com.example.electricassistant.Data;

public class RoomData {

    private String name;
    private String description;
    private boolean isMonitoring;
    private ApplianceData[] appliances;

    public RoomData(String name, String description, boolean isMonitoring, ApplianceData[] appliances) {
        this.name = name;
        this.description = description;
        this.isMonitoring = isMonitoring;
        this.appliances = appliances;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isMonitoring() {
        return isMonitoring;
    }

    public void setMonitoring(boolean monitoring) {
        isMonitoring = monitoring;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ApplianceData[] getAppliances() {
        return appliances;
    }

    public void setAppliances(ApplianceData[] appliances) {
        this.appliances = appliances;
    }
}
