package com.github.indianMax03.lab_5_programming.addition;

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

}
