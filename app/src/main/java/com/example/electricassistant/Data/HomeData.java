package com.example.electricassistant.Data;

import java.util.List;

public class HomeData {
    private String name;
    private String address;
    private MeasureEnum measure;
    private VoltageEnum voltage;
    private boolean isMonitoring;
    private List<RoomData> rooms;
    private String urlOfHome;

    public HomeData(String name, String address, MeasureEnum measure, VoltageEnum voltage, boolean isMonitoring, List<RoomData> rooms, String urlOfHome) {
        this.name = name;
        this.address = address;
        this.measure = measure;
        this.voltage = voltage;
        this.isMonitoring = isMonitoring;
        this.rooms = rooms;
        this.urlOfHome = urlOfHome;
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

    public VoltageEnum getVoltage() {
        return voltage;
    }

    public void setVoltage(VoltageEnum voltage) {
        this.voltage = voltage;
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

    public String getUrlOfHome() {
        return urlOfHome;
    }

    public void setUrlOfHome(String urlOfHome) {
        this.urlOfHome = urlOfHome;
    }

    @Override
    public String toString() {
        return "HomeData{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", measure=" + measure +
                ", voltage=" + voltage +
                ", isMonitoring=" + isMonitoring +
                ", rooms=" + rooms +
                ", urlOfHome='" + urlOfHome + '\'' +
                '}';
    }
}
