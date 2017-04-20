package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException{
        FileInputStream fis = new FileInputStream(args[0]); // создаем поток для считывания
                                                            // и передаем аргумент с названием файла
        int [] arr = new int[127]; // создаем массив (0-127 коды символов в ASCII)
        while (fis.available() > 0) { // пока есть байты в потоке
            arr[fis.read()]++; // взять байт из потока и увеличить на единицу соответствующий этому номеру
                               // элемент массива
        }
        for (int i = 0; i < arr.length; i++) { // цикл по массиву
            if (arr[i] != 0 ) { // отбрасываем значения с нулями
                System.out.println((char) i + " " + arr[i]); // преобразовать число в соответствующий символ,
                                                             // и вывести из массива количество раз повторений
            }
        }
        fis.close();
    }
}
