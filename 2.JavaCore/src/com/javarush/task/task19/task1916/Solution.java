package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader file_1 = new BufferedReader(new FileReader(reader.readLine()));
        BufferedReader file_2 = new BufferedReader(new FileReader(reader.readLine())); // считываем имена файлов и их содержимое
        reader.close(); // закрываем поток чтения

        ArrayList arrFile_1 = new ArrayList(); // создаем листы для каждого из файлов
        ArrayList arrFile_2 = new ArrayList();
        while (file_1.ready()) {
            arrFile_1.add(file_1.readLine()); // запишем содержимое первого файла
        }
        while (file_2.ready()) {
            arrFile_2.add(file_2.readLine()); // запишем содержимое второго файла
        }
        file_1.close(); // закроем потоки
        file_2.close();

        while (arrFile_1.size() != 0 & arrFile_2.size() != 0) { //если созданные листы не пустые
            if (arrFile_1.get(0).equals(arrFile_2.get(0))) { // сравним первые элементы. Если они равны
                lines.add(new LineItem(Type.SAME, arrFile_1.remove(0).toString())); // добавим в результирующий список
                arrFile_2.remove(0); // удалим элемент из второго списка
            } else if (arrFile_2.size() != 1 && arrFile_1.get(0).equals(arrFile_2.get(1))) { // если нулевой элемент первого списка равен первому элементу второго списка
                lines.add(new LineItem(Type.ADDED, arrFile_2.remove(0).toString())); //в итоговый список добавить элемент второго списка
            } else if (arrFile_2.size() != 1 && arrFile_1.get(1).equals(arrFile_2.get(0))) { // если первый элемент первого списка равен нулевому элементу второго списка
                lines.add(new LineItem(Type.REMOVED, arrFile_1.remove(0).toString())); //в итоговый список добавить элемент первого списка
            }
        }
        if (arrFile_1.size() != 0) { // если первый список не пустой
            lines.add(new LineItem(Type.REMOVED, arrFile_1.remove(0).toString())); // добавим в результирующий список
        } else if (arrFile_2.size() != 0) { // если второй список не пустой
            lines.add(new LineItem(Type.ADDED, arrFile_2.remove(0).toString())); // добавим в результирующий список
        }
       /* for (LineItem el: lines) {
            System.out.println(el.type.toString() + " " + el.line);
        }*/
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
