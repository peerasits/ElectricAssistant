package com.example.electricassistant.Data;

import java.util.Arrays;

public class RoomData {

    private String name;
    private TypeOfRoomEnum typeOfRoom;
    private String description;
    private boolean isMonitoring;
    private int maxAppliances;
    private ApplianceData[] appliances;

    public RoomData(String name, TypeOfRoomEnum typeOfRoom, String description, boolean isMonitoring, int maxAppliances, ApplianceData[] appliances) {
        this.name = name;
        this.typeOfRoom = typeOfRoom;
        this.description = description;
        this.isMonitoring = isMonitoring;
        this.maxAppliances = maxAppliances;
        this.appliances = appliances;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TypeOfRoomEnum getTypeOfRoom() {
        return typeOfRoom;
    }

    public void setTypeOfRoom(TypeOfRoomEnum typeOfRoom) {
        this.typeOfRoom = typeOfRoom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isMonitoring() {
        return isMonitoring;
    }

    public void setMonitoring(boolean monitoring) {
        isMonitoring = monitoring;
    }

    public int getMaxAppliances() {
        return maxAppliances;
    }

    public void setMaxAppliances(int maxAppliances) {
        this.maxAppliances = maxAppliances;
    }

    public ApplianceData[] getAppliances() {
        return appliances;
    }

    public void setAppliances(ApplianceData[] appliances) {
        this.appliances = appliances;
    }

    @Override
    public String toString() {
        return "RoomData{" +
                "name='" + name + '\'' +
                ", typeOfRoom=" + typeOfRoom +
                ", description='" + description + '\'' +
                ", isMonitoring=" + isMonitoring +
                ", maxAppliances=" + maxAppliances +
                ", appliances=" + Arrays.toString(appliances) +
                '}';
    }
}
