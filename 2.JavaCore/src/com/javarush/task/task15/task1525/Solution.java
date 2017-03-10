package com.javarush.task.task15.task1525;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* 
Файл в статическом блоке
*/

public class Solution {
    public static List<String> lines = new ArrayList<String>();

    static  {
        String str;
        try (BufferedReader reader = new BufferedReader(new FileReader(Statics.FILE_NAME)) ){
            while ((str = reader.readLine()) != null) {
                lines.add(str);
            }
        reader.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println(lines);
    }
}
