package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));
        StringBuffer result = new StringBuffer("");

        while (reader.ready()) {
            String[] text = reader.readLine().split(" ");

            for (String el: text) {
                if (el.length() > 6) {
                    result.append(el).append(",");
                }
            }
        }
        result.delete(result.length() - 1, result.length());
        writer.write(result.toString());
        reader.close();
        writer.close();
    }
}
