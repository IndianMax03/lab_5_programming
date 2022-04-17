package com.github.indianMax03.lab_5_programming.commands;

import com.github.indianMax03.lab_5_programming.base.City;
import com.github.indianMax03.lab_5_programming.patterncommand.Command;
import com.github.indianMax03.lab_5_programming.patterncommand.Invoker;
import com.github.indianMax03.lab_5_programming.patterncommand.Receiver;

import java.util.TreeSet;

public class Exit implements Command {

    private final Receiver receiver;

    public Exit(Receiver receiver){
        this.receiver = receiver;
    }

    @Override
    public String execute(Invoker invoker, TreeSet<City> collection, String argument) {
        if (argument.isEmpty()) {
            return receiver.exit();
        }
        else {
            return "Команда exit не принимает аргументы.";
        }
    }

    @Override
    public String getHelp(){
        return "Введите exit, чтобы завершить программу (без сохранения в файл)";
    }

}
