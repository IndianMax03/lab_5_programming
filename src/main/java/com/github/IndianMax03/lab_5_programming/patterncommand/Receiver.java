package com.github.indianMax03.lab_5_programming.patterncommand;

import com.github.indianMax03.lab_5_programming.base.City;
import com.github.indianMax03.lab_5_programming.base.Government;
import com.github.indianMax03.lab_5_programming.addition.AddCity;
import com.github.indianMax03.lab_5_programming.addition.WorkWithFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.ZonedDateTime;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class Receiver {

    private final ZonedDateTime creationDate;


    public Receiver(){
        creationDate = ZonedDateTime.now();
    }

    public String help(Invoker invoker){
        StringBuilder commandsString = new StringBuilder();
        for (Command command : invoker.getCommandMap().values()){
            commandsString.append(command.getHelp()).append("\n");
        }
        return commandsString.toString();
    }

    public String exit(){
        System.out.println("Спасибо за работу, до свидания!");
        return null;
    }

    public String clear(TreeSet<City> collection){
        collection.clear();
        return "Коллекция успешно очищена.";
    }

    public String add(TreeSet<City> collection){
            return AddCity.addCity(collection);
    }

    public String addIfMin(TreeSet<City> collection){
        System.out.println("Следующий введённый город будет добавлен в колекцию в случае, если его поле population будет " +
                "наименьшим в коллекции.");
        System.out.println("На данный момент в коллекции наименьшее значение поля population = " + collection.first().getPopulation());
        return AddCity.addCityIfMin(collection);
    }

    public String show(TreeSet<City> collection){
        if (collection.isEmpty()) {
            return "Коллекция пуста.";
        } else {
            System.out.println("Элементы коллекции в строковом предствлении: ");
            return collection.toString();
        }
    }

    public String filterStartsWithName(TreeSet<City> collection, String name){
        System.out.println("Будут выведены элементы коллекции, значение поля name которых начинается с подстроки " + name + ":");
        StringBuilder namesString = new StringBuilder();
        for (City city : collection){
            if (city.getName().startsWith(name)){
                namesString.append(city).append(", ");
            }
        }
        if (namesString.toString().isEmpty()){
            return "Элементов с таким условием в коллекции не найдено!";
        } else {
            return namesString.deleteCharAt(namesString.length() - 2).toString();
        }
    }

    public String printDescending(TreeSet<City> collection){
        System.out.println("Элементы коллекции в порядке убывания (обратном): ");
        if (collection.isEmpty()){
            return "Коллекция пуста.";
        } else {
            StringBuilder descCollection = new StringBuilder();
            Iterator<City> i = collection.descendingIterator();
            while (i.hasNext()){
                descCollection.append(i.next()).append(", ");
            }
            return descCollection.deleteCharAt(descCollection.length() - 2).toString();
        }
    }

    public String executeScript(Invoker invoker, TreeSet<City> collection){
        File file = new File("Script.txt");

        Scanner scanner;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            return "Доступ к файлу не получен.";
        }

        String out = "";
        int i = 1;

        while (scanner.hasNextLine()) {
            String command = scanner.nextLine();
            if (invoker.getCommandMap().containsKey(command)){
                System.out.println(invoker.execute(invoker, command, collection, ""));
                i++;
            } else {
                return "Команды в строке " + i + " не существует. Выполнение файла остановлено.";
            }
        }
        return "\nФайл выполнен успешно.";
    }

    public String removeAllByGovernment(TreeSet<City> collection){
        System.out.println("Из коллекции будут удалены все элементы, значение поля government которых соответствует данному.");
        Government government = Government.chooseGovernment();
        collection.removeIf(city -> city.getGovernment().equals(government));
        return "Из коллекции удалены элементы с заданным условием";
    }

    public String removeById(TreeSet<City> collection, String argument){
        Long id;
        try {
            id = Long.parseLong(argument);
        } catch (NumberFormatException e){
            id = null;
        }
        if (id == null){
            return "Аргумент id передан неверно.";
        }
        String element = "Элемента с данным id не существует.";
       for (City city : collection){
           if (city.getId().equals(id)){
               element = city + " удалён из коллекции.";
               break;
           }
       }
       return element;
    }

    public String removeGreater(TreeSet<City> collection){
        System.out.println("Создайте элемент. Из коллекции будут удалены все элементы, превышающие заданный.");
        City delCity = AddCity.createCity();
        collection.removeIf(city -> delCity.compareTo(city) > 0);
        return "Из коллекции удалены элементы с заданным условием";
    }

    public String removeLower(TreeSet<City> collection){
        System.out.println("Создайте элемент. Из коллекции будут удалены все элементы, меньшие, чем заданный.");
        City delCity = AddCity.createCity();
        collection.removeIf(city -> delCity.compareTo(city) < 0);
        return "Из коллекции удалены элементы с заданным условием";
    }


    public String info(TreeSet<City> collection){
        return "Тип коллекции: " + collection.getClass() +
                "\nДата инициализации коллекции: " + creationDate +
                "\nКоличество элементов коллекции: " + collection.size();
    }

    public String updateId(TreeSet<City> collection, String idArgument){
        Long id;
        try {
            id = Long.parseLong(idArgument);
        } catch (NumberFormatException e){
            id = null;
        }
        if (id == null){
            return "Аргумент id передан неверно.";
        }
        String result = "Элемента с данным id не существует.";
        for (City city : collection){
            if (city.getId().equals(id)){
                System.out.println("Будет произведена замена элемента " + city);
                City newCity = AddCity.createCity();
                newCity.setId(id);
                collection.remove(city); collection.add(newCity);
                result = "Элемент успешно изменен. Его поле id останется прежним.";
            }
        }
        return result;
    }

    public String save(TreeSet<City> collection){
        WorkWithFile worker = new WorkWithFile();
        return worker.writeInFile(collection);
    }

}
