package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        BufferedReader fis = new BufferedReader(new FileReader(fileName));

        String string = "";
        int count = 0;
        while (fis.ready()) {
            string += fis.readLine() + ";"; // формируем одну строку из текста файла, вставляя разделитель
        }
        //System.out.println("Read: " + string);
        // заменим все символы не являющиеся буквами на ","
        string = string.replaceAll("[^A-Za-z]", ",");
        //System.out.println("********");
        //System.out.println(string);

        //загоним строку в массив, используя "," в качестве разделителя
        String[] data = string.split("[^A-Za-z]");

        for (int i = 0; i < data.length; i++) {
            if (data[i].equals("world")) { // перебираем элементы массива и ищем совпадения
                count++;
            }
        }
        System.out.println(count);
        fis.close();

    }
}
