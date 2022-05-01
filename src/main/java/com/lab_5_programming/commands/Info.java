package com.lab_5_programming.commands;
import com.lab_5_programming.patterncommand.Command;
import com.lab_5_programming.patterncommand.Invoker;
import com.lab_5_programming.patterncommand.Receiver;
import com.lab_5_programming.base.City;

import java.util.TreeSet;

public class Info implements Command {
    private final Receiver receiver;

    public Info(Receiver receiver){
        this.receiver = receiver;
    }

    @Override
    public String execute(Invoker invoker, TreeSet<City> collection, String argument) {
        if (argument.isEmpty()) {
            return receiver.info(collection);
        } else {
            return "Команда info не принимает аргументы.";
        }

    }

    @Override
    public String getHelp(){
        return "Введите info, чтобы вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации," +
                " количество элементов)";
    }
}
