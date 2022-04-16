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
        Byte govnum;
        System.out.println("Выберите тип правления: ");
        for (byte i = 0; i < Government.values().length; i++){
            System.out.println((i + 1) + ")" + Government.values()[i]);
        }
        do {
            String input = sc.nextLine();
            try {
                govnum = Byte.parseByte(input);
                if (govnum < 1 || govnum > 4) {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                System.out.println("Введите одну из предложенных цифр.");
                govnum = null;
            }
        } while (govnum == null);

        return Government.values()[govnum-1];
    }

    public static Government checkCGovernmentValid(String input){
        for (int i = 0; i < values().length; i++){
            if (values()[i].toString().equals(input)){
                return values()[i];
            }
        }
        return null;
    }

}
