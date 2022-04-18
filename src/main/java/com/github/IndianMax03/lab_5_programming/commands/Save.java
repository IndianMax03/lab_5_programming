package com.github.indianMax03.lab_5_programming.commands;

import com.github.indianMax03.lab_5_programming.base.City;
import com.github.indianMax03.lab_5_programming.patterncommand.Command;
import com.github.indianMax03.lab_5_programming.patterncommand.Invoker;
import com.github.indianMax03.lab_5_programming.patterncommand.Receiver;

import java.util.TreeSet;

public class Save implements Command {
    private final Receiver receiver;

    public Save(Receiver receiver){
        this.receiver = receiver;
    }

    @Override
    public String execute (Invoker invoker, TreeSet<City> collection, String argument){
        if (argument.isEmpty()){
            return "Команда save принимает аргумент - имя файла.";
        } else {
            return receiver.save(collection, argument);
        }
    }

    @Override
    public String getHelp(){
        return "Введите save, чтобы сохранить коллекцию в файл";
    }

}
