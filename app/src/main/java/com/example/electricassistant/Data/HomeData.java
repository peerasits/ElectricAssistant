package com.example.electricassistant.Data;

public class HomeData {
    private String name;
    private String address;
    private String typeOfUse;
    private boolean isActive;
    private boolean isMonitoring;
    private RoomData[] rooms;


    public HomeData(String name, String address, String typeOfUse, boolean isActive, boolean isMonitoring, RoomData[] rooms) {
        this.name = name;
        this.address = address;
        this.typeOfUse = typeOfUse;
        this.isActive = isActive;
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

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean isMonitoring() {
        return isMonitoring;
    }

    public void setMonitoring(boolean monitoring) {
        isMonitoring = monitoring;
    }

    public RoomData[] getRooms() {
        return rooms;
    }

    public void setRooms(RoomData[] rooms) {
        this.rooms = rooms;
    }


}
