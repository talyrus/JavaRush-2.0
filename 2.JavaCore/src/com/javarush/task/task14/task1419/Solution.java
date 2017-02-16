package com.javarush.task.task14.task1419;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //it's first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);                                  //1
        }
        try {
            Object object = new Character('z');
            Byte b = (Byte) object;
        } catch (ClassCastException e){
            exceptions.add(e);                                  //2
        }
        try {
            Integer [] list = {0, 1, 2};
            for (int i = 0; i <= list.length; i++) {
                list[i] = i * 2;
            }
        }catch (ArrayIndexOutOfBoundsException e){
            exceptions.add(e);                                  //3
        }
        try{
            Object[] array = new String[3];
            array[0] = new Character('+');
        }catch (ArrayStoreException e){
            exceptions.add(e);                                  //4
        }
        try{
            ArrayList<Integer> list = new ArrayList<>();
            list.add(7);
            for (int j = 0; j < 7; j++)
            {
                list.get(j);
            }
        }catch (IndexOutOfBoundsException e){
            exceptions.add(e);                                  //5
        }
        try{
            int i = Integer.parseInt("num");
        }catch (NumberFormatException e){
            exceptions.add(e);                                  //6
        }
        try{
            FileInputStream inputStream = new FileInputStream("file.txt");
        }catch (FileNotFoundException e){
            exceptions.add(e);                                  //7
        }
        try{
            Random random = null;
            int num = random.nextInt();
        }catch (NullPointerException e){
            exceptions.add(e);                                  //8
        }
        try{
            String stroka = "stroka";
            System.out.println(stroka.charAt(-1));
        }catch (StringIndexOutOfBoundsException e){
            exceptions.add(e);                                  //9
        }
        try{
            int[] array = new int[-1];
        }catch (NegativeArraySizeException e){
            exceptions.add(e);                                  //10
        }
       //напишите тут ваш код
    }
}
