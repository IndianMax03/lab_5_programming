package com.github.indianMax03.lab_5_programming.commands;

import com.github.indianMax03.lab_5_programming.base.City;
import com.github.indianMax03.lab_5_programming.patterncommand.Command;
import com.github.indianMax03.lab_5_programming.patterncommand.Invoker;
import com.github.indianMax03.lab_5_programming.patterncommand.Receiver;

import java.util.TreeSet;

public class RemoveAllByGovernment implements Command {

    private final Receiver receiver;

    public RemoveAllByGovernment(Receiver receiver){
        this.receiver = receiver;
    }

    @Override
    public String execute(Invoker invoker, TreeSet<City> collection, String argument) {

        if (argument.isEmpty()) {
            return "Команда remove_all_by_government требует аргумента Government.";
        } else {
            return receiver.removeAllByGovernment(collection, argument);
        }
    }

    @Override
    public String getHelp(){
        return "Введите remove_all_by_government government, чтобы удалить из коллекции все элементы, значение поля" +
                " government которого эквивалентно заданному";
    }
}
