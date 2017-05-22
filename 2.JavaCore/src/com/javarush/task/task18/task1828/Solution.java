package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader readerConsole = new BufferedReader(new InputStreamReader(System.in));
		String file = readerConsole.readLine(); //считаем название файла и путь к нему с консоли
		readerConsole.close();

		String line;

		BufferedReader readerFile = new BufferedReader(new FileReader(file));
		ArrayList<String> list = new ArrayList<String>();

		while ((line = readerFile.readLine()) != null) {
			list.add(line); //считаем содержимое файла в список
		}
		readerFile.close();

		for (int i = 0; i < list.size(); i++) { //перебираем список
			String currId = list.get(i).substring(0, 8).trim(); //получаем id текущей строки
			if (args[1].equals(currId)) { //если первый параметр (id) равен id текущей строки
				if (args[0].equals("-u")) { // и если нулевой параметр равен -u
					String price = args[args.length - 2]; //получим все аргументы
					String quantity = args[args.length - 1];
					StringBuilder productName = new StringBuilder();
					productName.append(args[2]);
					for (int j = 3; j < args.length - 2; j++) {
						productName.append(" " + args[j]);
					}
					//соберем полученные аргументы в одну строку
					String data = String.format("%-8.8s%-30.30s%-8.8s%-4.4s", args[1], productName, price, quantity);
					list.set(i, data); // заменим текущую строку переданными аргументами
				}
				if (args[0].equals("-d")) { // если передан параметр -d
					list.remove(i); // удалим текущую строку
				}
				i = list.size();
			}
		}
		//запишем новый получившийся список в файл
		BufferedWriter fileWriter = new BufferedWriter(new FileWriter(file));
		for (int i = 0; i < list.size(); i++) {
			fileWriter.write(list.get(i));
			if (i < list.size() - 1)
				fileWriter.write(System.lineSeparator());
		}
		fileWriter.close();
	}
}

