package com.lab_5_programming.commands;

import com.lab_5_programming.patterncommand.Command;
import com.lab_5_programming.patterncommand.Invoker;
import com.lab_5_programming.patterncommand.Receiver;
import com.lab_5_programming.base.City;

import java.util.TreeSet;

public class RemoveLower implements Command {
    private final Receiver receiver;

    public RemoveLower(Receiver receiver){
        this.receiver = receiver;
    }

    @Override
    public String execute(Invoker invoker, TreeSet<City> collection, String argument) {
        if (argument.isEmpty()) {
            return receiver.removeLower(collection);
        } else {
            return "Команда remove_lower не принимает аргументы.";
        }
    }

    @Override
    public String getHelp(){
        return "Введите remove_lower {element}, чтобы удалить из коллекции все элементы, меньшие, чем заданный";
    }
}
