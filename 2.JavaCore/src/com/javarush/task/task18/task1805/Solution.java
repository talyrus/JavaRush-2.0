package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(reader.readLine());

        int[] array = new int[256];
        while (inputStream.available() > 0) {
            array[inputStream.read()]++; //заполняем массив значениями байт
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0) {
                System.out.print(i + " "); // выводим номера позиций в массиве, которые являются значениями байт
            }
        }
        inputStream.close();
    }
}
