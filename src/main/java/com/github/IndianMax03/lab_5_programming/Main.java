package com.github.indianMax03.lab_5_programming;
// helios ssh sXXXXXX@helios.se.ifmo.ru -p 2222
import com.github.indianMax03.lab_5_programming.base.City;
import com.github.indianMax03.lab_5_programming.commands.*;
import com.github.indianMax03.lab_5_programming.commands.addition.AddCommands;
import com.github.indianMax03.lab_5_programming.commands.patterncommand.*;

import java.util.*;


public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Argument means is where we are reading
        Invoker invoker = new Invoker(); //  Хранилище команд
        TreeSet<City> collection = new TreeSet<>(); //  Main collection
        Receiver receiver = new Receiver(); //  Коробка с командами

        AddCommands.addCommands(invoker, receiver);

        System.out.println("Для вывода справки по командам введите help.");
        String out = "";
        while (true) {
            System.out.print("Введите команду:\n>");
            String[] commandline = sc.nextLine().trim().split(" ");
            String command = commandline[0];
            if (command.isEmpty()){
                System.out.println("Вы серьёзно будете нажимать enter?");
                continue;
            }
            try {
                if (commandline.length == 1) {
                    out = invoker.execute(invoker, command, collection, "");
                    if (out == null) {
                        break;
                    }
                    System.out.println(out);
                } else if (commandline.length == 2) {
                    out = invoker.execute(invoker, command, collection, commandline[1]);
                    System.out.println(out);
                } else {
                    throw new NullPointerException();
                }
            } catch (NullPointerException e){
                out = "Такой команды не существует";
                System.out.println(out);
            }
        }
    }
}
