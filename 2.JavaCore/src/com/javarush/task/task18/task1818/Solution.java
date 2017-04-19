package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String file_1 = reader.readLine(); // считываем имя первого файла с консоли
            String file_2 = reader.readLine(); // второго
            String file_3 = reader.readLine(); // третьего
            FileOutputStream fileOut = new FileOutputStream(file_1); // создаем поток для записи в первый файл
            FileInputStream fileIn_2 = new FileInputStream(file_2); // создаем поток для чтения из второго файла
            FileInputStream fileIn_3 = new FileInputStream(file_3); // создаем поток для чтения из третьего файла
            while (fileIn_2.available() > 0 ) {
               fileOut.write(fileIn_2.read()); // считываем из второго файла и записываем в первый
            }
            while (fileIn_3.available() > 0 ) {
               fileOut.write(fileIn_3.read()); // считываем из третьего файла и записываем в первый
            }
            reader.close(); // закрываем потоки
            fileOut.close();
            fileIn_2.close();
            fileIn_3.close();
        }catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
