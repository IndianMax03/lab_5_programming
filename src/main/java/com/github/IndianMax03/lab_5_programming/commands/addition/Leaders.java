package com.github.indianMax03.lab_5_programming.commands.addition;

import com.github.indianMax03.lab_5_programming.base.Climate;
import com.github.indianMax03.lab_5_programming.base.Human;

import java.util.Scanner;

public enum Leaders {
    MAXIM("Максим Исполнитель"),
    MARTIN("Мартин Надзиратель"),
    ANTONY("Антон Терпила"),
    ANASTACY("Анастасия Милосердная"),
    ILIA("Илья Бессмертный");

    private final String title;

    Leaders(String title){
        this.title = title;
    }

    @Override
    public String toString() { return title;}

    public static Human chooseLeader(){
        Scanner sc = new Scanner(System.in);
        Byte leadnum;
        System.out.println("Выберите правителя: ");
        for (byte i = 0; i < Leaders.values().length; i++){
            System.out.println((i + 1) + ")" + Leaders.values()[i]);
        }
        do {
            String input = sc.nextLine();
            try {
                leadnum = Byte.parseByte(input);
                if (leadnum < 1 || leadnum > 5) {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                System.out.println("Введите одну из предложенных цифр.");
                leadnum = null;
            }
        } while (leadnum == null);

        Leaders leader = Leaders.values()[leadnum-1];
        return Human.randomHuman(leader.toString());
    }

    public static Human checkLeaderValid(String input){
        for (int i = 0; i < values().length; i++){
            if (values()[i].toString().equals(input)){
                return Human.randomHuman(values()[i].toString());
            }
        }
        return null;
    }
}
