package com.javarush.task.task20.task2009;

import java.io.*;

/*
Как сериализовать static?
*/
public class Solution {
    public static class ClassWithStatic implements Serializable {
        public static String staticString = "it's test static string";
        public int i;
        public int j;
	    //Для сериализации статического поля, нужно вписать его в файл вручную.
	    //Метод для его сериализации
        public static void serializeStatic(ObjectOutputStream oos) throws IOException {
	        oos.writeUTF(staticString);
        }
	    //Десереализация.
        public static void deserializeStatic(ObjectInputStream ois) throws IOException {
	        //Читаем байты и переводим их в String.
	        staticString = ois.readUTF();
        }
    }

    public static void main(String[] args) throws Exception {
        ClassWithStatic cws = new ClassWithStatic();
        String path = "d:\\!Virus\\test.txt";
        cws.i = 111;
        cws.j = 222;

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
        ClassWithStatic.serializeStatic(oos);
        oos.writeObject(cws);
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
        ClassWithStatic.deserializeStatic(ois);
        ClassWithStatic cws2 = (ClassWithStatic)ois.readObject();
        ois.close();

        System.out.println(cws2.i + " " + cws2.j + " " + cws2.toString());
    }
}
