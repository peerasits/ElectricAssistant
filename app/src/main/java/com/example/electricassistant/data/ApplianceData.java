package com.example.electricassistant.data;

import com.example.electricassistant.data_enum.TypeOfApplianceEnum;
import com.example.electricassistant.data_enum.VoltageEnum;

public class ApplianceData {
    private String id;
    private String name;
    private TypeOfApplianceEnum typeOfApplianceEnum;
    private boolean status, iscurrent, isvoltage;
    private boolean isDeviceMonitoing, isTimmer, isNotify;
    private String description;
    private VoltageEnum defaultVoltage;
    private double countdownTime;

    public ApplianceData(String id,String name, TypeOfApplianceEnum typeOfApplianceEnum, boolean status,
                         boolean iscurrent, boolean isvoltage, boolean isDeviceMonitoing,
                         boolean isTimmer, boolean isNotify, String description, VoltageEnum defaultVoltage,
                         double countdownTime) {
        this.id = id;
        this.name = name;
        this.typeOfApplianceEnum = typeOfApplianceEnum;
        this.status = status;
        this.iscurrent = iscurrent;
        this.isvoltage = isvoltage;
        this.isDeviceMonitoing = isDeviceMonitoing;
        this.isTimmer = isTimmer;
        this.isNotify = isNotify;
        this.description = description;
        this.defaultVoltage = defaultVoltage;
        this.countdownTime = countdownTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TypeOfApplianceEnum getTypeOfApplianceEnum() {
        return typeOfApplianceEnum;
    }

    public void setTypeOfApplianceEnum(TypeOfApplianceEnum typeOfApplianceEnum) {
        this.typeOfApplianceEnum = typeOfApplianceEnum;
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

    public VoltageEnum getDefaultVoltage() {
        return defaultVoltage;
    }

    public void setDefaultVoltage(VoltageEnum defaultVoltage) {
        this.defaultVoltage = defaultVoltage;
    }

    public double getCountdownTime() {
        return countdownTime;
    }

    public void setCountdownTime(double countdownTime) {
        this.countdownTime = countdownTime;
    }
}
