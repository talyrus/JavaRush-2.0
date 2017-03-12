package com.javarush.task.task15.task1531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/* 
Факториал
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(reader.readLine());
        reader.close();

        System.out.println(factorial(input));
    }

    public static String factorial(int n) {
        //add your code here
        BigInteger result = BigInteger.valueOf(1);
        if (n < 0) {
            result =  BigInteger.valueOf(0);
        } else {
            for (int i = 1; i <= n ; i++) {
                result = result.multiply(BigInteger.valueOf(i));
            }
        }
        return String.valueOf(result) ;
    }
}
