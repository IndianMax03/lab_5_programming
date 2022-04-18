package com.github.indianMax03.lab_5_programming.application;

import com.github.indianMax03.lab_5_programming.base.City;
import com.github.indianMax03.lab_5_programming.patterncommand.Invoker;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeSet;

public class Terminal {

	Scanner scanner;
	private final Invoker invoker;
	private final TreeSet<City> collection;
	private String out;

	public Terminal(Invoker invoker, TreeSet<City> collection) {
		this.invoker = invoker;
		this.collection = collection;

	}

	public String startFile(File file) {

		try {
			this.scanner = new Scanner(file);
		} catch (FileNotFoundException e){
			return "Файл не найден.";
		}

		while (scanner.hasNextLine()){

			String commandline = scanner.nextLine();

			try {
				out = lineHandler(commandline);
				if (out == null){
					return "Выполнение файла окончено командой exit.";
				}
				System.out.println(out);
			} catch (NullPointerException e){
				return "В файле найдена несуществующая команда. Выполнение прекращено";
			}

		}

		return "Файл выполнен успешно";

	}

	protected void startKeyboard(){

		this.scanner = new Scanner(System.in);

		System.out.println("Для вывода справки по командам введите help.");

		while (true) {

			System.out.print("Введите команду:\n>");

			String commandline = scanner.nextLine();

			try {
				out = lineHandler(commandline);
				if (out == null){
					break;
				}
				System.out.println(out);
			} catch (NullPointerException e){
				System.out.println("Такой команды не существует.");
			}

		}
	}

	protected String lineHandler(String input) throws NullPointerException {

		String[] commandLine = input.trim().split(" ");
		String command = commandLine[0];
		if (commandLine.length == 1) {
			out = invoker.execute(invoker, command, collection, "");
			return out;
		} else if (commandLine.length == 2) {
			out = invoker.execute(invoker, command, collection, commandLine[1]);
			return out;
		} else {
			throw new NullPointerException();
		}
	}

}
