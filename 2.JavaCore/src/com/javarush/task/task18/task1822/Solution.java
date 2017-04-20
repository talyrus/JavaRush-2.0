package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine(); // считываем название файла

        BufferedReader buffer = new BufferedReader(new FileReader(file)); // считываем в буфер содержимое файла
        String str;

        while ( (str = buffer.readLine()) != null) { // считываем построчно
            if (str.split(" ")[0].equals(args[0])) { //получаем из строки первый символ, стоящий до пробела
                                                                    // и сравниваем его с id
                System.out.println(str);                        // выводим эту строчку
                break;                                      //прерываем цикл
            }
        }
        reader.close();         //закрываем поток и буфер
        buffer.close();
    }
}
