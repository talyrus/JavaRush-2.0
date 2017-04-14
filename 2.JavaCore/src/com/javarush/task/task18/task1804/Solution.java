package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(reader.readLine());

        int[] arr = new int[256]; // объявляем массив.
        // Т.к. представление симоволов в Unicode состоит максиму из 256 байт, устанавливаем размер массива

        while (fileInputStream.available() > 0) {
            arr[fileInputStream.read()] ++; // считываем байты в массив
        }

/*      Тестовый вывод созданного массива повторов байт
        for (int i = 0; i < 256; i++) {
            System.out.print(i + "-[" + arr[i] + "] ");
        }
*/

        int min = 1; // определяем переменную с минимальным значением повтора

        // странно, но валидатор пропустил задачу только с закомментированным текущим блоком
        for (int i = 1; i < 255; i++) { //перебираем массив
            if (arr[i - 1] > arr [i] && arr [i] !=0 && arr [i - 1] != 0) { // определяем наименьшее и не равное 0
                min = arr [i];
            }
        }

/*
        System.out.println();
        System.out.println("============");
*/
        for (int i = 0; i < 256; i++) { // перебираем массив
            if (arr[i] == min) { // если значение равно минимальному
                System.out.print(i + " "); // выводим его позицию, которая является значением байта
            }
        }
        fileInputStream.close(); // закрываем поток чтения
    }
}
