package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;

import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);
        testString.printSomething();
        String result = outputStream.toString();
        System.setOut(consoleStream);

        String[] stringArray = outputStream.toString().trim().split(" ");
        int a = Integer.parseInt(stringArray[0]);
        int b = Integer.parseInt(stringArray[2]);
        int c = 0;
        switch (stringArray[1]) {
            case "+" : {
                c = a + b;
                break;
            }
            case  "-" : {
                c = a - b;
                break;
            }
            case  "*" : {
                c = a * b;
                break;
            }
        }
        System.out.println(stringArray[0] + " " + stringArray[1] + " " + stringArray[2] + " " + stringArray[3] +
        " " + c);

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

