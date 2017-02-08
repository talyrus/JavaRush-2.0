package com.javarush.task.task01.task0132;

/* 
Сумма цифр трехзначного числа
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(sumDigitsInNumber(546));
    }

    public static int sumDigitsInNumber(int number) {
        //напишите тут ваш код
        int hundreds = number / 100;
        //System.out.println(hundreds);
        int decades = (number-hundreds * 100) / 10;
        //System.out.println(decades);
        int one = (number - hundreds * 100 - decades * 10) ;
        //System.out.println(one);
        return hundreds + decades + one;

    }
}