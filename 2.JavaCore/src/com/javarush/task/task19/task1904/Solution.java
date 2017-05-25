package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner {
        private final Scanner fileScanner;
        PersonScannerAdapter (Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {
            Person person = null;
            if (fileScanner.hasNext()) {
                String stroka = fileScanner.nextLine();
                String[] element = stroka.split(" ");
                String firstName = element[1];
                String middleName = element[2];
                String lastName = element[0];

                Calendar calendar = new GregorianCalendar(Integer.parseInt(element[5]),
                        Integer.parseInt(element[4]) - 1, Integer.parseInt(element[3]));

                person = new Person(firstName, middleName, lastName, calendar.getTime());
            }

            return person;
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
