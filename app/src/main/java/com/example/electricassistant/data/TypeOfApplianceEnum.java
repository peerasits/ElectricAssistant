package com.example.electricassistant.data;

import java.util.Arrays;

public enum TypeOfApplianceEnum {
    Air_conditioner,
    Bachelor_griller,
    Clothes_dryer,
    Clothes_iron,
    Coffee_maker_Blender,
    Desktop_Computer,
    Dishwasher,
    Electric_drill,
    Electric_fan,
    Electric_guitar,
    Electric_kettle,
    Evaporative_cooler,
    Kitchen_hood,
    Lantern_Torch,
    Laptop,
    Light_bulb,
    Microwave,
    Mixer_Toaster,
    Oven_Dishwasher,
    Phone_Charger,
    Pressure_cooker,
    Refrigerator,
    Rice_cooker,
    Stove_Lamp,
    Television,
    Tumble_Dryer,
    Vacuum_cleaner,
    Washing_Machine,
    Washing_machine,
    Water_purifier,
    Other;

    public static String[] toArray(Class<? extends Enum<?>> e) {
        String[] result = Arrays.stream(e.getEnumConstants()).map(Enum::name).toArray(String[]::new);

        for (int i = 0; i < result.length; i++) {
            result[i] = result[i].replaceAll("_", " ");
        }

        return result;
    }
}
