package com.javarush.task.task20.task2020;

import java.io.*;
import java.util.logging.Logger;

/* 
Сериализация человека
*/
public class Solution {

    public static class Person implements Serializable {
        String firstName;
        String lastName;
        transient String fullName;
        transient final String greetingString;
        String country;
        Sex sex;
        transient PrintStream outputStream;
        transient Logger logger;

        Person(String firstName, String lastName, String country, Sex sex) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.fullName = String.format("%s, %s", lastName, firstName);
            this.greetingString = "Hello, ";
            this.country = country;
            this.sex = sex;
            this.outputStream = System.out;
            this.logger = Logger.getLogger(String.valueOf(Person.class));
        }
    }

    enum Sex {
        MALE,
        FEMALE
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Person person = new Person("Adam", "IOV", "Eden", Sex.MALE);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("d:\\!Virus\\test.txt"));
        oos.writeObject(person);

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("d:\\!Virus\\test.txt"));
        Person recover_person = (Person) ois.readObject();
        System.out.println(person.firstName + " " + person.lastName + " " + person.country + " " + person.sex);
        System.out.println(recover_person.firstName + " " + recover_person.lastName + " " + recover_person.country + " " + recover_person.sex);
    }
}
