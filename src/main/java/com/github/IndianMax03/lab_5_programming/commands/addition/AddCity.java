package com.github.indianMax03.lab_5_programming.commands.addition;

import com.github.indianMax03.lab_5_programming.base.*;

import java.time.ZonedDateTime;
import java.util.Scanner;
import java.util.TreeSet;

public class AddCity {

    public static String addCity(TreeSet<City> collection){
        City addingcity = createCity();
        collection.add(addingcity);
        return "Город успешно добавлен в коллекцию!";
    }

    public static String addCityIfMin(TreeSet<City> collection){
        City addingcity = createCity();
        if (addingcity.compareTo(collection.first()) < 0) {
            collection.add(addingcity);
            return "Город успешно добавлен!";
        } else{
            return "Город добавить не удалось.";
        }
    }

    public static City createCity(){

        Scanner sc = new Scanner(System.in);
        InputTester inputTester = new InputTester();

        long id = (long) (Math.random() * 1000000 + 1);

        String name = inputTester.nameInput();

        Coordinates coordinates = inputTester.coordinatesInput();

        ZonedDateTime creationDate = ZonedDateTime.now();

        float area = inputTester.areaInput();

        int population = inputTester.populationInput();

        float masl = inputTester.metersAboveSeaLevelInput();

        Climate climate = Climate.chooseClimate();

        Government government = Government.chooseGovernment();

        StandardOfLiving standardOfLiving = StandardOfLiving.chooseStandardOfLiving();

        Human governor = Leaders.chooseLeader();

        return new City(id, name, coordinates, creationDate, area, population, masl, climate, government,standardOfLiving,
                governor);
    }
}
