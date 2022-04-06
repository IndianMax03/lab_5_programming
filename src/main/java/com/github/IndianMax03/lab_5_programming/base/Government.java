package com.github.indianMax03.lab_5_programming.base;

import java.util.Scanner;

public enum Government {
    ANARCHY("Анархия"),
    DICTATORSHIP("Диктатура"),
    THALASSOCRACY("Талассократия"),
    THEOCRACY("Теократия");

    private final String title;

    Government(String title){
        this.title = title;
    }

    @Override
    public String toString() { return title;}

    public static Government chooseGovernment(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Выберите тип правления: ");
        for (byte i = 0; i < Government.values().length; i++){
            System.out.println((i + 1) + ")" + Government.values()[i]);
        }
        byte govnum = sc.nextByte();
        return Government.values()[govnum-1];
    }
}
