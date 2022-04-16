package com.github.indianMax03.lab_5_programming.commands;

import com.github.indianMax03.lab_5_programming.base.City;
import com.github.indianMax03.lab_5_programming.commands.patterncommand.Command;
import com.github.indianMax03.lab_5_programming.commands.patterncommand.Invoker;
import com.github.indianMax03.lab_5_programming.commands.patterncommand.Receiver;

import java.util.TreeSet;

public class Save implements Command {
    private final Receiver receiver;

    public Save(Receiver receiver){
        this.receiver = receiver;
    }

    @Override
    public String execute (Invoker invoker, TreeSet<City> collection, String argument){
        return receiver.save(collection);
    }

    @Override
    public String getHelp(){
        return "Введите save, чтобы сохранить коллекцию в файл";
    }

}
