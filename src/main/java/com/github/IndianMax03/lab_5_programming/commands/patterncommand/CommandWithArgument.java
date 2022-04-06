package com.github.indianMax03.lab_5_programming.commands.patterncommand;

import com.github.indianMax03.lab_5_programming.base.City;

import java.util.TreeSet;

public interface CommandWithArgument {
    void execute(TreeSet<City> collection, String argument);
}
