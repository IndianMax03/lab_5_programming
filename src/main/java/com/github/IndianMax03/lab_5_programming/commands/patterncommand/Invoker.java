//  Invoker class
package com.github.indianMax03.lab_5_programming.commands.patterncommand;

import com.github.indianMax03.lab_5_programming.base.City;

import java.util.HashMap;
import java.util.TreeSet;

public class Invoker {
    private final HashMap<String, Command> commandMap = new HashMap<>();
    private final HashMap<String, CommandWithArgument> commandMapWithArg = new HashMap<>();
    
    public void register(String commandName, Command command){
        commandMap.put(commandName, command);
    }
    public void registerWithArg(String commandName, CommandWithArgument command) {commandMapWithArg.put(commandName, command); }

    public void execute(String commandName, TreeSet<City> collection) throws IllegalStateException{

        Command command = commandMap.get(commandName);
        command.execute(collection);
    }

    public void executeWithArg(String commandName, TreeSet<City> collection, String argument) throws IllegalStateException{
        CommandWithArgument command = commandMapWithArg.get(commandName);
        command.execute(collection, argument);
    }
}
