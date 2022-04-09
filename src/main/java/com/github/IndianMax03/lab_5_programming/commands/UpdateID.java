package com.github.indianMax03.lab_5_programming.commands;

import com.github.indianMax03.lab_5_programming.base.City;
import com.github.indianMax03.lab_5_programming.commands.patterncommand.Command;
import com.github.indianMax03.lab_5_programming.commands.patterncommand.Invoker;
import com.github.indianMax03.lab_5_programming.commands.patterncommand.Receiver;

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
