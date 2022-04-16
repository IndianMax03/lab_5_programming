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
        Byte climnum;
        System.out.println("Выберите климат: ");
        for (byte i = 0; i < values().length; i++) {
            System.out.println((i + 1) + ")" + values()[i]);
        }
        do {
            String input = sc.nextLine();
            try {
                climnum = Byte.parseByte(input);
                if (climnum < 1 || climnum > 3) {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                System.out.println("Введите одну из предложенных цифр.");
                climnum = null;
            }
        } while (climnum == null);

        return Climate.values()[climnum-1];
    }

    public static Climate checkClimateValid(String input){
        for (int i = 0; i < values().length; i++){
            if (values()[i].toString().equals(input)){
                return values()[i];
            }
        }
        return null;
    }

}
