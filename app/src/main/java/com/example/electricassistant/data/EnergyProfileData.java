package com.example.electricassistant.data;

public class EnergyProfileData {
    private String name;
    private String description;
    private boolean isCustomable;
    private boolean isSave;
    private boolean isLimitUsage;
    private double limitUsage;
    private boolean islimitTime;
    private double limitTime;

    public EnergyProfileData(String name, String description, boolean isCustomable, boolean isSave, boolean isLimitUsage, double limitUsage, boolean islimitTime, double limitTime) {
        this.name = name;
        this.description = description;
        this.isCustomable = isCustomable;
        this.isSave = isSave;
        this.isLimitUsage = isLimitUsage;
        this.limitUsage = limitUsage;
        this.islimitTime = islimitTime;
        this.limitTime = limitTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCustomable() {
        return isCustomable;
    }

    public void setCustomable(boolean customable) {
        isCustomable = customable;
    }

    public boolean isSave() {
        return isSave;
    }

    public void setSave(boolean save) {
        isSave = save;
    }

    public boolean isLimitUsage() {
        return isLimitUsage;
    }

    public void setLimitUsage(boolean limitUsage) {
        isLimitUsage = limitUsage;
    }

    public double getLimitUsage() {
        return limitUsage;
    }

    public void setLimitUsage(double limitUsage) {
        this.limitUsage = limitUsage;
    }

    public boolean isIslimitTime() {
        return islimitTime;
    }

    public void setIslimitTime(boolean islimitTime) {
        this.islimitTime = islimitTime;
    }

    public double getLimitTime() {
        return limitTime;
    }

    public void setLimitTime(double limitTime) {
        this.limitTime = limitTime;
    }
}
