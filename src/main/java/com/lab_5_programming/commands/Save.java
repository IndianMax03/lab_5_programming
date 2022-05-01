package com.lab_5_programming.commands;

import com.lab_5_programming.patterncommand.Command;
import com.lab_5_programming.patterncommand.Invoker;
import com.lab_5_programming.patterncommand.Receiver;
import com.lab_5_programming.base.City;

import java.util.TreeSet;

public class Save implements Command {
    private final Receiver receiver;

    public Save(Receiver receiver){
        this.receiver = receiver;
    }

    @Override
    public String execute (Invoker invoker, TreeSet<City> collection, String argument){
        if (argument.isEmpty()){
            return receiver.save(collection);
        } else {
            return "Комнда save не принимает аргументы. Она работает с исходным файлом.";
        }
    }

    @Override
    public String getHelp(){
        return "Введите save, чтобы сохранить коллекцию в файл";
    }

}
