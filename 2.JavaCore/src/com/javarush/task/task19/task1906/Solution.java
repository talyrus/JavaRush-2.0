package com.javarush.task.task19.task1906;

/* 
Четные байты
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName_1 = reader.readLine(); // считываем названия файлов
        String fileName_2 = reader.readLine();
        reader.close(); // закроем поток

        FileReader fileReader = new FileReader(fileName_1); // объект для чтения
        FileWriter fileWriter = new FileWriter(fileName_2); // объект для записи
        int count = 0;
        while (fileReader.ready()) { // пока есть данные в потоке чтения
            int data = fileReader.read(); // считать очередной байт
            count++;    // увеличим счетчик. Нумерация байтов начинается с 1, а не с 0
            if (count % 2 == 0) {   // если значение счетчика делится без остатка (четный индекс)
                fileWriter.write(data); // запишем байт в файл
            }
        }
        fileReader.close(); // закроем потоки
        fileWriter.close();
    }
}
