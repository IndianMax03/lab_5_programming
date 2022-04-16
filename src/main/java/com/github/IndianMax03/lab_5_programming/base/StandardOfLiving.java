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
        Byte stannum;
        for (byte i = 0; i < StandardOfLiving.values().length; i++){
            System.out.println((i + 1) + ")" + StandardOfLiving.values()[i]);
        }
        do {
            String input = sc.nextLine();
            try {
                stannum = Byte.parseByte(input);
                if (stannum < 1 || stannum > 3) {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                System.out.println("Введите одну из предложенных цифр.");
                stannum = null;
            }
        } while (stannum == null);

        return StandardOfLiving.values()[stannum-1];
    }

    public static StandardOfLiving checkClimateValid(String input){
        for (int i = 0; i < values().length; i++){
            if (values()[i].toString().equals(input)){
                return values()[i];
            }
        }
        return null;
    }

}
