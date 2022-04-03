package com.github.indianMax03.lab_5_programming;
// helios ssh s333057@helios.se.ifmo.ru -p 2222
import com.github.indianMax03.lab_5_programming.base.*;
import com.github.indianMax03.lab_5_programming.commands.*;
import com.github.indianMax03.lab_5_programming.commands.addition.HumanFactory;
import com.github.indianMax03.lab_5_programming.commands.addition.RandomDate;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class Main {
    //  Main collection
    public static TreeSet<City> cities = new TreeSet<>();
    //  Main collection
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, FileNotFoundException {

        Scanner sc = new Scanner(System.in); // Argument means is where we are reading

        //  Welcome
        System.out.println("Добро пожаловать в авторское консольное приложение \"Городки\".\n" +
                "Автор, релизатор, аналитик и генератор идей - Тучков Максим Русланович, группа P3113.\n");
        System.out.println("Для продолжения работы с приложением введите любую цифру. Для выхода из приложения" +
                " нажмите 0.");
        //  Welcome

        System.out.print(">");
        int a = sc.nextInt(); // Scanner
        if (a == 0) {
            System.out.println("Я думал, мы с вами побудем чуть дольше, но ладно, до свидания!");
            System.exit(0);
        }

        System.out.println("Введите цифру: \n1. Я знаком, с концепцией приложения и готов приступить к работе \n" +
                "2. Я не знаком с концепцией приложения и хочу узнать о том, что мне предстоит делать");
        System.out.print(">");
        a = sc.nextInt(); // Scanner
        if (a == 2){
            System.out.println("Данное приложение создано для управления коллекцией объектов в интерактивном" +
                    " режиме при помощи консольных команд. \nПриступим к работе!\n");
        }
        else if (a == 1){
            System.out.println("Отлично! Приступим к работе");
        }

        System.out.println("Для получения справки по командам введите help");


        // sc.close();
    }
}
