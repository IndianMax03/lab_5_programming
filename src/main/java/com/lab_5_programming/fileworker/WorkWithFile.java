package com.lab_5_programming.fileworker;

import com.lab_5_programming.base.City;
import com.lab_5_programming.input.Adder;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

public class WorkWithFile {

    final String path = System.getenv("path");

    /**
     * filling the collection by environment variable
     */
    public void fillCollection(TreeSet<City> collectioin) throws IOException{

       Scanner sc = new Scanner(new File(path));

        int i = 1;

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            ArrayList<String> data = splitting(line);
            String result = Adder.canAddCityByArray(data, i, collectioin);
            if (result != null){
                System.out.println(result);
            }
            i++;
        }

        sc.close();
    }

    /**
     *  splits string with city's fields
     */
    private ArrayList<String> splitting(String line){
        ArrayList<String> splittedLine = new ArrayList<>();
        Scanner scanner = new Scanner(line);
        scanner.useDelimiter(",");
        while (scanner.hasNext()){
            splittedLine.add(scanner.next().trim());
        }
        scanner.close();
        return splittedLine;
    }

    /**
     * file writer
     */
    public String writeInFile(TreeSet<City> collection){

        try (BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(path))) {
            for (City city : collection){
                byte[] s = city.cityToString().getBytes(StandardCharsets.UTF_8);
                out.write(s);
                out.write("\n".getBytes(StandardCharsets.UTF_8));
            }
            return "Коллекция успешно записана в файл.";
        } catch (IOException e){
            return "Не хватает прав на запись в файл.";
        }

    }

}
