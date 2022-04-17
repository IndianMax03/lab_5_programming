package com.github.indianMax03.lab_5_programming.application;

import com.github.indianMax03.lab_5_programming.base.City;
import com.github.indianMax03.lab_5_programming.patterncommand.Invoker;

import java.util.Locale;
import java.util.Scanner;
import java.util.TreeSet;

public class Terminal {

	protected Scanner scanner = new Scanner(System.in);

	private final Invoker invoker;
	private final TreeSet<City> collection;
	private String out;

	public Terminal(Invoker invoker, TreeSet<City> collection) {
		this.invoker = invoker;
		this.collection = collection;

	}

	protected void startKeyboard(){

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
