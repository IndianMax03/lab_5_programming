package com.github.indianMax03.lab_5_programming.addition;

import com.github.indianMax03.lab_5_programming.base.Coordinates;

import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Scanner;

public class InputTester {

    private Scanner sc = new Scanner(System.in);

    protected Long checkIdValid(String input){
        long id;
        try {
            id = Long.parseLong(input);
        } catch (NumberFormatException e){
            return null;
        }
        return id;
    }

    protected ZonedDateTime checkDataValid(String input){
        ZonedDateTime dateTime;
        try {
            dateTime = ZonedDateTime.parse(input);
        } catch (Exception e){
            return null;
        }
        return dateTime;
    }

    protected String nameInput() {
        System.out.println("Введите имя города: ");
        String name = null;

        while (name == null){
            name = sc.nextLine();
            if (name.isEmpty()) {
                System.out.println("Имя не может быть пустой строкой!");
            }
            name = checkNameValid(name);
        }

        return name;
    }

    protected String checkNameValid(String name){
        if (name.isEmpty()){
            return null;
        } else {
            return name;
        }
    }

    protected Coordinates coordinatesInput(){
        Coordinates xy = null;
        System.out.println("Введите координаты x и y через точку с запятой: ");
        do {
            String input = sc.nextLine();
            xy = checkXYValid(input);
            if (xy == null){
                System.out.println("Координат должно быть две. Обе координаты должны быть типа Double. Координата y должна превышать -628.");
            }
        } while (xy == null);

        return xy;
    }

    protected Coordinates checkXYValid(String input){
        String[] coordinates = input.trim().split(";");
        if (coordinates.length != 2){
            return null;
        }
        System.out.println(Arrays.toString(coordinates));
        String xstring = coordinates[0];
        String ystring = coordinates[1];
        double x, y;
        try {
            x = Double.parseDouble(xstring);
            y = Double.parseDouble(ystring);
            if (y <= -628){
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e){
            return null;
        }
        return new Coordinates(x, y);
    }

    protected Float areaInput(){
        Float area = null;
        System.out.println("Введите площадь города: ");
        do {
            String input = sc.nextLine();
            area = checkAreaValid(input);
            if (area == null){
                System.out.println("Площадь города должна быть типа Float, её значение должно быть больше, чем 0.");
            }
        } while (area == null);

        return area;
    }

    protected Float checkAreaValid(String areaString){
        float area;
        try{
            area = Float.parseFloat(areaString);
            if (area <= 0){
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e){
            return null;
        }

        return area;
    }

    protected int populationInput(){
        Integer population;
        System.out.println("Введите население города: ");
        do {
            String input = sc.nextLine();
            population = checkPopulationValid(input);
            if (population == null){
                System.out.println("Население города должно быть типа Integer. Значение не должно быть меньше 0.");
            }
        } while (population == null);

        return population;
    }

    protected Integer checkPopulationValid(String input){
        int population;
        try{
            population = Integer.parseInt(input);
            if (population <= 0){
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e){
            return null;
        }
        return population;
    }

    protected float metersAboveSeaLevelInput(){
        Float masl;
        System.out.println("Введите высоту над уровнем моря: ");
        do {
            String input = sc.nextLine();
            masl = checkMASLValid(input);
            if (masl == null){
                System.out.println("Высота над уровнем моря должна быть типа Float.");
            }

        } while (masl == null);

        return masl;
    }

    protected Float checkMASLValid(String input){
        float masl;

        try{
            masl = Float.parseFloat(input);
        } catch (NumberFormatException e){
            return null;
        }
        return masl;
    }

}
