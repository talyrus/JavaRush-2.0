package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file, file_1, file_2;
        file = reader.readLine();
        file_1 = reader.readLine();
        file_2 = reader.readLine();

        FileInputStream inputStream = new FileInputStream(file); //считываем имя первого файла
        FileOutputStream outputStream_1 = new FileOutputStream(file_1);//считываем имя второго файла
        FileOutputStream outputStream_2 = new FileOutputStream(file_2);//считываем имя третьего файла

        byte[] buffer_1 = new byte[inputStream.available() / 2 + inputStream.available() % 2];// делим поток на половину + 1 байт
        byte[] buffer_2 = new byte[inputStream.available() / 2];

        while (inputStream.available() > 0) {
            outputStream_1.write(buffer_1, 0, inputStream.read(buffer_1)); //записываем первую половину
            outputStream_2.write(buffer_2, 0, inputStream.read(buffer_2)); //записываем вторую половину
        }
        //закрываем потоки
        reader.close();
        inputStream.close();
        outputStream_1.close();
        outputStream_2.close();
    }
}
