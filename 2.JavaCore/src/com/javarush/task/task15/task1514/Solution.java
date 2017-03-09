package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики 1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();

    static {
        labels.put(1.1,"one");
        labels.put(2.1,"two");
        labels.put(3.1,"three");
        labels.put(4.1,"four");
        labels.put(5.1,"five");
    }


    public static void main(String[] args) {
        System.out.println(labels);
    }
}
