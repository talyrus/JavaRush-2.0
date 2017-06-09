package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader readerIn = new BufferedReader(new InputStreamReader(System.in));
        String fileName = readerIn.readLine(); // считаем имя файл
        readerIn.close();

        BufferedReader reader = new BufferedReader(new FileReader(fileName)); // получем его содержимое
        ArrayList<Character> chars = new ArrayList<>(); //создадим список символов
        int symbol;
        while ((symbol = reader.read()) != -1) { // пока в буфере что-нибудь есть ;)
            chars.add((char) symbol);       // посимвольно добавим в список содержимое файла
        }
        reader.close();
        char[] сharTag = args[0].toCharArray(); // аргумент (тег) считаем в символьный массив
        int x = 0;    // если span есть, то x++, если /span, то x--.
                    // Если при этом x == 0, то вывод, если x != 0, то x--;
        int pointer = 0;
        for (int i = 0; i < chars.size(); i++) {    // переберем список с содержимым файла
//            System.out.print(chars.get(i) + "!");
            if (chars.get(i) == сharTag[0]) {    // если очередной символ текста равен первому символу тега
                int comparison = 1;
                for (int j = 1; j < сharTag.length; j++) { // тогда сравниваем остальные символы с символами тега
                    if (chars.get(i + j) == сharTag[j]) comparison++;
                }
                if (comparison == сharTag.length) {    // т.к. длины тегов совпадают (нашли тэг)
                    if (chars.get(i - 1) == '<') {    // проверим тег на то, что он открывающий
                        if (x == 0) pointer = i;    // если тэг первый и открывающий, то ставим точку
                        x++;
                    }
                    if (chars.get(i - 1) == '/' && (x != 0)) { // если тег закрывающий
                        x--;
                        if (x == 0) {    // если уровень совпадает
                            for (int j = pointer - 1; j < i + сharTag.length + 1; j++) {
                                if (chars.get(j) != 10) {
                                    System.out.print(chars.get(j));
                                }
                            }
                            System.out.println();
                            i = pointer + сharTag.length;
                        }
                    }
                }
            }
        }
    }
}
