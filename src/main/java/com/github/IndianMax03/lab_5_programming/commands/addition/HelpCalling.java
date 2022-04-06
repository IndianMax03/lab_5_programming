package com.github.indianMax03.lab_5_programming.commands.addition;

public class HelpCalling {
    public HelpCalling() {
        System.out.println("Введите help, если хотитите вывести справку по доступным командам");
        System.out.println("Введите info, чтобы вывести в стандартный поток вывода информацию о коллекции (тип, дата" +
                " инициализации, количество элементов и т.д.)");
        System.out.println("Введите show, чтобы вывести в стандартный поток вывода все элементы коллекции в строковом" +
                " представлении");
        System.out.println("Введите add {element}, чтобы добавить новый элемент в коллекцию");
        System.out.println("Введите update id {element}, чтобы обновить значение элемента коллекции, id которого равен заданному");
        System.out.println("Введите remove_by_id id, чтобы удалить элемент из коллекции по его id");
        System.out.println("Введите clear, чтобы очистить коллекцию");
        System.out.println("Введите save, чтобы сохранить коллекцию в файл");
        System.out.println("Введите execute_script file_name, чтобы считать и исполнить скрипт из указанного файла. " +
                "В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.");
        System.out.println("Введите exit, чтобы завершить программу (без сохранения в файл)");
        System.out.println("Введите add_if_min {element}, чтобы добавить новый элемент в коллекцию, если его значение" +
                " меньше, чем у наименьшего элемента этой коллекции");
        System.out.println("Введите remove_greater {element}, чтобы удалить из коллекции все элементы, превышающие заданный");
        System.out.println("Введите remove_lower {element}, чтобы удалить из коллекции все элементы, меньшие, чем заданный");
        System.out.println("Введите remove_all_by_government government, чтобы удалить из коллекции все элементы, " +
                "значение поля government которого эквивалентно заданному");
        System.out.println("Введите filter_starts_with_name name, чтобы вывести элементы, значение поля name которых " +
                "начинается с заданной подстроки");
        System.out.println("Введите print_descending, чтобы вывести элементы коллекции в порядке убывания");

    }
}
