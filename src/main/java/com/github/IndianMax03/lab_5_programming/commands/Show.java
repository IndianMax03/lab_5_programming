package com.github.indianMax03.lab_5_programming.commands;

import com.github.indianMax03.lab_5_programming.base.City;
import com.github.indianMax03.lab_5_programming.commands.patterncommand.Command;
import com.github.indianMax03.lab_5_programming.commands.patterncommand.Invoker;
import com.github.indianMax03.lab_5_programming.commands.patterncommand.Receiver;

import java.util.TreeSet;

public class Show implements Command {

    private final Receiver receiver;

    public Show(Receiver receiver){
        this.receiver = receiver;
    }

    @Override
    public String execute(Invoker invoker, TreeSet<City> collection, String argument) {
        if (argument.isEmpty()) {
            return receiver.show(collection);
        } else {
            return "Команда show не принимает аргументы.";
        }
    }

    @Override
    public String getHelp(){
        return "Введите show, чтобы вывести в стандартный поток вывода все элементы коллекции в строковом представлении";
    }

}
