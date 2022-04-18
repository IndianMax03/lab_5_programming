package com.github.indianMax03.lab_5_programming.fileworker;

import com.github.indianMax03.lab_5_programming.base.City;
import com.github.indianMax03.lab_5_programming.input.Adder;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

public class WorkWithFile {

    //todo ПУТЬ ДОЛЖНЫ ПОЛУЧАТЬ ПО-ДРУГОМУ
    public void fillCollection(TreeSet<City> collectioin) throws FileNotFoundException{
        File file = new File("InputCollection.txt");

       Scanner sc = new Scanner(file);

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

    public String writeInFile(TreeSet<City> collection, String path){

        File file = new File(path);

        try (BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(file))) {
            for (City city : collection){
                byte[] s = city.cityToString().getBytes(StandardCharsets.UTF_8);
                out.write(s);
                out.write("\n".getBytes(StandardCharsets.UTF_8));
            }
            return "Коллекция успешно записана в файл.";
        } catch (IOException e){
            return "Аргумент передан неверно.";
        }

    }

}
