//  Invoker class
package com.github.indianMax03.lab_5_programming.commands.patterncommand;

import com.github.indianMax03.lab_5_programming.base.City;

import java.util.HashMap;
import java.util.TreeSet;

public class Invoker {
    private final HashMap<String, Command> commandMap = new HashMap<>();

    public void register(String commandName, Command command){
        commandMap.put(commandName, command);
    }

    public void execute(String commandName, TreeSet<City> collection) throws IllegalStateException{

        Command command = commandMap.get(commandName);
        command.execute(collection);
    }
}
