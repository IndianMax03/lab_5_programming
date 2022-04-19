package com.github.indianMax03.lab_5_programming.addition;

/**
 * Enum of Governors
 */
public enum Leaders {

    MAXIM("Максим Прогер"),
    MARTIN("Мартин Надзиратель"),
    ANTONY("Антон Терпила"),
    ANASTACY("Анастасия Милосердная"),
    ILIA("Юникс Бессмертный");

    private final String title;

    Leaders(String title){
        this.title = title;
    }

    @Override
    public String toString() { return title;}

}
