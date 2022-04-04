package com.github.indianMax03.lab_5_programming.commands;

import com.github.indianMax03.lab_5_programming.base.City;
import com.github.indianMax03.lab_5_programming.commands.patterncommand.Command;
import com.github.indianMax03.lab_5_programming.commands.patterncommand.Receiver;

import java.util.TreeSet;

//  Command
public class Add implements Command {

    private final Receiver receiver;

    public Add(Receiver receiver){
        this.receiver = receiver;
    }

    @Override
    public void execute(TreeSet<City> collection) {
        receiver.add(collection);
    }
}
