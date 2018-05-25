package com.javarush.task.task20.task2028;

import java.util.List;

public class Solution {
    public static void main(String[] args) {
        List<String> list = new CustomTree();

        for (int i = 1; i < 16; i++) {
            list.add(String.valueOf(i));
        }

        System.out.println("List size is " + list.size());
        System.out.println("Expected parent is 3, actual parent is " + ((CustomTree) list).getParent("8"));
        System.out.println("Expected parent is null, actual parent is " + ((CustomTree) list).getParent("20"));

        list.remove("3");
        System.out.println("Expected parent is null, actual parent is " + ((CustomTree) list).getParent("8"));

        list.add("16");
        System.out.println("Expected parent is 9, actual parent is " + ((CustomTree) list).getParent("16"));

        list.remove("4");
        list.remove("5");
        list.remove("6");
        System.out.println("Expected true, actual " + list.add("20"));
        System.out.println("Expected parent is 1, actual parent is " + ((CustomTree) list).getParent("20"));
    }
}
