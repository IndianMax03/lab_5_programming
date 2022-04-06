package com.github.indianMax03.lab_5_programming.commands.patterncommand;

import com.github.indianMax03.lab_5_programming.base.City;
import com.github.indianMax03.lab_5_programming.base.Government;
import com.github.indianMax03.lab_5_programming.commands.addition.AddCity;
import com.github.indianMax03.lab_5_programming.commands.addition.HelpCalling;

import java.time.ZonedDateTime;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class Receiver {

    private final ZonedDateTime creationDate;


    public Receiver(){
        creationDate = ZonedDateTime.now();
    }

    public void help(){
        new HelpCalling();
        }

    public void exit(){
        System.out.println("Спасибо за работу, до свидания!");
        System.exit(1);
    }

    public void clear(TreeSet<City> collection){
        collection.clear();
        System.out.println("Коллекция успешно очищена.");
    }

    public void add(TreeSet<City> collection){
        AddCity.addCity(collection);
        System.out.println("Ваш город успешно добавлен в коллекцию!");
    }

    public void addIfMin(TreeSet<City> collection){
        System.out.println("Следующий введённый город будет добавлен в колекцию в случае, если его поле population будет " +
                "наименьшим в коллекции.");
        System.out.println("На данный момент в коллекции наименьшее значение поля population = " + collection.first().getPopulation());
        AddCity.addCityIfMin(collection);
    }

    public void show(TreeSet<City> collection){
        if (collection.isEmpty()){
            System.out.println("Коллекция пуста.");
        } else{
            System.out.println("Элементы коллекции в строковом предствлении: ");
            for (City city : collection){
                System.out.println(city.toString());
            }
        }
    }

    public void filterStartsWithName(TreeSet<City> collection, String name){
        System.out.println("Будут выведены элементы коллекции, значение поля name которых начинается с подстроки " + name + ":");
        for (City city : collection){
            if (city.getName().startsWith(name)){
                System.out.println(city);
            }
        }
    }

    public void printDescending(TreeSet<City> collection){
        System.out.println("Элементы коллекции в порядке убывания (обратном): ");
        if (collection.isEmpty()){
            System.out.println("Коллекция пуста.");
        } else {
            Iterator<City> i = collection.descendingIterator();
            while (i.hasNext()){
                System.out.println(i.next());
            }
        }
    }

    public void removeAllByGovernment(TreeSet<City> collection){
        System.out.println("Из коллекции будут удалены все элементы, значение поля government которых соответствует данному.");
        Government government = Government.chooseGovernment();
        collection.removeIf(city -> city.getGovernment().equals(government));
    }

    public void removeById(TreeSet<City> collection, String argument){
        long id = Long.parseLong(argument);
        boolean flag = true;
       for (City city : collection){
           if (city.getId().equals(id)){
               System.out.println(city + " удалён из коллекции.");
               flag = false;
               break;
           }
       }
       if (flag){
           System.out.println("Элемента с данным id не существует.");
       }
    }

    public void removeGreater(TreeSet<City> collection){
        System.out.println("Создайте элемент. Из коллекции будут удалены все элементы, превышающие заданный.");
        City delCity = AddCity.createCity();
        collection.removeIf(city -> delCity.compareTo(city) > 0);
    }

    public void removeLower(TreeSet<City> collection){
        System.out.println("Создайте элемент. Из коллекции будут удалены все элементы, меньшие, чем заданный.");
        City delCity = AddCity.createCity();
        collection.removeIf(city -> delCity.compareTo(city) < 0);
    }


    public void info(TreeSet<City> collection){
        System.out.println("Тип коллекции: " + collection.getClass());
        System.out.println("Дата инициализации коллекции: " + creationDate);
        System.out.println("Количество элементов коллекции: " + collection.size());
    }

    public void updateId(TreeSet<City> collection, String idArgument){
        long id = Long.parseLong(idArgument);
        for (City city : collection){
            if (city.getId() == id){
                System.out.println("Будет произведена замена элемента " + city);
                City newCity = AddCity.createCity();
                newCity.setId(id);
                collection.remove(city); collection.add(newCity);
                System.out.println("Элемент успешно изменен. Его поле id останется прежним.");
            }
        }
    }

}
