package com.javarush.task.task19.task1915;

/* 
Дублируем текст
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine(); // считаем имя файла с консоли
        reader.close(); // закроем поток

        PrintStream consoleStream = new PrintStream(System.out); //запоминаем настоящий PrintStream в специальную переменную
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();//Создаем динамический массив
        PrintStream stream = new PrintStream(outputStream);//создаем адаптер к классу PrintStream
        System.setOut(stream); // подменим поток, Устанавливаем его как текущий System.out
        testString.printSomething();//Вызываем функцию, которая ничего не знает о наших манипуляциях
        System.setOut(consoleStream); // восстановим поток

        System.out.println(outputStream.toString()); //Преобразовываем в строку записанные в наш ByteArray данные и выведем в консоль

        FileOutputStream fos = new FileOutputStream(fileName); //создадим поток вывода, указав имя файла
        fos.write(outputStream.toByteArray()); //преобразуем массив в массив бай и запишем в файл.
        fos.close();
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

