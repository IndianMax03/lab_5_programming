package com.github.indianMax03.lab_5_programming.commands;

import com.github.indianMax03.lab_5_programming.base.City;

import java.util.TreeSet;

public class Info {
    public static void call(TreeSet<City> cities){
        System.out.println("Информация о коллекции:");
        System.out.println("Количество элементов коллекции: " + cities.size());
        System.out.println("Тип коллекции: " + cities.toArray()[0].getClass()); // пока что так
    }
}
