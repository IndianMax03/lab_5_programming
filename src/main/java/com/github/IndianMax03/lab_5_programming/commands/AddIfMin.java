package com.github.indianMax03.lab_5_programming.commands;

import com.github.indianMax03.lab_5_programming.base.City;
import com.github.indianMax03.lab_5_programming.base.Human;

import java.util.TreeSet;

public class AddIfMin {
    public static void call(TreeSet<City> cities, Human[] leaders){
        System.out.println("Будьте внимательны! Если значение поля population добавляемого города будет больше или равно " +
                "значению популяции наименьшего города, он не будет добавлен.");
        System.out.print("Наименьшее значение популяции: ");
        System.out.println(cities.first().getName() + ". Популяция: " + cities.first().getPopulation());
        City trycity = Add.call(leaders);
        if (trycity.getPopulation() >= cities.first().getPopulation()){
            System.out.println("Вы меня ослушались, город не будет добавлен.");
            Show.call(cities);
        } else {
            cities.add(trycity);
            System.out.println("Город успешно добавлен!");
        }
        Show.call(cities);
    }
}
