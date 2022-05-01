package com.github.indianMax03.lab_5_programming.base;

public enum StandardOfLiving {
    ULTRA_HIGH("Очень высокий"),
    HIGH("Высокий"),
    ULTRA_LOW("Очень низкий");

    private final String title;

    StandardOfLiving(String title){
        this.title = title;
    }

    @Override
    public String toString() { return title;}

}
