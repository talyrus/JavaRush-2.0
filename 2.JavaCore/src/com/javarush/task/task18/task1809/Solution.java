package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        String fileIn, fileOut;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        fileIn = reader.readLine();
        fileOut = reader.readLine();

        FileInputStream fileInputStream = new FileInputStream(fileIn);
        FileOutputStream fileOutputStream = new FileOutputStream(fileOut);

        byte[] buffer = new byte[fileInputStream.available()];

        while (fileInputStream.available() > 0) {
           int size = fileInputStream.read(buffer);
            for (int i = size - 1; i >= 0 ; i--) {
                fileOutputStream.write(buffer[i]);
            }
        }

        reader.close();
        fileInputStream.close();
        fileOutputStream.close();

    }
}
