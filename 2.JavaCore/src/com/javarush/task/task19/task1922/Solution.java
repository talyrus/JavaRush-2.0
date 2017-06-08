package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        reader.close();

        BufferedReader fileReader = new BufferedReader(new FileReader(file));
       // BufferedReader fileReader = new BufferedReader(new FileReader("d:\\!Virus\\test.txt"));
        while (fileReader.ready()) {
            int count = 0;
            String string = fileReader.readLine();
            String[] arrWords = string.split(" ");
            for (String pair: arrWords) {
                for (String item: words) {
                    if (pair.equals(item)) {
                        count++;
                    }
                }
            }
            if (count == 2) {
                System.out.println(string);
            }
        }
        fileReader.close();
    }
}
