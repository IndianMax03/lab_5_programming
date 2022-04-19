package com.github.indianMax03.lab_5_programming.input;

import com.github.indianMax03.lab_5_programming.base.*;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.TreeSet;

/**
 * Class works with adding cities
 */
public class Adder {

    /**
     * add command realisation
     */
    public static String addCity(TreeSet<City> collection){
        City addingcity = createCity();
        if(collection.add(addingcity)){
        return "Город успешно добавлен в коллекцию!";
        } else{
            return "Коллекция не рассматривает хранение одинаковых объектов. Элемент не будет добавлен.";
        }
    }

    /**
     * add_if_min command realisation
     */
    public static String addCityIfMin(TreeSet<City> collection){
        City addingcity = createCity();
        if (addingcity.compareTo(collection.first()) < 0) {
            collection.add(addingcity);
            return "Город успешно добавлен.";
        } else{
            return "Город добавить не удалось.";
        }
    }

    /**
     * parser of input collection
     */
    public static String canAddCityByArray(ArrayList<String> cityString, int line, TreeSet<City> collection){
        if (cityString.size() != 11){
            return "Город из строки " + line + " файла создать не удалось: передано неверное количество аргументов.";
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

    /**
     * testing and adding cities from array
     */
    private static City createCityByArray(ArrayList<String> citysFields){

        Validator validator = new Validator();

        Long id = validator.checkIdValid(citysFields.get(0));
        String name = validator.checkNameValid(citysFields.get(1));
        Coordinates coordinates = validator.checkCoordinatesValid(citysFields.get(2));
        ZonedDateTime creationDate = validator.checkDataValid(citysFields.get(3));
        Float area = validator.checkAreaValid(citysFields.get(4));
        Integer population = validator.checkPopulationValid(citysFields.get(5));
        Float masl = validator.checkMetersAboveSeaLevelValid(citysFields.get(6));
        Climate climate = validator.checkClimateByNameValid(citysFields.get(7));
        Government government = validator.checkGovernmentByNameValid(citysFields.get(8));
        StandardOfLiving standardOfLiving = validator.checkStandartOfLivingByNameValid(citysFields.get(9));
        Human leader = validator.checkLeadersByNameValid(citysFields.get(10));

        try {
            return new City(id, name, coordinates, creationDate, area, population, masl, climate, government, standardOfLiving,
                    leader);
        } catch (Exception e){
            return null;
        }
    }

    /**
     * testing and adding cities from the user input
     */
    public static City createCity(){

        Tester tester = new Tester();

        long id = (long) (Math.random() * 1000000 + 1);

        String name = tester.nameInput();

        Coordinates coordinates = tester.coordinatesInput();

        ZonedDateTime creationDate = ZonedDateTime.now();

        float area = tester.areaInput();

        int population = tester.populationInput();

        float masl = tester.metersAboveSeaLevelInput();

        Climate climate = tester.climateInput();

        Government government = tester.governmentInput();

        StandardOfLiving standardOfLiving = tester.standardOfLivingInput();

        Human governor = tester.leaderInput();

        return new City(id, name, coordinates, creationDate, area, population, masl, climate, government,standardOfLiving,
                governor);
    }

}
