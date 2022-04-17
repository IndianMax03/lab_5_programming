package com.github.indianMax03.lab_5_programming.commands;

import com.github.indianMax03.lab_5_programming.base.City;
import com.github.indianMax03.lab_5_programming.patterncommand.Command;
import com.github.indianMax03.lab_5_programming.patterncommand.Invoker;
import com.github.indianMax03.lab_5_programming.patterncommand.Receiver;

import java.util.TreeSet;

public class RemoveGreater implements Command {
    private final Receiver receiver;

    public RemoveGreater(Receiver receiver){
        this.receiver = receiver;
    }

    @Override
    public String execute(Invoker invoker, TreeSet<City> collection, String argument) {
        if (argument.isEmpty()){
            return receiver.removeGreater(collection);
        } else {
            return "Команда remove_greater не принимает аргументы.";
        }
    }

    @Override
    public String getHelp() {
        return "Введите remove_greater {element}, чтобы удалить из коллекции все элементы, превышающие заданный";
    }
}
