package com.github.indianMax03.lab_5_programming.application;
import com.github.indianMax03.lab_5_programming.base.*;
import com.github.indianMax03.lab_5_programming.fileworker.WorkWithFile;
import com.github.indianMax03.lab_5_programming.patterncommand.*;

import java.io.*;
import java.util.*;

/**
 * Main class
 * @author Maxim Tuchkov
 */
public class Main {

    public static void main(String[] args) {

        /**
         * path to collection
         */
        String path = System.getenv("path");

        /**
         * Stores a list of commands
         */
        Invoker invoker = new Invoker();

        /**
         * Main collection
         */
        TreeSet<City> collection = new TreeSet<>();

        /**
         * Contains realisation of commands
         */
        Receiver receiver = new Receiver();

        /**
         * Filling the collection
         */
        try {
            WorkWithFile fileworker = new WorkWithFile();
            fileworker.fillCollection(collection, path);
        } catch (FileNotFoundException e) {
            System.out.println("Файл с входной коллекцией не найден или недостаточно прав.");
            System.exit(0);
        }

        /**
         * Filling the command list
         */
        AddCommands.addCommands(invoker, receiver);

        Terminal terminal = new Terminal(invoker, collection);
        terminal.startKeyboard();

           }
    }
