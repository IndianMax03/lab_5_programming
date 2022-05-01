package com.lab_5_programming.commands;

import com.lab_5_programming.base.City;
import com.lab_5_programming.patterncommand.Command;
import com.lab_5_programming.patterncommand.Invoker;
import com.lab_5_programming.patterncommand.Receiver;

import java.util.TreeSet;

public class RemoveByID implements Command {
    private final Receiver receiver;

    public RemoveByID(Receiver receiver){
        this.receiver = receiver;
    }

    @Override
    public String execute(Invoker invoker, TreeSet<City> collection, String argument) {
        if (!argument.isEmpty()) {
            return receiver.removeById(collection, argument);
        } else {
            return "Команда remove_by_id должна принимать аргумент id";
        }
    }

    @Override
    public String getHelp() {
        return "Введите remove_by_id id, чтобы удалить элемент из коллекции по его id";
    }


}
