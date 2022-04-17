package com.github.indianMax03.lab_5_programming.commands;

import com.github.indianMax03.lab_5_programming.base.City;
import com.github.indianMax03.lab_5_programming.patterncommand.Command;
import com.github.indianMax03.lab_5_programming.patterncommand.Invoker;
import com.github.indianMax03.lab_5_programming.patterncommand.Receiver;

import java.util.TreeSet;

public class AddIfMin implements Command {
    private final Receiver receiver;

    public AddIfMin(Receiver receiver){
        this.receiver = receiver;
    }

    @Override
    public String execute(Invoker invoker, TreeSet<City> collection, String argument) {
        if (argument.isEmpty()) {
            return receiver.addIfMin(collection);
        } else {
            return "Команда add_if_min не принимает аргументы.";
        }
    }

    public String getHelp(){
        return "Введите add_if_min {element}, чтобы добавить новый элемент в коллекцию, если его значение меньше, чем у" +
                " наименьшего элемента этой коллекции";
    }

}
