package com.github.indianMax03.lab_5_programming.commands;
import com.github.indianMax03.lab_5_programming.base.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Scanner;
import java.util.TreeSet;

public class Add {

    public static City call (Human[] leaders) {

        long cID = (long) (Math.random() * 10000 + 1);

        Scanner sc = new Scanner(System.in);

        System.out.print("\nВведите название города: ");
        String cname = sc.next();
        System.out.println("Результат: " + cname + "\n");

        System.out.println("Введите координаты x и y:");
        System.out.print("x = ");
        Double cx = sc.nextDouble();
        System.out.print("y = ");
        Double cy = sc.nextDouble();
        Coordinates cxy = new Coordinates(cx, cy);
        System.out.println("Результат: " + cxy);

        System.out.println("\nЗадайте время создания:");
        System.out.print("Год: ");
        int cyear = sc.nextInt();
        System.out.print("Месяц: ");
        int cmonth = sc.nextInt();
        System.out.print("Число: ");
        int cday = sc.nextInt();
        System.out.print("Час: ");
        int chour = sc.nextInt();
        System.out.print("Минута: ");
        int cminute = sc.nextInt();
        System.out.print("Зона: пока что автоматом МСК\n");
        ZoneId czone = ZoneId.of("Europe/Moscow");
        LocalDate cdate = LocalDate.of(cyear, cmonth, cday);
        LocalTime ctime = LocalTime.of(chour, cminute);
        ZonedDateTime ccreationdate = ZonedDateTime.of(cdate, ctime, czone);
        System.out.println("Результат: " + ccreationdate);

        System.out.print("\nВведите площадь города: ");
        float carea = sc.nextFloat();
        System.out.println("Результат: \nS =  " + carea);

        System.out.print("\nВведите население: ");
        int cpopulation = sc.nextInt();
        System.out.println("Результат: \nN = " + cpopulation);

        System.out.print("\nВведите высоту над уровнем моря: ");
        float cmetersabovesealvl = sc.nextFloat();
        System.out.println("Результат: \nH =  " + cmetersabovesealvl);

        System.out.println("\nВыберите климат: ");
        System.out.println("1) " + Climate.TUNDRA);
        System.out.println("2) " + Climate.HUMIDCONTINENTAL);
        System.out.println("3) " + Climate.SUBARCTIC);
        int cclimatenum = sc.nextInt();
        Climate cclimate = Climate.TUNDRA;
        //if (cclimatenum == 1) {  cclimate = Climate.TUNDRA; }
        //else
        if (cclimatenum == 2) {
            cclimate = Climate.HUMIDCONTINENTAL;
        } else if (cclimatenum == 3) {
            cclimate = Climate.SUBARCTIC;
        }
        System.out.println("Выбранный климат: " + cclimate);

        System.out.println("\nВыберите тип правления: ");
        System.out.println("1) " + Government.THEOCRACY);
        System.out.println("2) " + Government.ANARCHY);
        System.out.println("3) " + Government.DICTATORSHIP);
        System.out.println("4) " + Government.THALASSOCRACY);
        int cgovernmentnum = sc.nextInt();
        Government cgovernment = Government.THEOCRACY;
        //if (cgovernmentnum == 1) {  cgovernment = Government.THEOCRACY; }
        //else
        if (cgovernmentnum == 2) {
            cgovernment = Government.ANARCHY;
        } else if (cgovernmentnum == 3) {
            cgovernment = Government.DICTATORSHIP;
        } else if (cgovernmentnum == 4) {
            cgovernment = Government.THALASSOCRACY;
        }
        System.out.println("Выбранный тип: " + cgovernment);

        System.out.println("\nВыберите уровень жизни: ");
        System.out.println("1) " + StandardOfLiving.HIGH);
        System.out.println("2) " + StandardOfLiving.ULTRA_HIGH);
        System.out.println("3) " + StandardOfLiving.ULTRA_LOW);
        int cstandartnum = sc.nextInt();
        StandardOfLiving cstandart = StandardOfLiving.HIGH;
        //if (cstandartnum == 1) {  cclimate = Climate.TUNDRA; }
        //else
        if (cstandartnum == 2) {
            cstandart = StandardOfLiving.ULTRA_HIGH;
        } else if (cstandartnum == 3) {
            cstandart = StandardOfLiving.ULTRA_LOW;
        }
        System.out.println("Выбранный уровень: " + cstandart);

        System.out.println("\nВыберите правителя города: ");
        for (int i = 0; i < leaders.length; ++i) {
            System.out.println(i + 1 + ") " + leaders[i].getName());
        }
        int cgovernornum = sc.nextInt();
        Human cgovernor = leaders[cgovernornum - 1];
        System.out.println("Выбранный правитель: " + cgovernor.getName());

        return new City(cID, cname, cxy, ccreationdate, carea, cpopulation, cmetersabovesealvl, cclimate, cgovernment,
                cstandart, cgovernor);
    }

    public static City create (Human[] leaders, String name, Double x, Double y, int year, int month, int day, int hour,
                               int minute, float area, int population, float meterssea, String climate, String government,
                               String standart, String governor) {

        long cID = (long) (Math.random() * 10000 + 1);

        Coordinates xy = new Coordinates(x, y);

        ZoneId zone = ZoneId.of("Europe/Moscow");
        LocalDate date = LocalDate.of(year, month, day);
        LocalTime time = LocalTime.of(hour, minute);
        ZonedDateTime creationdate = ZonedDateTime.of(date, time, zone);

        Climate crclimate = Climate.HUMIDCONTINENTAL;
        if (climate.equals(Climate.SUBARCTIC.toString())){
            crclimate = Climate.SUBARCTIC;
        } else if (climate.equals(Climate.TUNDRA.toString())){
            crclimate = Climate.TUNDRA;
        }

        Government crgovernment = Government.THEOCRACY;
        if (government.equals(Government.ANARCHY.toString())) {
            crgovernment = Government.ANARCHY;
        } else if (government.equals(Government.DICTATORSHIP.toString())) {
            crgovernment = Government.DICTATORSHIP;
        } else if (government.equals(Government.THALASSOCRACY.toString())) {
            crgovernment = Government.THALASSOCRACY;
        }

        StandardOfLiving crstandart = StandardOfLiving.HIGH;
        if (standart.equals(StandardOfLiving.ULTRA_HIGH.toString())) {
            crstandart = StandardOfLiving.ULTRA_HIGH;
        } else if (standart.equals(StandardOfLiving.ULTRA_LOW.toString())) {
            crstandart = StandardOfLiving.ULTRA_LOW;
        }

        Human crgovernor = null;

        for (Human leader : leaders){
            if (governor.equals(leader.toString())){
                crgovernor = leader;
            }
        }

        return new City(cID, name, xy, creationdate, area, population, meterssea, crclimate, crgovernment, crstandart,
                crgovernor);
    }
}
