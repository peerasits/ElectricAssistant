package com.example.electricassistant.data;

public class ApplianceData {
    private String name;
    private String type;
    private boolean status, iscurrent, isvoltage;
    private boolean isDeviceMonitoing, isTimmer, isNotify;
    private String description;
    private double defalutVoltage, countdownTime;

    public ApplianceData(String name, String type, boolean status, boolean iscurrent, boolean isvoltage, boolean isDeviceMonitoing, boolean isTimmer, boolean isNotify, String description, double defalutVoltage, double countdownTime) {
        this.name = name;
        this.type = type;
        this.status = status;
        this.iscurrent = iscurrent;
        this.isvoltage = isvoltage;
        this.isDeviceMonitoing = isDeviceMonitoing;
        this.isTimmer = isTimmer;
        this.isNotify = isNotify;
        this.description = description;
        this.defalutVoltage = defalutVoltage;
        this.countdownTime = countdownTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isIscurrent() {
        return iscurrent;
    }

    public void setIscurrent(boolean iscurrent) {
        this.iscurrent = iscurrent;
    }

    public boolean isIsvoltage() {
        return isvoltage;
    }

    public void setIsvoltage(boolean isvoltage) {
        this.isvoltage = isvoltage;
    }

    public boolean isDeviceMonitoing() {
        return isDeviceMonitoing;
    }

    public void setDeviceMonitoing(boolean deviceMonitoing) {
        isDeviceMonitoing = deviceMonitoing;
    }

    public boolean isTimmer() {
        return isTimmer;
    }

    public void setTimmer(boolean timmer) {
        isTimmer = timmer;
    }

    public boolean isNotify() {
        return isNotify;
    }

    public void setNotify(boolean notify) {
        isNotify = notify;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getDefalutVoltage() {
        return defalutVoltage;
    }

    public void setDefalutVoltage(double defalutVoltage) {
        this.defalutVoltage = defalutVoltage;
    }

    public double getCountdownTime() {
        return countdownTime;
    }

    public void setCountdownTime(double countdownTime) {
        this.countdownTime = countdownTime;
    }
}
