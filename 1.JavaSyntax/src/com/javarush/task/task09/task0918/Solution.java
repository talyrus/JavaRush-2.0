package com.javarush.task.task09.task0918;

/* 
Все свои, даже исключения
*/

import java.sql.SQLDataException;

public class Solution {
    public static void main(String[] args) {
    }
    
    static class MyException extends NullPointerException{
    }

    static class MyException2 extends ArithmeticException{
    }

    static class MyException3 extends SQLDataException {
    }

    static class MyException4 extends ClassNotFoundException{
    }
}

