package com.github.indianMax03.lab_5_programming.commands;
import com.github.indianMax03.lab_5_programming.Main;
import com.github.indianMax03.lab_5_programming.base.*;
import com.github.indianMax03.lab_5_programming.commands.addition.HumanFactory;
import com.github.indianMax03.lab_5_programming.commands.addition.Leaders;
import com.github.indianMax03.lab_5_programming.commands.addition.RandomDate;

import java.time.ZonedDateTime;
import java.util.Scanner;

public class Add implements Command {
    @Override
    public void execute() {
        Scanner sc = new Scanner(System.in);

        // id
        long id = (long) (Math.random()) * 1000000 + 1;
        System.out.println("id города: " + id);

        //  name
        System.out.print("Введите название города: ");
        String name = sc.next();
        System.out.println("Название города: " + name);

        //  coordinates
        System.out.println("Введите координаты x, y: ");
        System.out.print("x = "); Double x = sc.nextDouble();
        System.out.print("y = "); Double y = sc.nextDouble();
        Coordinates coordinates = new Coordinates(x, y);
        System.out.println("Координаты: " + coordinates);

        //  Time
        ZonedDateTime time = RandomDate.getDate();

        //  Area
        System.out.println("Введите площадь города: ");
        float area = sc.nextFloat();
        System.out.println("Площадь S = " + area);

        //  Population
        System.out.println("Введите население города: ");
        int population = sc.nextInt();
        System.out.println("Население N = " + population);

        //  Meters Above Sea Level
        System.out.println("Введите высоту над уровнем моря: ");
        float metersAboveSeaLevel = sc.nextFloat();
        System.out.println("Высота h = " + metersAboveSeaLevel);

        // Climate
        System.out.println("Выберите климат: ");
        for (int i = 0; i < Climate.values().length; i++){
            System.out.println((i + 1) + ") " + Climate.values()[i]);
        }
        int climatenum = sc.nextInt();
        Climate climate = Climate.values()[climatenum-1];
        System.out.println("Выбранный климат: " + climate);

        //  Government
        System.out.println("Выберите тип правления: ");
        for (int i = 0; i < Government.values().length; i++){
            System.out.println((i + 1) + ") " + Government.values()[i]);
        }
        int governmentnum = sc.nextInt();
        Government government = Government.values()[governmentnum-1];
        System.out.println("Выбранный тип правления: " + government);

        //  Standart of living
        System.out.println("Выберите уровень жизни: ");
        for (int i = 0; i < StandardOfLiving.values().length; i++){
            System.out.println((i + 1) + ") " + StandardOfLiving.values()[i]);
        }
        int standardOfLivingnum = sc.nextInt();
        StandardOfLiving standardOfLiving = StandardOfLiving.values()[standardOfLivingnum-1];
        System.out.println("Выбранный уровень жизни: " + standardOfLiving);

        //  Governor
        System.out.println("Выберите правителя: ");
        for (int i = 0; i < Leaders.values().length; i++){
            System.out.println((i + 1) + ") " + Leaders.values()[i]);
        }
        int leadernum = sc.nextInt();
        Leaders leader = Leaders.values()[standardOfLivingnum-1];
        Human governor = HumanFactory.create(leader.toString());
        System.out.println("Выбранный правитель: " + leader);

        Main.cities.add(new City(id, name, coordinates, time, area, population, metersAboveSeaLevel,
                climate, government, standardOfLiving, governor));

    }
}
