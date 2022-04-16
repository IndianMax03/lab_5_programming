package com.github.indianMax03.lab_5_programming.commands.addition;

import com.github.indianMax03.lab_5_programming.commands.*;
import com.github.indianMax03.lab_5_programming.commands.patterncommand.*;

public class AddCommands {
    public static void addCommands(Invoker invoker, Receiver receiver){
        Command add = new Add(receiver);
        invoker.register("add", add);
        Command addIfMin = new AddIfMin(receiver);
        invoker.register("add_if_min", addIfMin);
        Command exit = new Exit(receiver);
        invoker.register("exit", exit);
        Command clear = new Clear(receiver);
        invoker.register("clear", clear);
        Command show = new Show(receiver);
        invoker.register("show", show);
        Command filterStartsWithName = new FilterStartsWithName(receiver);
        invoker.register("filter_starts_with_name", filterStartsWithName);
        Command printDescending = new PrintDescending(receiver);
        invoker.register("print_descending", printDescending);
        Command removeAllByGovernment = new RemoveAllByGovernment(receiver);
        invoker.register("remove_all_by_government", removeAllByGovernment);
        Command removeById = new RemoveByID(receiver);
        invoker.register("remove_by_id", removeById);
        Command removeGreater = new RemoveGreater(receiver);
        invoker.register("remove_greater", removeGreater);
        Command removeLower = new RemoveLower(receiver);
        invoker.register("remove_lower", removeLower);
        Command info = new Info(receiver);
        invoker.register("info", info);
        Command updateId = new UpdateId(receiver);
        invoker.register("update", updateId);
        Command help = new Help(receiver);
        invoker.register("help", help);
        Command save = new Save(receiver);
        invoker.register("save", save);
    }
}
