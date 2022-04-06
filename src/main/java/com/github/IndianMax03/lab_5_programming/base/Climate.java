package com.github.indianMax03.lab_5_programming.base;

import java.util.Scanner;

public enum Climate {
    HUMIDCONTINENTAL("Влажный континентальный"),
    SUBARCTIC("Субарктический"),
    TUNDRA("Тундра");

    private final String title;

    Climate(String title){
        this.title = title;
    }

    @Override
    public String toString() { return title;}

    public static Climate chooseClimate(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Выберите климат: ");
        for (byte i = 0; i < values().length; i++){
            System.out.println((i + 1) + ")" + values()[i]);
        }
        byte climnum = sc.nextByte();
        return Climate.values()[climnum-1];
    }
}
