package com.github.indianMax03.lab_5_programming.commands;

import com.github.indianMax03.lab_5_programming.base.City;
import com.github.indianMax03.lab_5_programming.commands.patterncommand.CommandWithArgument;
import com.github.indianMax03.lab_5_programming.commands.patterncommand.Receiver;

import java.util.TreeSet;

public class FilterStartsWithName implements CommandWithArgument {

    private final Receiver receiver;

    public FilterStartsWithName(Receiver receiver){
        this.receiver = receiver;
    }

    @Override
    public void execute(TreeSet<City> collection, String argument) {
        receiver.filterStartsWithName(collection, argument);
    }
}
