package com.github.indianMax03.lab_5_programming.commands;

import com.github.indianMax03.lab_5_programming.base.City;
import com.github.indianMax03.lab_5_programming.commands.patterncommand.Command;
import com.github.indianMax03.lab_5_programming.commands.patterncommand.Invoker;
import com.github.indianMax03.lab_5_programming.commands.patterncommand.Receiver;

import java.util.TreeSet;

public class RemoveAllByGovernment implements Command {
    private final Receiver receiver;

    public RemoveAllByGovernment(Receiver receiver){
        this.receiver = receiver;
    }

    @Override
    public String execute(Invoker invoker, TreeSet<City> collection, String argument) {
        if (argument.isEmpty()) {
            return receiver.removeAllByGovernment(collection);
        } else {
            return "Команда remove_all_by_government не принимает аргументы.";
        }
    }

    @Override
    public String getHelp(){
        return "Введите remove_all_by_government government, чтобы удалить из коллекции все элементы, значение поля" +
                " government которого эквивалентно заданному";
    }
}
