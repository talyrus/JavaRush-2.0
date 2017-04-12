package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
	public static List<Person> allPeople = new ArrayList<Person>();

	static {
		allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
		allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
	}

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat dateFormatIn = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
		SimpleDateFormat dateFormatOut = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
		String id = args[0];
		switch (id) {
			case "-c":
				if (args[2].equals("м")) {
					allPeople.add(Person.createMale(args[1], dateFormatIn.parse(args[3])));
				} else if (args[2].equals("ж")) {
					allPeople.add(Person.createFemale(args[1], dateFormatIn.parse(args[3])));
				}
				System.out.println(allPeople.size() - 1);
				break;

			case "-u":
				allPeople.get(Integer.parseInt(args[1])).setName(args[2]);
				allPeople.get(Integer.parseInt(args[1])).setSex(args[3].equals("м") ? Sex.MALE : Sex.FEMALE);
				allPeople.get(Integer.parseInt(args[1])).setBirthDay(dateFormatIn.parse(args[4]));
				break;

			case "-d":
				allPeople.get(Integer.parseInt(args[1])).setName(null);
				allPeople.get(Integer.parseInt(args[1])).setSex(null);
				allPeople.get(Integer.parseInt(args[1])).setBirthDay(null);
				break;

			case "-i":
				System.out.print(allPeople.get(Integer.parseInt(args[1])).getName());
				System.out.print(" ");
				System.out.print(allPeople.get(Integer.parseInt(args[1])).getSex().equals(Sex.MALE) ? "м" : "ж");
				System.out.print(" ");
				System.out.print(dateFormatOut.format(allPeople.get(Integer.parseInt(args[1])).getBirthDay()));
		}
		// test
	   /* for (Person el: allPeople) {
            System.out.println(el.getName() + " " + el.getSex() + " " + el.getBirthDay());
        }*/
		// test
	}
}
