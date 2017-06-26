package com.javarush.task.task20.task2025;

import java.util.List;

/*
Алгоритмы-числа
*/
public class Solution {
    public static long[] getNumbers(long N) {
        List<Long> list = ArmstrongNumbersMultiSetLongOpt.generate((int) (Math.log10(N)));
        long[] result = new long[list.size()];
        for (int i = 0; i < list.size(); i++) result[i] = list.get(i);
        return result;
    }

    public static void main(String[] args) {

    }
}
