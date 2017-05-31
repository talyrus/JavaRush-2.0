package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        String regex = "(\\b)\\d+(\\b)"; // составим шаблон - выделим отдельно стоящие цифры

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file_1 = reader.readLine(); // считаем названия файлов
        String file_2 = reader.readLine();
        reader.close();     // закроем поток

        BufferedReader fileReader = new BufferedReader(new FileReader(file_1));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(file_2));

        String string = "";
        while (fileReader.ready()) {
            string += fileReader.readLine(); // считаем содержимое первого файла
        }

        Pattern pattern = Pattern.compile(regex); // скомпилируем регулярное выражение в паттерн
        Matcher matcher = pattern.matcher(string); // применим к строке паттерн
        //StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {    // при нахождении совпадения
            //stringBuffer.append(matcher.group() + " ");
            fileWriter.write(matcher.group() + " "); // добавим в файл найденную группу
        }
        //System.out.println(stringBuffer.toString());
        fileReader.close(); // закроем потоки
        fileWriter.close();
    }
}
