package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String file_1 = reader.readLine();
            String file_2 = reader.readLine();
            reader.close();

            FileInputStream fileIn = new FileInputStream(file_1); // создаем и инициализируем поток вывода из файла
            byte[] arr_byte = new byte[fileIn.available()]; // создаем массив байт, равный количеству байт в потоке
            int len_copy_1 = fileIn.read(arr_byte); // считываем байты из потока в массив байт, количество считанных байт
                                                    //записываем в переменную
            fileIn.close();

            FileOutputStream fileOut = new FileOutputStream(file_1);
            FileInputStream fileIn_2 = new FileInputStream(file_2); // создаем и инициализируем поток вывода из файла
            byte[] arr_byte_2 = new byte[fileIn_2.available()];
            int len_copy_2 = fileIn_2.read(arr_byte_2);

            fileOut.write(arr_byte_2, 0, len_copy_2); // записать len_copy_2 байтов из массива байт arr_byte_2
            fileOut.write(arr_byte, 0, len_copy_1);

            fileIn_2.close();
            fileOut.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
