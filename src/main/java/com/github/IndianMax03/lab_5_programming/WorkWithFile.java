package com.github.indianMax03.lab_5_programming;

import com.github.indianMax03.lab_5_programming.base.City;
import com.github.indianMax03.lab_5_programming.commands.addition.AddCity;
import com.opencsv.CSVReader;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

public class WorkWithFile {

    //todo ПУТЬ ДОЛЖНЫ ПОЛУЧАТЬ ПО-ДРУГОМУ
    protected void fillCollection(TreeSet<City> collectioin) throws FileNotFoundException{
        File file = new File("InputCollection.txt");

       Scanner sc = new Scanner(file);

        int i = 1;

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            ArrayList<String> data = splitting(line);
            String result = AddCity.canAddCityByArray(data, i, collectioin);
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

    protected void copyInFile(){
        String pathToSource =
                "C:\\Users\\Acer\\Desktop\\Lab_5\\src\\main\\java\\com\\github\\indianMax03\\lab_5_programming\\InputCollection.txt";
        String pathToTarger =
                "C:\\Users\\Acer\\Desktop\\Lab_5\\src\\main\\java\\com\\github\\indianMax03\\lab_5_programming\\Output.txt";

        int bufferSize = 1024 * 8;
        int indexStartReading = 0;

        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(pathToSource)); //  Откуда

            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(pathToTarger))){ //  Куда

            byte[] dataBuffer = new byte[bufferSize];

            int dataLength = in.read(dataBuffer, indexStartReading, bufferSize);

            while( dataLength != 1){
                out.write(dataBuffer, 0, dataLength);
                out.flush();
                dataLength = in.read(dataBuffer, indexStartReading, bufferSize);
            }

        } catch (Exception e) {
            System.out.println("Чтение окончено.");
        }
    }

}
