package com.github.indianMax03.lab_5_programming.commands;

import com.github.indianMax03.lab_5_programming.base.City;
import com.github.indianMax03.lab_5_programming.patterncommand.Command;
import com.github.indianMax03.lab_5_programming.patterncommand.Invoker;
import com.github.indianMax03.lab_5_programming.patterncommand.Receiver;

import java.util.TreeSet;

public class FilterStartsWithName implements Command {

    private final Receiver receiver;

    public FilterStartsWithName(Receiver receiver){
        this.receiver = receiver;
    }

    @Override
    public String execute(Invoker invoker, TreeSet<City> collection, String argument) {
        if (!argument.isEmpty()) {
            return receiver.filterStartsWithName(collection, argument);
        } else {
            return "Для команды filter_starts_with_name необходим аргумент name!";
        }
    }

    @Override
    public String getHelp(){
        return "Введите filter_starts_with_name name, чтобы вывести элементы, значение поля name которых начинается с " +
                "заданной подстроки";
    }
}
