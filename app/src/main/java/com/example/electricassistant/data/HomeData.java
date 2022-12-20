package com.example.electricassistant.data;

import com.example.electricassistant.display_data.GeneralDisplayData;

import java.util.List;

public class HomeData {
    private String name;
    private String address;
    private MeasureEnum measure;
    private VoltageEnum voltage;
    private boolean isMonitoring;
    private List<RoomData> rooms;
    private GeneralDisplayData displayData;
    private String urlOfHome;

    public HomeData(String name, String address, MeasureEnum measure, VoltageEnum voltage,
                    boolean isMonitoring, List<RoomData> rooms, GeneralDisplayData displayData, String urlOfHome) {
        this.name = name;
        this.address = address;
        this.measure = measure;
        this.voltage = voltage;
        this.isMonitoring = isMonitoring;
        this.rooms = rooms;
        this.displayData = displayData;
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

    public GeneralDisplayData getDisplayData() {
        return displayData;
    }

    public void setDisplayData(GeneralDisplayData displayData) {
        this.displayData = displayData;
    }

    public String getUrlOfHome() {
        return urlOfHome;
    }

    public void setUrlOfHome(String urlOfHome) {
        this.urlOfHome = urlOfHome;
    }
}
