package com.github.indianMax03.lab_5_programming.commands;

import com.github.indianMax03.lab_5_programming.base.City;

import java.util.TreeSet;

public class Clear {
    public static void call(TreeSet<City> collection){
        collection.clear();
    }
}
