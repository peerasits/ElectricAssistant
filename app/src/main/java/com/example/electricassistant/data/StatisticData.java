package com.example.electricassistant.data;

public class StatisticData {
    private String name;
    private String description;
    private int type;
    private boolean isGraph;
    private boolean isSummary;

    public StatisticData(String name, String description, int type, boolean isGraph, boolean isSummary) {
        this.name = name;
        this.description = description;
        this.type = type;
        this.isGraph = isGraph;
        this.isSummary = isSummary;
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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public boolean isGraph() {
        return isGraph;
    }

    public void setGraph(boolean graph) {
        isGraph = graph;
    }

    public boolean isSummary() {
        return isSummary;
    }

    public void setSummary(boolean summary) {
        isSummary = summary;
    }
}
