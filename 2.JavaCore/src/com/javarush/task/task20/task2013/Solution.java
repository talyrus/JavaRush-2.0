package com.javarush.task.task20.task2013;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
//import java.util.ArrayList;
import java.util.List;
//import java.io.*;

/*
Externalizable Person
*/
public class Solution {
    public static class Person implements Externalizable {
        private String firstName;
        private String lastName;
        private int age;
        private Person mother;
        private Person father;
        private List<Person> children;

        public Person(){

        }

        public Person(String firstName, String lastName, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }

        public void setMother(Person mother) {
            this.mother = mother;
        }

        public void setFather(Person father) {
            this.father = father;
        }

        public void setChildren(List<Person> children) {
            this.children = children;
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(this.mother);
            out.writeObject(this.father);
            out.writeObject(this.firstName);
            out.writeObject(this.lastName);
            out.writeInt(this.age);
            out.writeObject(this.children);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            mother = (Person)in.readObject();
            father = (Person)in.readObject();
            firstName = (String) in.readObject();
            lastName = (String) in.readObject();
            age = in.readInt();
            children = (List<Person>)in.readObject();
        }
    }

    public static void main(String[] args) throws Exception {/*
        Person person = new Person("Toma", "poper", 34);
        Person mom = new Person("asdasd", "asdasd", 44);
        Person dad = new Person("asd", "Sasd", 59);
        Person child1 = new Person("asdasd", "asd", 8);
        Person child2 = new Person("asdasd", "asdasdasd", 3);
        person.setFather(dad);
        person.setMother(mom);
        List<Person> list = new ArrayList<>();
        list.add(child1);
        list.add(child2);
        person.setChildren(list);

        System.out.println(person.firstName+" "+person.lastName+" "+person.age+" "+person.father.firstName+" "+person.mother.firstName+" "+person.children);

        File file = new File("d:\\!Virus\\test.txt");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(person);
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        Person newPerson = (Person) ois.readObject();
        ois.close();

        System.out.println(newPerson.firstName+" "+newPerson.lastName+" "+newPerson.age+" "+newPerson.father.firstName+" "+newPerson.mother.firstName+" "+newPerson.children);*/
    }
}
