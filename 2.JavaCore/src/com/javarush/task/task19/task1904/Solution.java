package com.javarush.task.task19.task1904;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {
       /* try {
            // создадим объект класса Scanner и передадим в него путь к файлу с указанием кодировки
            Scanner scanner = new Scanner(new File("d:\\!Virus\\test.txt"), "windows-1251");
            PersonScannerAdapter psa = new PersonScannerAdapter(scanner);
            System.out.println(psa.read());
            psa.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }*/

    }
    //используем метод композиции и реализуем интерфейс
    public static class PersonScannerAdapter implements PersonScanner {
        private final Scanner fileScanner; // 1. используем объект класса, который надо адаптировать
        // 3. создадим конструктор адаптера, передав ему в качестве параметра
        // ссылку на объект адаптируемого класса
        PersonScannerAdapter (Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException { // 2. реализуем методы интерфейса
            Person person = null;
            if (fileScanner.hasNext()) {
                String stroka = fileScanner.nextLine(); // считаем сканеро очередную строку
                // заполним массив полученными значениями из строки (элементы строки разделяются пробелами)
                String[] element = stroka.split(" ");
                //из массива поэлементно получим требуемые значения
                String firstName = element[1];
                String middleName = element[2];
                String lastName = element[0];

                //используем календарь
                Calendar calendar = new GregorianCalendar(Integer.parseInt(element[5]), //переведем в Integer год
                        Integer.parseInt(element[4]) - 1, // месяц (-1, т.к. нумерация месяцев осуществляется с нуля - Январь - 0)
                        Integer.parseInt(element[3])); // день
                 // создадим объект класса Pesron, передав ему в требуемые параметры
                person = new Person(firstName, middleName, lastName, calendar.getTime());
            }
            return person;
        }

        @Override
        public void close() throws IOException { // 2. реализуем методы интерфейса
            fileScanner.close();
        }
    }
}
