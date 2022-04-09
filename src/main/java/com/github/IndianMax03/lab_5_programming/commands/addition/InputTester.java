package com.github.indianMax03.lab_5_programming.commands.addition;

import com.github.indianMax03.lab_5_programming.base.Coordinates;

import java.util.Scanner;

public class InputTester {

    private final Scanner sc = new Scanner(System.in);

    protected String nameInput() {
        System.out.println("Введите имя города: ");
        String name = "";
        while (name.isEmpty()) {
            name = sc.nextLine();
            if (name.isEmpty()) {
                System.out.println("Имя не может быть пустой строкой! Повторите ввод.");
            }
        }
        return name;
    }

    protected Coordinates coordinatesInput(){
        Double x, y;
        do {
            System.out.println("Введите координату x: ");
            String input = sc.nextLine();
            try {
                x = Double.parseDouble(input);
            } catch (NumberFormatException e){
                System.out.println("Координата должна быть типа Double.");
                x = null;
            }
        } while (x == null);

        do {
            System.out.println("Введите координату y: ");
            String input = sc.nextLine();
            try {
                y = Double.parseDouble(input);
                if (y <= -628){
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e){
                System.out.println("Координата должна быть типа Double, её значение должно быть больше -628.");
                y = null;
            }
        } while (y == null);

        return new Coordinates(x, y);
    }

    protected Float areaInput(){
        Float area;
        do {
            System.out.println("Введите площадь города: ");
            String input = sc.nextLine();
            try{
                area = Float.parseFloat(input);
                if (area <= 0){
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e){
                System.out.println("Площадь должна быть типа Float, её значение должно быть больше 0.");
                area = null;
            }
        } while (area == null);

        return area;
    }

    protected int populationInput(){
        Integer population;
        do {
            System.out.println("Введите население города: ");
            String input = sc.nextLine();
            try{
                population = Integer.parseInt(input);
                if (population <= 0){
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e){
                System.out.println("Население должно быть типа Integer, его значение должно быть больше 0.");
                population = null;
            }
        } while (population == null);

        return population;
    }

    protected float metersAboveSeaLevelInput(){
        Float masl;
        do {
            System.out.println("Введите высоту над уровнем моря: ");
            String input = sc.nextLine();
            try{
                masl = Float.parseFloat(input);
            } catch (NumberFormatException e){
                System.out.println("Высота над уровнем моря должна быть типа Float.");
                masl = null;
            }
        } while (masl == null);

        return masl;
    }
}
