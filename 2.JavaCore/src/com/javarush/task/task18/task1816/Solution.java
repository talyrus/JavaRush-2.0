package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) {
        try {
            FileInputStream reader = new FileInputStream(args[0]); //создаем поток чтения и передаем
            // в него наименование файла из аргумента
            int count = 0;
            int temp;
            while (reader.available() > 0) { // пока из потока считываются байты
                temp = reader.read(); // считаем очередной байт в переменную
                if (temp >= (byte)'a' && temp <= 'z') { // если значение байта находится в заданном диапазоне
                    count++; // увеличиваем счетчик
                } else if (temp >= (byte)'A' && temp <= 'Z') {
                    count++;
                }
            }
            reader.close(); // закрываем поток
            System.out.println(count); // выводим значение счетчика количество символов английского языка в файле
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
