package com.github.indianMax03.lab_5_programming.commands;

import com.github.indianMax03.lab_5_programming.base.City;

import java.util.Scanner;
import java.util.TreeSet;

public class RemoveByID {
    static Scanner sc = new Scanner(System.in);
    public static void call(TreeSet<City> cities){
        System.out.println("Введите ID элемента, который требуется удалить: ");
        final int ID = sc.nextInt();
        cities.removeIf(city -> city.getId() == ID);
        System.out.println("Элемент успешно удалён.");
        Info.call(cities);
    }
}
