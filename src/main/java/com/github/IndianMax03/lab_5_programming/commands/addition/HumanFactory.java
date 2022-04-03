package com.github.indianMax03.lab_5_programming.commands.addition;

import com.github.indianMax03.lab_5_programming.base.Human;

public class HumanFactory {
    public static Human create (String name){
        int max = 201;
        final int height = (int) (Math.random() * ++max) + 1;
        return new Human(name, height,RandomDate.getDate() );
    }
}
