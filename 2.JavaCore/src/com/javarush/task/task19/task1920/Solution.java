package com.javarush.task.task19.task1920;

/* 
Самый богатый
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
            if (table.containsKey(strings[0])) {
                table.put(strings[0], table.get(strings[0]) + Double.parseDouble(strings[1]));
            } else {
                table.put(strings[0], Double.parseDouble(strings[1]));
            }
         }
        Double maxValue = 0.0;
        for (Map.Entry<String, Double> pair: table.entrySet()) {
            if (pair.getValue() > maxValue) {
                maxValue = pair.getValue();
            }
        }
        for (Map.Entry<String, Double> pair: table.entrySet()) {
            if (pair.getValue().equals(maxValue)) {
                System.out.println(pair.getKey());
            }
        }
        reader.close();
    }
}
