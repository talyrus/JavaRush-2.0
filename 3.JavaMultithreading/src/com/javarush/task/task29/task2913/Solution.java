package com.javarush.task.task29.task2913;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/* 
Замена рекурсии
*/

public class Solution {
	private static int numberA;
	private static int numberB;

	public static String getAllNumbersBetween(int a, int b) {
		String result = "";
		List<Integer> list = new ArrayList<>();
		if (a > b) {
			for (int i = b; i <= a; i++) {
				list.add(i);
			}
		} else {
			for (int i = a; i <= b; i++) {
				list.add(i);
			}
		}

		if (a > b) {
			Collections.reverse(list);
			StringBuilder stringBuilder = new StringBuilder();
			for (int i = 0; i < list.size(); i++) {
				stringBuilder.append(list.get(i));
				stringBuilder.append(" ");
				result = stringBuilder.toString();
			}
		} else {
			StringBuilder builder = new StringBuilder();
			for (int i = 0; i < list.size(); i++) {
				builder.append(list.get(i));
				builder.append(" ");
				result = builder.toString();
			}
		}
		return result.trim();
	}

	public static void main(String[] args) {
		Random random = new Random();
		numberA = random.nextInt() % 1_000;
		numberB = random.nextInt() % 10_000;
		System.out.println(getAllNumbersBetween(numberA, numberB));
		System.out.println(getAllNumbersBetween(numberB, numberA));
	}
}
