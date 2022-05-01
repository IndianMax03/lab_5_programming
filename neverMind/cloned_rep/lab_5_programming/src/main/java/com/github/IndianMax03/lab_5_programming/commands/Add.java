package com.github.indianMax03.lab_5_programming.commands;

import com.github.indianMax03.lab_5_programming.base.City;
import com.github.indianMax03.lab_5_programming.patterncommand.Command;
import com.github.indianMax03.lab_5_programming.patterncommand.Invoker;
import com.github.indianMax03.lab_5_programming.patterncommand.Receiver;

import java.util.TreeSet;

//  Command
public class Add implements Command {

    private final Receiver receiver;

    public Add(Receiver receiver){
        this.receiver = receiver;
    }

    @Override
    public String execute(Invoker invoker, TreeSet<City> collection, String argument) {
        if (argument.isEmpty()){
            return receiver.add(collection);
        } else {
            return "Команда add не принимает аргументы.";
        }
    }

    @Override
    public String getHelp(){
        return "Введите add {element}, чтобы добавить новый элемент в коллекцию";
    }
}
