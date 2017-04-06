package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        threads.add(new Thread_1());
        threads.add(new Thread_2());
        threads.add(new Thread_3());
        threads.add(new Thread_4());
        threads.add(new Thread_5());
    }

    public static class Thread_1 extends Thread {
        @Override
        public void run() {
            while (true) { //бесконечное выполнение нити

            }
        }
    }

    public static void sleep() { // метод для остановки нити на 200 мс
        try {
            Thread.sleep(200);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public static class Thread_2 extends Thread {
        @Override
        public void run() {
            try {
                while (!isInterrupted()) {

                }
                throw new InterruptedException();
            } catch (InterruptedException ex) { // при возникновении исключения выводим сообщение
                System.out.println("InterruptedException");
            }
        }
    }

    public static class Thread_3 extends Thread {
        @Override
        public void run() {
            try {
                while (true) {  // вывод сообщения каждые полсекунды
                    System.out.println("Ура");
                    Thread.sleep(500);
                }
            }catch (InterruptedException ex) {

            }
        }
    }

    public static class Thread_4 extends Thread implements Message{
        @Override
        public void showWarning() { // при вызове метода
            this.interrupt();       // остановить нить
            try {
                this.join();
            } catch (Exception ex) {

            }
        }

        @Override
        public void run() {
            Thread current = Thread.currentThread(); // создаем ссылочную переменную на текущую нить
            while (!current.isInterrupted()); // нить работает, пока нет прерывания
            {

            }
        }
    }

    public static class Thread_5 extends Thread {

        @Override
        public void run()
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int sum = 0;
            try{
                while (!isInterrupted()) //пока нет прерывания
                {
                    String s = reader.readLine(); // считываем строку из консоли
                    if (s.equals("N")) this.interrupt(); // если N, то ставим флаг прерывания для текущей нити
                    else
                    {
                        int integer = Integer.parseInt(s); // иначе конвертируем считанное строковое значение в число
                        sum += integer; // и суммируем
                    }
                }
                throw new InterruptedException(); // при прерывании бросаем исключение
            }catch (IOException e)
            {

            }catch (InterruptedException e)
            {
                System.out.println(sum); // и выводим сумму чисел
            }
        }
    }

    public static void main(String[] args) {
        Thread thread_2 = threads.get(1); // объявляем ссылочную переменную типа Thread и присваиваем ей ссылку на 2 нить
        thread_2.start(); // запускаем метод run второй нити
        sleep();    // остановим нить на 200 мс
        thread_2.interrupt(); // установим флаг прерывания

        Thread thread_4 = threads.get(3); // объявляем ссылочную переменную типа Thread и присваиваем ей ссылку на 4 нить
        Message msg = (Message) thread_4;  // объявляем ссылочную переменную типа Message (через реализацию интерфейса)
        thread_4.start(); //запускаем метод run четвертой нити
        sleep(); // остановим нить на 200 мс
        msg.showWarning(); //вызываем метод showWarning()
        System.out.println(thread_4.isAlive()); // выводим сообщение о статусе четвертой нити
    }

}
