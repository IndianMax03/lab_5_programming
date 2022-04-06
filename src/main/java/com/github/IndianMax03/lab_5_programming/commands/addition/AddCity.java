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

        System.out.println("Выберите климат: ");
        for (byte i = 0; i < Climate.values().length; i++){
            System.out.println((i + 1) + ")" + Climate.values()[i]);
        }
        byte climnum = sc.nextByte();
        Climate climate = Climate.values()[climnum-1];

        System.out.println("Выберите тип правления: ");
        for (byte i = 0; i < Government.values().length; i++){
            System.out.println((i + 1) + ")" + Government.values()[i]);
        }
        byte govnum = sc.nextByte();
        Government government = Government.values()[govnum-1];

        System.out.println("Выберите уровень жизни: ");
        for (byte i = 0; i < StandardOfLiving.values().length; i++){
            System.out.println((i + 1) + ")" + StandardOfLiving.values()[i]);
        }
        byte stannum = sc.nextByte();
        StandardOfLiving standardOfLiving = StandardOfLiving.values()[stannum-1];

        System.out.println("Выберите правителя: ");
        for (byte i = 0; i < Leaders.values().length; i++){
            System.out.println((i + 1) + ")" + Leaders.values()[i]);
        }
        byte leadnum = sc.nextByte();
        Leaders leader = Leaders.values()[leadnum-1];
        Human governor = Human.randomHuman(leader.toString());

        return new City(id, name, coordinates, creationDate, area, population, masl, climate, government,standardOfLiving,
                governor);
    }
}
