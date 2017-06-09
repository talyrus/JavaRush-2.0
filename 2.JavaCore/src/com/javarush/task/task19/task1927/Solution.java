package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out; //запоминаем настоящий PrintStream
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(); //создаем динамический массив
        PrintStream stream = new PrintStream(outputStream); //создаем адаптер к классу PrintStream
        System.setOut(stream); //подменим поток, установив его как текущий System.out
        testString.printSomething(); //Вызываем функцию, которая ничего не знает о наших манипуляциях
        System.setOut(consoleStream); // восстановим поток

        String[] result = outputStream.toString().split("\n"); //загоним outputStream в массив, разделяя по переходу на новую строку
        for (int i = 0; i < result.length; i++) { // цикл по массиву
            if (i % 2 == 0 && i != 0) { // если четное и не равно нулю
                System.out.println("JavaRush - курсы Java онлайн"); // вывести строку
            }
            System.out.println(result[i]);
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
