package com.lab_5_programming.application;

import com.lab_5_programming.patterncommand.Invoker;
import com.lab_5_programming.base.City;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * A class for processing input
 */
public class Terminal {

	Scanner scanner;
	private final Invoker invoker;
	private final TreeSet<City> collection;
	private String out;

	public Terminal(Invoker invoker, TreeSet<City> collection) {
		this.invoker = invoker;
		this.collection = collection;

	}

	/**
	 *
	 * @param filename
	 * @return file execution result
	 * @throws FileNotFoundException
	 */
	public String startFile(String filename) throws FileNotFoundException {

		String pathToFile = new File(filename).getAbsolutePath();
		File file = new File(pathToFile);
		this.scanner = new Scanner(file);

		while (scanner.hasNextLine()){

			String commandLine = scanner.nextLine();

			try {
				out = lineHandler(commandLine);
				if (out == null){
					return "Выполнение файла окончено командой exit.";
				}
				System.out.println(out);
			} catch (NullPointerException e){
				return "В файле найдена несуществующая команда. Выполнение прекращено";
			}

		}
		return "Выполнение файла окончено.";
	}

	/**
	 * User input
	 */
	protected void startKeyboard(){

		this.scanner = new Scanner(System.in);

		System.out.println("Для вывода справки по командам введите help.");

		while (true) {

			System.out.print("Введите команду:\n>");

			String commandline = "";
			try{
				commandline = scanner.nextLine();
			} catch(NoSuchElementException e){
				break;
			}

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

	/**
	 *
	 * @param line input line
	 * @return command execution result
	 * @throws NullPointerException
	 */
	protected String lineHandler(String line) throws NullPointerException {

		String[] commandLine = line.trim().split(" ");
		String command = commandLine[0].trim();

		if (commandLine.length == 1) {
			out = invoker.execute(invoker, command, collection, "");
			return out;
		} else if (commandLine.length == 2) {

			String argument = commandLine[1];

			out = invoker.execute(invoker, command, collection, argument);

			return out;

		} else {
			throw new NullPointerException();
		}
	}

}
