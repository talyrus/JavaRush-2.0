package com.javarush.task.task16.task1623;

/* 
Рекурсивное создание нитей
*/

public class Solution {
    static int count = 15;
    static volatile int countCreatedThreads = 0;

    public static void main(String[] args) {
        for (int i = 0; i < count; i++) {
            System.out.println(new GenerateThread());
        }
    }

    public static class GenerateThread extends Thread {
        Thread thread = new Thread();

        public GenerateThread() {
            super(String.valueOf(++countCreatedThreads));
            start();
        }

        @Override
        public String toString() {
            return this.getName() + " created";
        }

        @Override
        public void run() {
            if (count > countCreatedThreads) {
                GenerateThread generateThread = new GenerateThread();
                System.out.println(generateThread);
            }
        }
    }
}
