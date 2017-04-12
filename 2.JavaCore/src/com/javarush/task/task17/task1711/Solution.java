package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Locale;
/* 
CRUD 2
*/

public class Solution {
	public static volatile List<Person> allPeople = new ArrayList<Person>();

	static {
		allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
		allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
	}

	public static void main(String[] args) throws ParseException {
		//start here - начни тут
		SimpleDateFormat dateFormatIn = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
		SimpleDateFormat dateFormatOut = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
		switch (args[0]) {
			case "-c":
				synchronized (allPeople) {
					for (int i = 1; i < args.length; i += 3) {
						if (args[i + 1].equals("м")) {
							allPeople.add(Person.createMale(args[i], dateFormatIn.parse(args[i + 2])));
						} else if (args[i + 1].equals("ж")) {
							allPeople.add(Person.createFemale(args[i], dateFormatIn.parse(args[i + 2])));
						}
						System.out.println(allPeople.size() - 1);
					}
					break;
				}
			case "-u":
				synchronized (allPeople) {
					for (int i = 1; i < args.length; i += 4) {
						allPeople.get(Integer.parseInt(args[i])).setName(args[i + 1]);
						allPeople.get(Integer.parseInt(args[i])).setSex(args[i + 2].equals("м") ? Sex.MALE : Sex.FEMALE);
						allPeople.get(Integer.parseInt(args[i])).setBirthDay(dateFormatIn.parse(args[i + 3]));
					}
					break;
				}
			case "-d":
				synchronized (allPeople) {
					for (int i = 1; i < args.length; i++) {
						allPeople.get(Integer.parseInt(args[i])).setName(null);
						allPeople.get(Integer.parseInt(args[i])).setSex(null);
						allPeople.get(Integer.parseInt(args[i])).setBirthDay(null);

					}
					break;
				}
			case "-i":
				synchronized (allPeople) {
					for (int i = 1; i < args.length; i++) {
						System.out.print(allPeople.get(Integer.parseInt(args[i])).getName());
						System.out.print(" ");
						System.out.print(allPeople.get(Integer.parseInt(args[i])).getSex().equals(Sex.MALE) ? "м" : "ж");
						System.out.print(" ");
						System.out.println(dateFormatOut.format(allPeople.get(Integer.parseInt(args[i])).getBirthDay()));
					}
					break;
				}
		}
	      /*  for (Person p : allPeople) {
            System.out.println(p.getName() + " " + p.getSex() + " " + dateFormatOut.format(p.getBirthDay()));
        }*/
	}
}
