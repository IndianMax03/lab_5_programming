package com.github.indianMax03.lab_5_programming.commands.addition;

import com.github.indianMax03.lab_5_programming.base.*;

import java.time.ZonedDateTime;
import java.util.Scanner;
import java.util.TreeSet;

public class AddCity {

    private Human governor;

    public static void addCity(TreeSet<City> collection){
        City addingcity = createCity();
        collection.add(addingcity);
    }

    public static void addCityIfMin(TreeSet<City> collection){
        City addingcity = createCity();
        if (addingcity.compareTo(collection.first()) < 0) {
            collection.add(addingcity);
            System.out.println("Город успешно добавлен!");
        } else{
            System.out.println("Город добавить не удалось.");
        }
    }

    public static City createCity(){

        Scanner sc = new Scanner(System.in);

        long id = (long) (Math.random() * 10000 + 1);

        System.out.println("Введите имя города: ");
        String name = sc.nextLine();

        System.out.println("Введите координату x: "); double x = sc.nextDouble();
        System.out.println("Введите координату y: "); double y = sc.nextDouble();
        Coordinates coordinates = new Coordinates(x, y);

        ZonedDateTime creationDate = ZonedDateTime.now();

        System.out.println("Введите площадь города: "); float area = sc.nextFloat();

        System.out.println("Введите население города: "); int population = sc.nextInt();

        System.out.println("Введите высоту над уровнем моря: "); float masl = sc.nextFloat();


        Climate climate = Climate.chooseClimate();

        Government government = Government.chooseGovernment();

        StandardOfLiving standardOfLiving = StandardOfLiving.chooseStandardOfLiving();

        Human governor = Leaders.chooseLeader();

        return new City(id, name, coordinates, creationDate, area, population, masl, climate, government,standardOfLiving,
                governor);
    }
}
