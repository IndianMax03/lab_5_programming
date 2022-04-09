package com.github.indianMax03.lab_5_programming.commands;

import com.github.indianMax03.lab_5_programming.base.City;
import com.github.indianMax03.lab_5_programming.commands.patterncommand.Command;
import com.github.indianMax03.lab_5_programming.commands.patterncommand.Invoker;
import com.github.indianMax03.lab_5_programming.commands.patterncommand.Receiver;

import java.util.TreeSet;

public class PrintDescending implements Command {

    private final Receiver receiver;

    public PrintDescending(Receiver receiver){
        this.receiver = receiver;
    }

    @Override
    public String execute(Invoker invoker, TreeSet<City> collection, String argument) {
        if (argument.isEmpty()) {
            return receiver.printDescending(collection);
        } else {
            return "Команда print_descending не принимает аргументы.";
        }
    }

    @Override
    public String getHelp(){
        return "Введите print_descending, чтобы вывести элементы коллекции в порядке убывания";
    }

}
