//  Command interface
package com.github.indianMax03.lab_5_programming.commands.patterncommand;

import com.github.indianMax03.lab_5_programming.base.City;

import java.util.TreeSet;

public interface Command {
    void execute(TreeSet<City> collection);
}
