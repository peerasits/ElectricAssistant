package com.example.electricassistant.Data;

import java.util.List;

public class HomeData {
    private String name;
    private String address;
    private MeasureEnum measure;
    private boolean isMonitoring;
    private List<RoomData> rooms;

    public HomeData(String name, String address, MeasureEnum measure, boolean isMonitoring, List<RoomData> rooms) {
        this.name = name;
        this.address = address;
        this.measure = measure;
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

    public MeasureEnum getMeasure() {
        return measure;
    }

    public void setMeasure(MeasureEnum measure) {
        this.measure = measure;
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
