package com.github.indianMax03.lab_5_programming;
// helios ssh sXXXXXX@helios.se.ifmo.ru -p 2222
import com.github.indianMax03.lab_5_programming.base.City;
import com.github.indianMax03.lab_5_programming.commands.*;
import com.github.indianMax03.lab_5_programming.commands.patterncommand.Command;
import com.github.indianMax03.lab_5_programming.commands.patterncommand.Invoker;
import com.github.indianMax03.lab_5_programming.commands.patterncommand.Receiver;
import java.util.*;


public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Argument means is where we are reading
        Receiver receiver = new Receiver(); //  Коробка с командами
        Invoker invoker = new Invoker(); //  Хранилище команд
        TreeSet<City> collection = new TreeSet<City>();

        Command help = new Help(receiver);
        invoker.register("help", help);
        Command exit = new Exit(receiver);
        invoker.register("exit", exit);
        Command clear = new Clear(receiver);
        invoker.register("clear", clear);
        Command add = new Add(receiver);
        invoker.register("add", add);
        Command show = new Show(receiver);
        invoker.register("show", show);


        System.out.println("Для вывода справки по командам введите help.");
        while (true) {
            System.out.print("Введите команду:\n>");
            String command = sc.nextLine().trim().split("\\s")[0];

            try {
                invoker.execute(command, collection);
            } catch (Exception e) {
                System.out.println("Команда не найдена. Повторите ввод.");
            }

        }
    }
}
