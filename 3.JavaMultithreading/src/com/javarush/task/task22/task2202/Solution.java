package com.javarush.task.task22.task2202;

import java.io.IOException;

/*
Найти подстроку
*/
public class Solution {
	public static void main(String[] args) {
		System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
	}

	public static String getPartOfString(String string) {

		if (string == null || string.isEmpty()) {
			throw new TooShortStringException();
		}

		String str[] = string.split(" ");
		if (str.length<5) {
			throw new TooShortStringException();
		}
		return str[1] + " " + str[2] + " " + str[3] + " " + str[4];
	}

	public static class TooShortStringException extends RuntimeException {

	}
}
