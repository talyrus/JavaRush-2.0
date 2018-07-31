package com.javarush.task.task36.task3605;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/* 
Использование TreeSet
*/
public class Solution {
	public static void main(String[] args) throws IOException {
		FileReader file = new FileReader(args[0]);
		BufferedReader reader = new BufferedReader(file);
		Set<Character> treeSet = new TreeSet<>();
		while (reader.ready()) {
			String str = reader.readLine().toLowerCase().replaceAll("[^\\p{Alpha}]", "");
			for (int i = 0; i < str.length(); i++) {
				treeSet.add(str.charAt(i));
			}
		}
		Iterator<Character> iterator = treeSet.iterator();
		int n = treeSet.size() < 5 ? treeSet.size() : 5;

		for (int i = 0; i < n; i++) {
			System.out.print((iterator.next()));
		}
		file.close();
		reader.close();
	}
}
