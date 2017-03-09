package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напиште тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String text = reader.readLine();
            try {
                if (text.equals("exit")) {
                    break;
                } else {
                    if (text.contains(".")) {
                        print(Double.parseDouble(text));
                    } else if ((Integer.parseInt(text) > 0) && (Integer.parseInt(text) < 128)) {
                        print(Short.parseShort(text));
                    } else if ((Integer.parseInt(text) <= 0) | (Integer.parseInt(text) >= 128)) {
                        print(Integer.parseInt(text));
                    }
                }
            } catch (Exception e) {
                print(text);
            }
        }
    }
    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
