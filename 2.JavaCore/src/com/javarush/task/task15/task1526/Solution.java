package com.javarush.task.task15.task1526;

/* 
Дебаг, дебаг, и еще раз дебаг
*/

public class Solution {
    public static void main(String[] args) {
        new B(6); // 1
    }

    public static class A {
        private int f1 = 7; // 3

        public A(int f1) {
            this.f1 = f1; // 4
            initialize(); // 5
        }

        private void initialize() { //replace protected
            System.out.println(f1); // 6
        }
    }

    public static class B extends A {
        protected int f1 = 3;   // 7

        public B(int f1) {
            super(f1); // 2
            this.f1 += f1; // 8
            initialize(); // 9
        }

        protected void initialize() {
            System.out.println(f1); // 10
        }
    }
}
