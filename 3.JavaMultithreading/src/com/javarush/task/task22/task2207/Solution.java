package com.javarush.task.task22.task2207;

import java.io.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/* 
Обращенные слова
*/
public class Solution {
	public static List<Pair> result = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String text = reader.readLine();
		BufferedReader readerFile = new BufferedReader(new FileReader(text));
		StringBuilder sb = new StringBuilder();
		while (readerFile.ready()) {
			sb.append(readerFile.readLine() + " ");
		}
		reader.close();
		readerFile.close();

		String[] strArr = sb.toString().split("\\s+");

		HashSet hashSet = new HashSet<>();
		for (int i = 0; i < strArr.length; i++) {
			if (hashSet.contains(i)) {
				continue;
			}
			for (int j = i + 1; j < strArr.length; j++) {
				String strRev = new StringBuilder(strArr[j]).reverse().toString();
				if (strRev.equals(strArr[i])) {
					Pair pair = new Pair();
					pair.first = strRev;
					pair.second = strArr[j];
					result.add(pair);
					hashSet.add(j);
					break;
				}
			}
		}
		for (Pair pair : result) {
			System.out.println(pair);
		}
	}

	public static class Pair {
		String first;
		String second;

		@Override
		public boolean equals(Object o) {
			if (this == o)
				return true;
			if (o == null || getClass() != o.getClass())
				return false;

			Pair pair = (Pair) o;

			if (first != null ? !first.equals(pair.first) : pair.first != null)
				return false;
			return second != null ? second.equals(pair.second) : pair.second == null;
		}

		@Override
		public int hashCode() {
			int result = first != null ? first.hashCode() : 0;
			result = 31 * result + (second != null ? second.hashCode() : 0);
			return result;
		}

		@Override
		public String toString() {
			return first == null && second == null ? "" :
					first == null && second != null ? second :
							second == null && first != null ? first :
									first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

		}
	}
}
