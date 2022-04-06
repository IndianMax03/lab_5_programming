package com.github.indianMax03.lab_5_programming.commands.addition;

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
        System.out.println("Выберите правителя: ");
        for (byte i = 0; i < Leaders.values().length; i++){
            System.out.println((i + 1) + ")" + Leaders.values()[i]);
        }
        byte leadnum = sc.nextByte();
        Leaders leader = Leaders.values()[leadnum-1];
        return Human.randomHuman(leader.toString());
    }
}
