package com.github.indianMax03.lab_5_programming.application;
// helios ssh sXXXXXX@helios.se.ifmo.ru -p 2222
import com.github.indianMax03.lab_5_programming.base.*;
import com.github.indianMax03.lab_5_programming.fileworker.WorkWithFile;
import com.github.indianMax03.lab_5_programming.patterncommand.*;

import java.io.*;
import java.util.*;

// todo доделать команды save и exucite_script


public class Main {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        Invoker invoker = new Invoker(); //  Хранилище команд
        TreeSet<City> collection = new TreeSet<>(); //  Main collection
        Receiver receiver = new Receiver(); //  Коробка с командами
        WorkWithFile fileworker = new WorkWithFile();
        fileworker.fillCollection(collection); //  Автозаполнение коллекции
        AddCommands.addCommands(invoker, receiver); //  Заполнение командами invoker'а

        Terminal terminal = new Terminal(invoker, collection); //  Терминал для работы с вводом от пользователя
        terminal.startKeyboard();

           }
    }
