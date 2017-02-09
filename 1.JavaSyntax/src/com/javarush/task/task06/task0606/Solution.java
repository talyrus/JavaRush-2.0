package com.javarush.task.task06.task0606;

import java.io.*;

/* 
Чётные и нечётные циферки
*/

public class Solution {

    public static int even;
    public static int odd;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String num = reader.readLine();
        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(i) % 2 == 0) {
                //System.out.println(num + " is even");
                even++;
            } else {
                //System.out.println(num + " is odd");
                odd++;
            }
        }
        System.out.println("Even: " + even + " Odd: " + odd);
    }
}
