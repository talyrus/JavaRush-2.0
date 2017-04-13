package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(reader.readLine());

        HashMap<Integer, Integer> map = new HashMap<>();
        while (fileInputStream.available() > 0) { //пока есть байты в потоке
            int key = fileInputStream.read(); // считать очередной байт
            map.put(key, (map.containsKey(key) ? map.get(key) + 1 : 1)); // вставить байт как ключ и
            // подсчитать количество повторов
        }

        int maxEntry = 0;

        for (HashMap.Entry<Integer, Integer> entry : map.entrySet()) {
            if (maxEntry  < entry.getValue()) {
                maxEntry = entry.getValue(); // находим максимальное количество повторов
            }
        }

        for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
            if (pair.getValue() == maxEntry) {
                System.out.print(pair.getKey() + " "); // выводим их
            }
        }
        fileInputStream.close(); // закрываем поток чтения
    }
}
