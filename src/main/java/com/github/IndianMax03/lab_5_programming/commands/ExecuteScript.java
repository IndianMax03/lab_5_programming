package com.github.indianMax03.lab_5_programming.commands;

import com.github.indianMax03.lab_5_programming.base.City;
import com.github.indianMax03.lab_5_programming.patterncommand.Command;
import com.github.indianMax03.lab_5_programming.patterncommand.Invoker;
import com.github.indianMax03.lab_5_programming.patterncommand.Receiver;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.TreeSet;

public class ExecuteScript implements Command {

    private static final ArrayList<String> paths = new ArrayList<>();

    private final Receiver receiver;

    public ExecuteScript(Receiver receiver){
        this.receiver = receiver;
    }

    @Override
    public String execute(Invoker invoker, TreeSet<City> collection, String filename){

        if (filename.isEmpty()){
            return "Команда execute_script должна принимать аргумент file_name";
        } else {
            String file = new File(filename).getAbsolutePath();

            if (paths.contains(file)){
                return "Обнаружена рекурсия. Выполнение приостановлено.";
            } else{
                paths.add(file);
                try {
                    return receiver.executeScript(invoker, collection, filename);
                } catch (FileNotFoundException e){
                    return "Такого файла не существует или недостаточно прав на исполнение.";
                }
            }
        }

    }
    @Override
    public String getHelp(){
        return "Введите execute_script file_name, считать и исполнить скрипт из указанного файла.";
    }
}
