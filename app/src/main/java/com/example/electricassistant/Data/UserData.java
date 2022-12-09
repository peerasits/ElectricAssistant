package com.example.electricassistant.Data;

import com.example.electricassistant.display_data.GeneralDisplayData;

import java.time.LocalDateTime;
import java.util.List;

public class UserData {
    private GeneralDisplayData displayData;
    private String username;
    private LocalDateTime loginTime;
    private List<HomeData> arrHomeData;
    private int homeSelectedIndex;
    private HomeData homeSelected;
    private boolean enableNotification, ignoreNotification, enableSoundNotification;
    private FontSizeEnum fontSize;
    private CurrencyEnum currency;
    private GaugeUnitEnum unitOfGauge;
    private UnitEnum unitOfSystem;
    private GaugeRefreshRateEnum gaugeRefreshRate;
    private SyncRefreshRateEnum syncRefreshRate;
    private GuageTypeEnum guageType;

    public UserData(GeneralDisplayData displayData, String username, LocalDateTime loginTime, List<HomeData> arrHomeData, int homeSelectedIndex, HomeData homeSelected, boolean enableNotification, boolean ignoreNotification, boolean enableSoundNotification, FontSizeEnum fontSize, CurrencyEnum currency, GaugeUnitEnum unitOfGauge, UnitEnum unitOfSystem, GaugeRefreshRateEnum gaugeRefreshRate, SyncRefreshRateEnum syncRefreshRate, GuageTypeEnum guageType) {
        this.displayData = displayData;
        this.username = username;
        this.loginTime = loginTime;
        this.arrHomeData = arrHomeData;
        this.homeSelectedIndex = homeSelectedIndex;
        this.homeSelected = homeSelected;
        this.enableNotification = enableNotification;
        this.ignoreNotification = ignoreNotification;
        this.enableSoundNotification = enableSoundNotification;
        this.fontSize = fontSize;
        this.currency = currency;
        this.unitOfGauge = unitOfGauge;
        this.unitOfSystem = unitOfSystem;
        this.gaugeRefreshRate = gaugeRefreshRate;
        this.syncRefreshRate = syncRefreshRate;
        this.guageType = guageType;
    }

    public GeneralDisplayData getDisplayData() {
        return displayData;
    }

    public void setDisplayData(GeneralDisplayData displayData) {
        this.displayData = displayData;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDateTime getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(LocalDateTime loginTime) {
        this.loginTime = loginTime;
    }

    public List<HomeData> getArrHomeData() {
        return arrHomeData;
    }

    public void setArrHomeData(List<HomeData> arrHomeData) {
        this.arrHomeData = arrHomeData;
    }

    public int getHomeSelectedIndex() {
        return homeSelectedIndex;
    }

    public void setHomeSelectedIndex(int homeSelectedIndex) {
        this.homeSelectedIndex = homeSelectedIndex;
    }

    public HomeData getHomeSelected() {
        return homeSelected;
    }

    public void setHomeSelected(HomeData homeSelected) {
        this.homeSelected = homeSelected;
    }

    public boolean isEnableNotification() {
        return enableNotification;
    }

    public void setEnableNotification(boolean enableNotification) {
        this.enableNotification = enableNotification;
    }

    public boolean isIgnoreNotification() {
        return ignoreNotification;
    }

    public void setIgnoreNotification(boolean ignoreNotification) {
        this.ignoreNotification = ignoreNotification;
    }

    public boolean isEnableSoundNotification() {
        return enableSoundNotification;
    }

    public void setEnableSoundNotification(boolean enableSoundNotification) {
        this.enableSoundNotification = enableSoundNotification;
    }

    public FontSizeEnum getFontSize() {
        return fontSize;
    }

    public void setFontSize(FontSizeEnum fontSize) {
        this.fontSize = fontSize;
    }

    public CurrencyEnum getCurrency() {
        return currency;
    }

    public void setCurrency(CurrencyEnum currency) {
        this.currency = currency;
    }

    public GaugeUnitEnum getUnitOfGauge() {
        return unitOfGauge;
    }

    public void setUnitOfGauge(GaugeUnitEnum unitOfGauge) {
        this.unitOfGauge = unitOfGauge;
    }

    public UnitEnum getUnitOfSystem() {
        return unitOfSystem;
    }

    public void setUnitOfSystem(UnitEnum unitOfSystem) {
        this.unitOfSystem = unitOfSystem;
    }

    public GaugeRefreshRateEnum getGaugeRefreshRate() {
        return gaugeRefreshRate;
    }

    public void setGaugeRefreshRate(GaugeRefreshRateEnum gaugeRefreshRate) {
        this.gaugeRefreshRate = gaugeRefreshRate;
    }

    public SyncRefreshRateEnum getSyncRefreshRate() {
        return syncRefreshRate;
    }

    public void setSyncRefreshRate(SyncRefreshRateEnum syncRefreshRate) {
        this.syncRefreshRate = syncRefreshRate;
    }

    public GuageTypeEnum getGuageType() {
        return guageType;
    }

    public void setGuageType(GuageTypeEnum guageType) {
        this.guageType = guageType;
    }

    @Override
    public String toString() {
        return "UserData{" +
                "displayData=" + displayData +
                ", username='" + username + '\'' +
                ", loginTime=" + loginTime +
                ", arrHomeData=" + arrHomeData +
                ", homeSelectedIndex=" + homeSelectedIndex +
                ", homeSelected=" + homeSelected +
                ", enableNotification=" + enableNotification +
                ", ignoreNotification=" + ignoreNotification +
                ", enableSoundNotification=" + enableSoundNotification +
                ", fontSize=" + fontSize +
                ", currency=" + currency +
                ", unitOfGauge=" + unitOfGauge +
                ", unitOfSystem=" + unitOfSystem +
                ", gaugeRefreshRate=" + gaugeRefreshRate +
                ", syncRefreshRate=" + syncRefreshRate +
                ", guageType=" + guageType +
                '}';
    }
}
