package com.github.indianMax03.lab_5_programming.patterncommand;

import com.github.indianMax03.lab_5_programming.base.City;

import java.util.TreeSet;

/**
 * Common interface for commands
 */
public interface Command {

    String execute(Invoker invoker, TreeSet<City> collection, String argument);

    String getHelp();

}
