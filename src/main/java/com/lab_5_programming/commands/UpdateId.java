package com.lab_5_programming.commands;

import com.lab_5_programming.base.City;
import com.lab_5_programming.patterncommand.Command;
import com.lab_5_programming.patterncommand.Invoker;
import com.lab_5_programming.patterncommand.Receiver;

import java.util.TreeSet;

public class UpdateId implements Command {


    private final Receiver receiver;

    public UpdateId(Receiver receiver){
        this.receiver = receiver;
    }

    @Override
    public String execute(Invoker invoker, TreeSet<City> collection, String argument) {
        if (!argument.isEmpty()) {
            return receiver.updateId(collection, argument);
        } else {
            return "Команде update_id требуется аргумент id";
        }
    }

    @Override
    public String getHelp(){
        return "Введите update id {element}, чтобы обновить значение элемента коллекции, id которого равен заданному";
    }
}
