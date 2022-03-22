package com.github.indianMax03.lab_5_programming.commands;

import com.github.indianMax03.lab_5_programming.base.City;

import java.util.TreeSet;

public class Show {
    public static void call(TreeSet<City> collection){
        System.out.println("Ваша коллекция: ");
        int i = 0;
        for (City city : collection){
            i += 1;
            System.out.println(i + ". " + city + ", ID = " + city.getId() + ", N = " + city.getPopulation());
        }
    }
}
