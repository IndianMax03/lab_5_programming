package com.github.indianMax03.lab_5_programming;
// helios ssh sXXXXXX@helios.se.ifmo.ru -p 2222
import com.github.indianMax03.lab_5_programming.base.City;
import com.github.indianMax03.lab_5_programming.commands.*;
import com.github.indianMax03.lab_5_programming.commands.patterncommand.*;

import java.util.*;


public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Argument means is where we are reading
        Invoker invoker = new Invoker(); //  Хранилище команд
        TreeSet<City> collection = new TreeSet<>(); //  Main collection
        Receiver receiver = new Receiver(); //  Коробка с командами

        Command add = new Add(receiver);
        invoker.register("add", add);
        Command addIfMin = new AddIfMin(receiver);
        invoker.register("add_if_min", addIfMin);
        Command exit = new Exit(receiver);
        invoker.register("exit", exit);
        Command clear = new Clear(receiver);
        invoker.register("clear", clear);
        Command show = new Show(receiver);
        invoker.register("show", show);
        Command filterStartsWithName = new FilterStartsWithName(receiver);
        invoker.register("filter_starts_with_name", filterStartsWithName);
        Command printDescending = new PrintDescending(receiver);
        invoker.register("print_descending", printDescending);
        Command removeAllByGovernment = new RemoveAllByGovernment(receiver);
        invoker.register("remove_all_by_government", removeAllByGovernment);
        Command removeById = new RemoveByID(receiver);
        invoker.register("remove_by_id", removeById);
        Command removeGreater = new RemoveGreater(receiver);
        invoker.register("remove_greater", removeGreater);
        Command removeLower = new RemoveLower(receiver);
        invoker.register("remove_greater", removeLower);
        Command info = new Info(receiver);
        invoker.register("info", info);
        Command updateId = new UpdateId(receiver);
        invoker.register("update", updateId);
        Command help = new Help(receiver);
        invoker.register("help", help);



        System.out.println("Для вывода справки по командам введите help.");
        String out = "";
        while (true) {
            System.out.print("Введите команду:\n>");
            String[] commandline = sc.nextLine().trim().split(" ");
            String command = commandline[0];
            if (command.isEmpty()){
                continue;
            }
            if (commandline.length == 1){
                out = invoker.execute(invoker, command, collection, "");
                if (out == null){
                    break;
                }
                System.out.println(out);
            } else if (commandline.length == 2){
                out = invoker.execute(invoker, command,collection, commandline[1]);
                System.out.println(out);
            } else {
                out = "Команды не существует";
                System.out.println(out);
            }
        }
    }
}
