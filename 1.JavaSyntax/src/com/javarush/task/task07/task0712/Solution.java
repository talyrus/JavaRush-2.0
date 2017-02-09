package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int pos_min = 0, pos_max = 0;

        ArrayList<String> arrayList = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            arrayList.add(reader.readLine());
        }
        int min = arrayList.get(0).length();
        for (int i = 1; i < arrayList.size() ; i++) {
            if (min > arrayList.get(i).length()) {
                min = arrayList.get(i).length();
                pos_min = i;
            }
        }
        //System.out.println("Минимальный элемент " + min + " символов, на позиции " + pos_min +" " + arrayList.get(pos_min));

        int max = arrayList.get(0).length();
        for (int i = 1; i < arrayList.size() ; i++) {
            if (max < arrayList.get(i).length()) {
                max = arrayList.get(i).length();
                pos_max = i;
            }
        }
        //System.out.println("Максимальный элемент " + max + " символов, на позиции  " + pos_max + " " + arrayList.get(pos_max));
        if (pos_min < pos_max) {
            System.out.println(arrayList.get(pos_min));
        }else {
            System.out.println(arrayList.get(pos_max));
        }
    }
}
