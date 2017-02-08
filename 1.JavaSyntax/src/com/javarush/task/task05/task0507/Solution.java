package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;
        double number = 0;
        double sum = 0;
        while (true)
        {
            int num = Integer.parseInt(reader.readLine());
            if (num == -1) {
                break;
            }
            else {
                number += num;
                count++;
            }
            sum = number / count;
        }
        System.out.println(sum);
    }
}

