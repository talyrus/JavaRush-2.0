package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        TreeMap<String, Double> table = new TreeMap<>();
        while (reader.ready()) {
            String[] strings = reader.readLine().split(" ");
            Double summa;
            if (table.containsKey(strings[0])) {
                summa = table.get(strings[0]) + Double.parseDouble(strings[1]);
                table.put(strings[0], summa);
            } else
            {
                table.put(strings[0], Double.parseDouble(strings[1]));
            }

        }
        for (Map.Entry<String, Double> pair: table.entrySet()) {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }
        reader.close();
    }
}
