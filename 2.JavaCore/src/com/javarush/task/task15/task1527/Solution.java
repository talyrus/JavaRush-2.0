package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) {
        //add your code here
        String str;
        String substr;
        String[] parametrs;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            str = reader.readLine();
            substr = str.substring(str.indexOf('?') + 1);
            parametrs = substr.split("&");
            for (String s: parametrs) {
                if(s.contains("=")) {
                    System.out.print(s.substring(0, s.indexOf('=')) + " ");
                } else {
                    System.out.print(s + " ");
                }
            }
            System.out.println();

            String subObj;
            for (String ss: parametrs) {
                if (ss.contains("obj=")) {
                    subObj = ss.substring(ss.indexOf('=') + 1);
                    try {
                        alert(Double.parseDouble(subObj));
                    } catch ( NumberFormatException e) {
                        alert(subObj);
                    }
                    /* так не прошло
                    if ( subObj.contains(".") || subObj.matches("[\\d]+") ) {
                        alert(Double.parseDouble(subObj));
                    } else {
                        alert(subObj);
                    }
                    */
                }
            }
        }catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
