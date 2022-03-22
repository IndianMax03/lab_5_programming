package com.github.indianMax03.lab_5_programming.commands;

import com.github.indianMax03.lab_5_programming.base.City;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

public class UpdateID {
    static Scanner sc = new Scanner(System.in);
    public static void call(TreeSet<City> cities) throws NoSuchFieldException, IllegalAccessException {
        System.out.println("Введите ID элемента, значение которого хотите поменять: ");
        final int ID = sc.nextInt();
        for (City city :cities){
            if (city.getId() == ID){
                System.out.println("Введите поле: ");
                String update = sc.next();
                Field field = City.class.getDeclaredField(update);
                field.setAccessible(true);
                System.out.println("Введите введите новое значение поля: ");
                int newfield = sc.nextInt();
                field.setInt(city, newfield);
                System.out.println("Area = " + city.getArea());
            }
        }

        System.out.println("Значение поля успешно изменено!");

    }
}
