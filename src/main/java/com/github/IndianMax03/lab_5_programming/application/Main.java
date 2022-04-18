package com.github.indianMax03.lab_5_programming.application;
// helios ssh sXXXXXX@helios.se.ifmo.ru -p 2222
import com.github.indianMax03.lab_5_programming.base.*;
import com.github.indianMax03.lab_5_programming.fileworker.WorkWithFile;
import com.github.indianMax03.lab_5_programming.patterncommand.*;

import java.io.*;
import java.util.*;

// todo доделать команды save и exucite_script


public class Main {

    public static void main(String[] args) {

        Invoker invoker = new Invoker(); //  Хранилище команд
        TreeSet<City> collection = new TreeSet<>(); //  Main collection
        Receiver receiver = new Receiver(); //  Коробка с командами
        WorkWithFile fileworker = new WorkWithFile();

        try {
            fileworker.fillCollection(collection); //  Автозаполнение коллекции
        } catch (FileNotFoundException e) {
            System.out.println("Файл с входной коллекцией не найден");
            System.exit(-1);
        }

        AddCommands.addCommands(invoker, receiver); //  Заполнение командами invoker'а

        Terminal terminal = new Terminal(invoker, collection); //  Терминал для работы с вводом от пользователя
        terminal.startKeyboard();


           }
    }
