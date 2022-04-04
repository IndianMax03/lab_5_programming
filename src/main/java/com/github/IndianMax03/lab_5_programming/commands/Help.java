package com.github.indianMax03.lab_5_programming.commands;

import com.github.indianMax03.lab_5_programming.base.City;
import com.github.indianMax03.lab_5_programming.commands.patterncommand.Command;
import com.github.indianMax03.lab_5_programming.commands.patterncommand.Receiver;

import java.util.TreeSet;

public class Help implements Command {

    private final Receiver receiver;

    public Help(Receiver receiver){
        this.receiver = receiver;
    }

    @Override
    public void execute(TreeSet<City> collection) {
        receiver.help();
    }

}
