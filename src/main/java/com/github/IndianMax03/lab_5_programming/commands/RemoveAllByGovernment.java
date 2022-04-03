package com.github.indianMax03.lab_5_programming.commands;

import com.github.indianMax03.lab_5_programming.base.City;
import com.github.indianMax03.lab_5_programming.base.Government;

import java.util.Scanner;
import java.util.TreeSet;

public class RemoveAllByGovernment {
    public static void call(TreeSet<City> cities){
        System.out.println("Вы собираетесь удалить все элементы коллекции, значение поля government которых соответствует" +
                " выбранному");
        Scanner sc = new Scanner(System.in);
        System.out.println("Выберите поле: ");
        System.out.println("1. " + Government.THALASSOCRACY);
        System.out.println("2. " + Government.DICTATORSHIP);
        System.out.println("3. " + Government.THEOCRACY);
        System.out.println("4. " + Government.ANARCHY);
        int remnum = sc.nextInt();
        Government remgov;
        if (remnum == 1) remgov = Government.THALASSOCRACY;
        else if (remnum == 2) remgov = Government.DICTATORSHIP;
        else if (remnum == 3) remgov = Government.THEOCRACY;
        else if (remnum == 4) remgov = Government.ANARCHY;
        else remgov = Government.ANARCHY;

        cities.removeIf(city -> city.getGovernment() == remgov);
        Show.call(cities);
    }
}
