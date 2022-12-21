package com.example.electricassistant.data;

import java.util.Arrays;
import java.util.List;

public class RoomData {

    private String name;
    private TypeOfRoomEnum typeOfRoom;
    private String description;
    private boolean isMonitoring;
    private int maxAppliances;
    private List<ApplianceData> applianceList;

    public RoomData(String name, TypeOfRoomEnum typeOfRoom, String description, boolean isMonitoring, int maxAppliances, List<ApplianceData> applianceList) {
        this.name = name;
        this.typeOfRoom = typeOfRoom;
        this.description = description;
        this.isMonitoring = isMonitoring;
        this.maxAppliances = maxAppliances;
        this.applianceList = applianceList;
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

    public List<ApplianceData> getApplianceList() {
        return applianceList;
    }

    public boolean setApplianceList(List<ApplianceData> applianceList) {
        if (applianceList.size() <= maxAppliances) {
            this.applianceList = applianceList;
            return true;
        }else{
            return false;
        }
    }

    @Override
    public String toString() {
        return "RoomData{" +
                "name='" + name + '\'' +
                ", typeOfRoom=" + typeOfRoom +
                ", description='" + description + '\'' +
                ", isMonitoring=" + isMonitoring +
                ", maxAppliances=" + maxAppliances +
                ", applianceList=" + applianceList +
                '}';
    }
}
