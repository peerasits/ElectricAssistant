package com.example.electricassistant.display_data;

import java.time.LocalDateTime;

public class PowerSavedDisplayData extends GeneralDisplayData {
    public PowerSavedDisplayData(double value, double min, double max, LocalDateTime whenMin, LocalDateTime whenMax, double average, double rangeMin, double rangeMax) {
        super(value, min, max, whenMin, whenMax, average, rangeMin, rangeMax);
    }
}
