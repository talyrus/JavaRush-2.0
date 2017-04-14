package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(reader.readLine());

        byte [] buffer = new byte[inputStream.available()];
        while (inputStream.available() > 0) {
            inputStream.read(buffer);
        }
        int col = 0;
        for (int i = 0; i < buffer.length; i++) {
            if (buffer[i] == 44) {
                col++;
            }
        }
        System.out.println(col);
        reader.close();
        inputStream.close();
    }
}
