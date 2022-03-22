package com.github.indianMax03.lab_5_programming.commands;

import com.github.indianMax03.lab_5_programming.base.City;

import java.util.Scanner;
import java.util.TreeSet;

public class RemoveLower {
    public static void call(TreeSet<City> cities) {
        System.out.println("Вы собираетесь удалить все города, население которых меньше введённого вами значения.");
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите значение популяции: ");
        int pop = sc.nextInt();
        cities.removeIf(city -> city.getPopulation() < pop);
        Show.call(cities);
    }
}
