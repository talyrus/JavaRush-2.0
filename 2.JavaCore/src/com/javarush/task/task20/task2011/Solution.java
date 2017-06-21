package com.javarush.task.task20.task2011;

import java.io.*;

/*
Externalizable для апартаментов
*/
public class Solution {

    public static class Apartment implements Externalizable {

        private String address;
        private int year;
        //Alt+Ins
        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(address);
            out.writeInt(year);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            address = (String) in.readObject();
            year =in.readInt() + 12;
        }

        /**
         * Mandatory public no-arg constructor.
         */
        public Apartment() { super(); }

        public Apartment(String adr, int y) {
            address = adr;
            year = y;
            System.out.println("Const " + address + " " + year);
        }

        /**
         * Prints out the fields. used for testing!
         */
        public String toString() {
            return("Address: " + address + "\n" + "Year: " + year);
        }
    }

    public static void main(String[] args) throws Exception {
    /*   Apartment apartment = new Apartment("KRD", 1970);
       ByteArrayOutputStream bos = new ByteArrayOutputStream();
       ObjectOutputStream oos = new ObjectOutputStream(bos);
       oos.writeObject(apartment);
       oos.flush();
       bos.close();
       oos.close();

       ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
       ObjectInputStream ois = new ObjectInputStream(bis);
       Apartment apartment1 = (Apartment) ois.readObject();
       System.out.println(apartment.address + " " + apartment.year);
       System.out.println("=============================");
       System.out.println(apartment1.address + " " + apartment1.year);
       bis.close();
       ois.close();*/
    }
}
