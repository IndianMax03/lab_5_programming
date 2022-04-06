package com.github.indianMax03.lab_5_programming;
// helios ssh sXXXXXX@helios.se.ifmo.ru -p 2222
import com.github.indianMax03.lab_5_programming.base.City;
import com.github.indianMax03.lab_5_programming.commands.*;
import com.github.indianMax03.lab_5_programming.commands.patterncommand.Command;
import com.github.indianMax03.lab_5_programming.commands.patterncommand.CommandWithArgument;
import com.github.indianMax03.lab_5_programming.commands.patterncommand.Invoker;
import com.github.indianMax03.lab_5_programming.commands.patterncommand.Receiver;

import java.time.ZonedDateTime;
import java.util.*;


public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Argument means is where we are reading
        Invoker invoker = new Invoker(); //  Хранилище команд
        TreeSet<City> collection = new TreeSet<City>(); //  Main collection
        Receiver receiver = new Receiver(); //  Коробка с командами

        Command help = new Help(receiver);
        invoker.register("help", help);
        Command exit = new Exit(receiver);
        invoker.register("exit", exit);
        Command clear = receiver::clear;
        invoker.register("clear", clear);
        Command add = receiver::add;
        invoker.register("add", add);
        Command show = receiver::show;
        invoker.register("show", show);
        Command addIfMin = receiver::addIfMin;
        invoker.register("add_if_min", addIfMin);
        CommandWithArgument filterStartsWithName = receiver::filterStartsWithName;
        invoker.registerWithArg("filter_starts_with_name", filterStartsWithName);
        Command printDescending = receiver::printDescending;
        invoker.register("print_descending", printDescending);
        Command removeAllByGovernment = receiver::removeAllByGovernment;
        invoker.register("remove_all_by_government", removeAllByGovernment);
        CommandWithArgument removeById = receiver::removeById;
        invoker.registerWithArg("remove_by_id", removeById);
        Command removeGreater = receiver::removeGreater;
        invoker.register("remove_greater", removeGreater);
        Command removeLower = receiver::removeLower;
        invoker.register("remove_greater", removeLower);
        Command info = receiver::info;
        invoker.register("info", info);


        System.out.println("Для вывода справки по командам введите help.");
        while (true) {
            System.out.print("Введите команду:\n>");
            String[] commandline = sc.nextLine().trim().split(" ");
            if (commandline.length == 1) {
                String command = commandline[0];
                try {
                    invoker.execute(command, collection);
                } catch (Exception e) {
                    System.out.println("Команда не найдена. Повторите ввод.");
                }
            } else if (commandline.length == 2){
                String command  = commandline[0];
                String argument = commandline[1];
                try {
                    invoker.executeWithArg(command, collection, argument);
                } catch (Exception e){
                    System.out.println("Команда не найдена. Повторите ввод.");
                }
            } else {
                System.out.println("Команда не найдена. Повторите ввод.");
            }
        }
    }
}
