package com.javarush.task.task30.task3009;

/*
Палиндром?
*/

import java.util.HashSet;
import java.util.Set;

public class Solution {
	public static void main(String[] args) {
		System.out.println(getRadix("112"));        //expected output: [3, 27, 13, 15]
		System.out.println(getRadix("123"));        //expected output: [6]
		System.out.println(getRadix("5321"));       //expected output: []
		System.out.println(getRadix("1A"));         //expected output: []
	}

	private static Set<Integer> getRadix(String number) {
		Set<Integer> set = new HashSet<>();
		try {
			int temp = Integer.parseInt(number);
			for (int i = 2; i <= 36; i++) {
				String num = Integer.toString(temp, i);
				StringBuilder stringBuilder = new StringBuilder();
				String first, last;
				if (num.length() % 2 == 0) {
					first = num.substring(0, num.length() / 2);
					last = stringBuilder.append(num.substring(num.length() / 2)).reverse().toString();
					if (first.equals(last)) {
						set.add(i);
					}
				} else {
					first = num.substring(0, num.length() / 2);
					last = stringBuilder.append(num.substring(num.length() / 2 + 1)).reverse().toString();
					if (first.equals(last)) {
						set.add(i);
					}
				}
			}
		} catch (NumberFormatException e) {

		}
		return set;
	}

}
