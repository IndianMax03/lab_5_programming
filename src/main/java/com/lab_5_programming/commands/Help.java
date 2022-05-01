package com.lab_5_programming.commands;

import com.lab_5_programming.base.City;
import com.lab_5_programming.patterncommand.Command;
import com.lab_5_programming.patterncommand.Invoker;
import com.lab_5_programming.patterncommand.Receiver;

import java.util.TreeSet;

public class Help implements Command {

    private final Receiver receiver;

    public Help(Receiver receiver){
        this.receiver = receiver;
    }

    @Override
    public String execute(Invoker invoker, TreeSet<City> collection, String argument) {
        if (argument.isEmpty()){
            return receiver.help(invoker);
        } else {
            return "Команда help не принимает аргументы.";
        }
    }

    @Override
    public String getHelp(){
        return "Введите help, если хотитите вывести справку по доступным командам";
    }

}
