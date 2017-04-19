package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) {
        try {
            FileInputStream reader = new FileInputStream(args[0]); //создаем поток чтения из файла
            // передаем в аргументе путь к нему
            int sum = reader.available(); // получим общее количество байтов (символов) в потоке
            int count = 0; // инициализируем счетчик пробелов
            while (reader.available() > 0) { //пока есть байты в потоке
                int temp = reader.read(); // считать очередной байт
	            if (temp == (byte)' ') {
	            //if (temp == 32) { // если его значение равно значению пробела (можно непосредственно по значению)
                    count++; //увеличим счетчик
                }
            }
            float result = (float) count/sum*100; // считаем соотношение пробелов к общему количеству символов
            System.out.format("%.2f", result); // форматируем полученный результат и выводим на консоль
            reader.close(); // закрываем поток
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
