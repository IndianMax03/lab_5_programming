package com.github.indianMax03.lab_5_programming.commands;

import com.github.indianMax03.lab_5_programming.base.City;
import com.github.indianMax03.lab_5_programming.patterncommand.Command;
import com.github.indianMax03.lab_5_programming.patterncommand.Invoker;
import com.github.indianMax03.lab_5_programming.patterncommand.Receiver;

import java.util.TreeSet;

public class ExecuteScript implements Command {

    private final Receiver receiver;

    public ExecuteScript(Receiver receiver){
        this.receiver = receiver;
    }

    @Override
    public String execute(Invoker invoker, TreeSet<City> collection, String argument){
        return receiver.executeScript(invoker, collection, argument);
    }

    @Override
    public String getHelp(){
        return "Введите execute_script file_name, считать и исполнить скрипт из указанного файла.";
    }
}
