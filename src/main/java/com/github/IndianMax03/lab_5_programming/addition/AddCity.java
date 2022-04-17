package com.github.indianMax03.lab_5_programming.addition;

import com.github.indianMax03.lab_5_programming.base.*;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.TreeSet;

public class AddCity {

    public static String addCity(TreeSet<City> collection){
        City addingcity = createCity();
        if(collection.add(addingcity)){
        return "Город успешно добавлен в коллекцию!";
        } else{
            return "Коллекция не рассматривает хранение одинаковых объектов. Элемент не будет добавлен.";
        }
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

    public static String canAddCityByArray(ArrayList<String> cityString, int line, TreeSet<City> collection){
        if (cityString.size() != 11){
            return "Город из строки " + line + " файла создать не удалось: передано неверное количество аргументов";
        } else {
            City city = createCityByArray(cityString);
            if (city != null) {
                collection.add(city);
                return null;
            }
            else {
                return "Обнаружена ошибка в поле строки " + line;
            }
        }
    }

    public static City createCityByArray(ArrayList<String> citysFields){
        InputTester inputTester = new InputTester();
        Long id = inputTester.checkIdValid(citysFields.get(0));
        String name = inputTester.checkNameValid(citysFields.get(1));
        Coordinates coordinates = inputTester.checkXYValid(citysFields.get(2));
        ZonedDateTime creationDate = inputTester.checkDataValid(citysFields.get(3));
        Float area = inputTester.checkAreaValid(citysFields.get(4));
        Integer population = inputTester.checkPopulationValid(citysFields.get(5));
        Float masl = inputTester.checkMASLValid(citysFields.get(6));
        Climate climate = Climate.checkClimateValid(citysFields.get(7));
        Government government = Government.checkCGovernmentValid(citysFields.get(8));
        StandardOfLiving standardOfLiving = StandardOfLiving.checkClimateValid(citysFields.get(9));
        Human leader = Leaders.checkLeaderValid(citysFields.get(10));
        try {
            return new City(id, name, coordinates, creationDate, area, population, masl, climate, government, standardOfLiving,
                    leader);
        } catch (Exception e){
            return null;
        }
    }

    public static City createCity(){

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
