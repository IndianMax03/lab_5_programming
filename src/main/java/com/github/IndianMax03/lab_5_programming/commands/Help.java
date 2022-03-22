package com.github.indianMax03.lab_5_programming.commands;

public class Help {

    public static String redBold(String str){
        final String RED_BOLD_UNDERLINED_START =  "\033[4;30m" + "\033[1;91m";
        final String RED_BOLD_UNDERLINED_RESET = "\033[0m";
        return RED_BOLD_UNDERLINED_START + str + RED_BOLD_UNDERLINED_RESET;
    }

    public static void call(){
        System.out.println("Введите " + redBold("add") + " для добавления нового элемента в коллекцию;");
        System.out.println("Введите " + redBold("clear") + ", чтобы очистить существующую коллекцию;");
        System.out.println("Введите " + redBold("remove_by_id") + ", чтобы удалить элемент из коллекции по его id;");
        System.out.println("Введите " + redBold("remove_all_by_government") + ", чтобы удалить из коллекции все " +
                " элементы, значение поля government которого эквивалентно заданному;");
        System.out.println("Введите " + redBold("remove_lower") + ", чтобы удалить из коллекции все элементы, " +
                " меньшие, чем заданный;");
        System.out.println("Введите " + redBold("remove_greater") + ", чтобы удалить из коллекции все элементы," +
                " превышающие заданный;");
        System.out.println("Введите " + redBold("add_if_min") + ", чтобы добавить новый элемент в коллекцию, если" +
                " его значение меньше, чем у наименьшего элемента этой коллекции;");
        System.out.println("Введите " + redBold("update_id") + ", обновить значение элемента коллекции, id которого" +
                " равен заданному;");
        System.out.println("Введите " + redBold("info") + ", чтобы вывести в стандартный поток вывода информацию о" +
                " коллекции;");
        System.out.println("Введите " + redBold("show") + ", чтобы вывести в стандартный поток вывода все элементы" +
                " коллекции в строковом представлении;");

        System.out.println("Введите " + redBold("exit") + ", чтобы завершить программу (коллекция не будет сохранена в файл);");
    }
}
