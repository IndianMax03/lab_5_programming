package com.github.indianMax03.lab_5_programming.application;

import com.github.indianMax03.lab_5_programming.commands.*;
import com.github.indianMax03.lab_5_programming.patterncommand.*;

public class AddCommands {
    /**
     *
     * @param invoker contains map of commands
     * @param receiver contains commands realisation
     */
    public static void addCommands(Invoker invoker, Receiver receiver){

        invoker.register("add", new Add(receiver));
        invoker.register("add_if_min", new AddIfMin(receiver));
        invoker.register("exit", new Exit(receiver));
        invoker.register("clear", new Clear(receiver));
        invoker.register("show", new Show(receiver));
        invoker.register("filter_starts_with_name", new FilterStartsWithName(receiver));
        invoker.register("print_descending", new PrintDescending(receiver));
        invoker.register("remove_all_by_government", new RemoveAllByGovernment(receiver));
        invoker.register("remove_by_id", new RemoveByID(receiver));
        invoker.register("remove_greater", new RemoveGreater(receiver));
        invoker.register("remove_lower", new RemoveLower(receiver));
        invoker.register("info", new Info(receiver));
        invoker.register("update", new UpdateId(receiver));
        invoker.register("help", new Help(receiver));
        invoker.register("save", new Save(receiver));
        invoker.register("execute_script", new ExecuteScript(receiver));

    }

}
