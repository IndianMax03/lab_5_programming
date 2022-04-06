package com.github.indianMax03.lab_5_programming.base;

import java.util.Scanner;

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

    public static StandardOfLiving chooseStandardOfLiving(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Выберите уровень жизни: ");
        for (byte i = 0; i < StandardOfLiving.values().length; i++){
            System.out.println((i + 1) + ")" + StandardOfLiving.values()[i]);
        }
        byte stannum = sc.nextByte();
        return StandardOfLiving.values()[stannum-1];
    }
}
