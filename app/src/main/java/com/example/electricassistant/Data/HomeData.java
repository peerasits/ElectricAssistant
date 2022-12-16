package com.example.electricassistant.Data;

import java.util.List;

public class HomeData {
    private String name;
    private String address;
    private String typeOfUse;
    private boolean isMonitoring;
    private List<RoomData> rooms;

    public HomeData(String name, String address, String typeOfUse, boolean isMonitoring, List<RoomData> rooms) {
        this.name = name;
        this.address = address;
        this.typeOfUse = typeOfUse;
        this.isMonitoring = isMonitoring;
        this.rooms = rooms;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTypeOfUse() {
        return typeOfUse;
    }

    public void setTypeOfUse(String typeOfUse) {
        this.typeOfUse = typeOfUse;
    }

    public boolean isMonitoring() {
        return isMonitoring;
    }

    public void setMonitoring(boolean monitoring) {
        isMonitoring = monitoring;
    }

    public List<RoomData> getRooms() {
        return rooms;
    }

    public void setRooms(List<RoomData> rooms) {
        this.rooms = rooms;
    }
}
