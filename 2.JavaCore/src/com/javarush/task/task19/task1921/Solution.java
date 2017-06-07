package com.javarush.task.task19.task1921;

import javax.xml.crypto.Data;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        while (reader.ready()) {
            String string = reader.readLine();
            String name  = string.split("\\d")[0];
            String date = string.split("^\\D+\\s")[1];
            Date birthday = null;
            try {
                birthday = new SimpleDateFormat("dd MM yyyy").parse(date);
            } catch (ParseException ex) {

            }
            PEOPLE.add(new Person(name.trim(), birthday));
        }
        reader.close();
    }
}
