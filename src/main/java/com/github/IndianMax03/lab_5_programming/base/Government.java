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

}
