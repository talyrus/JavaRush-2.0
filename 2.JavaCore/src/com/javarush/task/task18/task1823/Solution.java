package com.javarush.task.task18.task1823;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String file = reader.readLine();
            if (!file.equals("exit")) {
                new ReadThread(file).start();
            } else {
                break;
            }
        }
        reader.close();
    }

    public static class ReadThread extends Thread  {
        private String fileName;
        public ReadThread(String fileName) {
            this.fileName = fileName;
        }

        @Override
        public void run()  {
            try {
                FileInputStream fis = new FileInputStream(fileName); // создаем поток для считывания
                // и передаем аргумент с названием файла
                int [] arr = new int[127]; // создаем массив (0-127 коды символов в ASCII)
                while (fis.available() > 0) { // пока есть байты в потоке
                    arr[fis.read()]++; // взять байт из потока и увеличить на единицу соответствующий этому номеру
                    // элемент массива
                }
                int max_el = 0;
                for (int i = 0; i < arr.length; i++) { // цикл по массиву
                    if (arr[max_el] < arr[i] ) { // находим наибольший
                        max_el = i;
                    }
                }
                resultMap.put(fileName, max_el);
                fis.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
