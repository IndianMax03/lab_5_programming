package com.lab_5_programming.application;
import com.lab_5_programming.base.City;
import com.lab_5_programming.fileworker.WorkWithFile;
import com.lab_5_programming.patterncommand.Invoker;
import com.lab_5_programming.patterncommand.Receiver;

import java.io.*;
import java.util.*;

/**
 * Main class
 * @author Maxim Tuchkov
 */
public class Main {

    public static void main(String[] args) {

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
            fileworker.fillCollection(collection);
        } catch (IOException e) {
            System.out.println("Файл с входной коллекцией не найден или недостаточно прав на чтение.");
            return;
        } catch (NullPointerException e){
            System.out.println("При запуске программы необходимо передать переменную окружения path.");
            return;
        }

        /**
         * Filling the command list
         */
        AddCommands.addCommands(invoker, receiver);

        Terminal terminal = new Terminal(invoker, collection);
        terminal.startKeyboard();

           }
    }
