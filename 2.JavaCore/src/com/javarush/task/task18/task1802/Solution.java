package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileInputStream inputStream = new FileInputStream(reader.readLine());
        int readByte;
        int compareByte = inputStream.read();
        while (inputStream.available() > 0) {
            readByte = inputStream.read();
           // System.out.println(readByte);
            if ((compareByte > readByte) ) {
                compareByte = readByte;
            }
        }
        inputStream.close();
        System.out.println(compareByte);
    }
}
