package com.javarush.task.task15.task1529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Осваивание статического блока
*/

public class Solution {
    public static void main(String[] args) {

    }
    
    static {
        //add your code here - добавьте код тут
        try{ reset();}
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static Flyable result;

    public static void reset() throws IOException {
        //add your code here - добавьте код тут

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String type = reader.readLine();
            if (type.equals("helicopter")) {
                result = new Helicopter();
            } else if (type.equals("plane")) {
                result = new Plane(Integer.parseInt(reader.readLine()));
            }
           reader.close ();
        }catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
