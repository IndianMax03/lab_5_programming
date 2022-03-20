package com.github.indianMax03.lab_5_programming;
// helios ssh s333057@helios.se.ifmo.ru -p 2222
import com.github.indianMax03.lab_5_programming.base.*;
import com.github.indianMax03.lab_5_programming.commands.Add;

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


        //World Leaders
        LocalDate putdate  = LocalDate.of(1952,10, 7);
        LocalTime puttime = LocalTime.of(7, 20);
        ZoneId putzone = ZoneId.of("Europe/Moscow");
        ZonedDateTime putzoned = ZonedDateTime.of(putdate, puttime, putzone);
        Human Putin = new Human("Владимир Владимирович Путин", 170, putzoned);

        LocalDate lukdate  = LocalDate.of(1954,8, 30);
        LocalTime luktime = LocalTime.of(12, 40);
        ZoneId lukzone = ZoneId.of("EET");
        ZonedDateTime lukzoned = ZonedDateTime.of(lukdate, luktime, lukzone);
        Human Lukashenko = new Human("Александр Григорьевич Лукашенко", 182, lukzoned);

        LocalDate angdate  = LocalDate.of(1954,7, 17);
        LocalTime angtime = LocalTime.of(12, 40);
        ZoneId angzone = ZoneId.of("EET");
        ZonedDateTime angzoned = ZonedDateTime.of(angdate, angtime, angzone);
        Human Angela = new Human("Ангела Доротея Меркель", 165, angzoned);

        LocalDate kimdate  = LocalDate.of(1984,1, 8);
        LocalTime kimtime = LocalTime.of(3, 13);
        ZoneId kimzone = ZoneId.of("Asia/Seoul");
        ZonedDateTime kimzoned = ZonedDateTime.of(kimdate, kimtime, kimzone);
        Human KimChenIn = new Human("Ким Чен Ын", 170, kimzoned);

        LocalDate josdate  = LocalDate.of(1942,11, 20);
        LocalTime jostime = LocalTime.of(6, 52);
        ZoneId joszone = ZoneId.of("America/New_York");
        ZonedDateTime joszoned = ZonedDateTime.of(josdate, jostime, joszone);
        Human Joseph = new Human("Джозеф Робинетт Байден", 182, joszoned);

        LocalDate bardate  = LocalDate.of(1961,8, 4);
        LocalTime bartime = LocalTime.of(7, 16);
        ZoneId barzone = ZoneId.of("America/New_York");
        ZonedDateTime barzoned = ZonedDateTime.of(bardate, bartime, barzone);
        Human Barak = new Human("Барак Хуссейн Обама", 187, barzoned);

        LocalDate gandate  = LocalDate.of(1869,10, 2);
        LocalTime gantime = LocalTime.of(10, 39);
        ZoneId ganzone = ZoneId.of("Asia/Calcutta");
        ZonedDateTime ganzoned = ZonedDateTime.of(gandate, gantime, ganzone);
        Human Gandi = new Human("Мохандас Карамчанд Ганди", 165, ganzoned);

        LocalDate makdate  = LocalDate.of(1977,12, 21);
        LocalTime maktime = LocalTime.of(19, 21);
        ZoneId makzone = ZoneId.of("Europe/Paris");
        ZonedDateTime makzoned = ZonedDateTime.of(makdate, maktime, makzone);
        Human Macron = new Human("Эманнюэль Жан-Мишель Фредерик Макрон",  179, makzoned);
        //World Leaders

        final Human[] leaders = {Putin, Lukashenko, Angela, KimChenIn, Joseph, Barak, Gandi, Macron};

        City MaxCity = new City(123456L, "Moscow", new Coordinates(1.1, 1.6), ZonedDateTime.now(),
                11.22f, 666, 52.11f, Climate.TUNDRA, Government.THEOCRACY,
                StandardOfLiving.HIGH, Putin);


        // Welcome
        System.out.println("Добро пожаловать в авторское консольное приложение \"Городки\".\n" +
                "Автор, релизатор, аналитик и генератор идей - Тучков Максим Русланович, группа P3113.\n");
        System.out.println("Для продолжения работы с приложением введите любую цифру. Для выхода из приложения" +
                " нажмите 0.");

        // Welcome

        int a = sc.nextInt(); // Scanner
        if (a == 0) {
            System.out.println("Я думал, мы с вами побудем чуть дольше, но ладно, до свидания!");
            System.exit(0);
        }

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
                    System.out.println("Введите Add, если хотите создать новый элемент коллекции");
                    break;
                case ("add"):
                    City ccity = Add.call(leaders);
                    cities.add(ccity);
                    System.out.println("\nЭлемент успешно добавлен!");
                    System.out.println("Вывожу коллекцию: " + cities);





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
