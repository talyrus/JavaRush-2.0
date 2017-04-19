package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file_1 = reader.readLine();
        String file_2 = reader.readLine();
        reader.close();

        FileInputStream inputStream = new FileInputStream(file_1);
        FileOutputStream outputStream = new FileOutputStream(file_2);

        StringBuilder line = new StringBuilder();
        while (inputStream.available() > 0) {
            line.append(Character.toChars(inputStream.read()));
        }

        String[] num = line.toString().split(" ");
        for (String el: num) {
            outputStream.write(Integer.toString(Math.round(Float.parseFloat(el))).getBytes());
            outputStream.write(32);
        }

        inputStream.close();
        outputStream.close();

    }
}
