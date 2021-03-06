//  Invoker class
package com.lab_5_programming.patterncommand;

import com.lab_5_programming.base.City;

import java.util.HashMap;
import java.util.TreeSet;

/**
 * Responsible for storing the list of commands
 */
public class Invoker {

    private final HashMap<String, Command> commandMap = new HashMap<>();

    public void register(String commandName, Command command){
        commandMap.put(commandName, command);
    }

    public String execute(Invoker invoker, String commandName, TreeSet<City> collection, String argument){

        Command command = commandMap.get(commandName);

        return command.execute(invoker, collection, argument);

    }

    public HashMap<String, Command> getCommandMap(){
        return this.commandMap;
    }

}
