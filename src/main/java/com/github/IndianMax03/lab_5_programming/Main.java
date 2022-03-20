package com.github.indianMax03.lab_5_programming;
// helios ssh s333057@helios.se.ifmo.ru -p 2222
import com.github.indianMax03.lab_5_programming.base.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.TreeSet;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Argument means is where we are reading
        TreeSet<City> cities = new TreeSet<>();

        // ZonedDataTime
        LocalDate date  = LocalDate.of(2003,11, 21);
        LocalTime time = LocalTime.of(12, 30);
        ZoneId zone = ZoneId.of("Europe/Moscow");
        ZonedDateTime zoned = ZonedDateTime.of(date, time, zone);
        // ZonedDataTime

        Human MaxKing = new Human("Максим", 5, zoned);
        City MaxCity = new City(123456L, "Moscow", new Coordinates(1.1, 1.6), ZonedDateTime.now(),
                11.22f, 666, 52.11f, Climate.TUNDRA, Government.THEOCRACY,
                StandardOfLiving.HIGH, MaxKing);
        System.out.println(MaxKing.getBirthday());
        cities.add(MaxCity);
        System.out.println(cities);


        // Welcome
        System.out.println("Добро пожаловать в авторское консольное приложение \"Городки\".\n" +
                "Автор, релизатор, аналитик и генератор идей - Тучков Максим Русланович, группа P3113.\n");
        System.out.println("Для продолжения работы с приложением введите любую цифру. Для выхода из приложения" +
                " нажмите 0.");
        int a = sc.nextInt(); // Scanner
        if (a == 0) {
            System.out.println("Я думал, мы с вами побудем чуть дольше, но ладно, до свидания!");
            System.exit(0);
        }
        // Welcome

        System.out.println("Введите цифру: \n1. Я знаком, с концепцией приложения и готов приступить к работе \n" +
                "2. Я не знаком с концепцией приложения и хочу узнать о том, что мне предстоит делать");
        a = sc.nextInt(); // Scanner
        if (a == 2){
            System.out.println("Данное приложение создано для управления коллекцией объектов в интерактивном" +
                    " режиме при помощи консольных команд. \nПриступим к работе!\n");
        }
        else if (a == 1){
            System.out.println("Отлично! Приступим к работе");
        }

        System.out.println("Для получения справки по командам введите help");

        String cmd;

        do {
            System.out.println("Введите команду:");
            cmd = sc.next();
            switch (cmd){
                case("help"):
                    System.out.println("Справка");
                    break;
                case ("stop"):
                    System.out.println("Спасибо за работу, до свидания!");
                    break;
                default:
                    break;
            }
        } while (!cmd.equals("stop"));

        // sc.close();
    }
}
