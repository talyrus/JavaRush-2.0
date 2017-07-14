package com.javarush.task.task22.task2212;

/* 
Проверка номера телефона
*/
public class Solution {
	public static boolean checkTelNumber(String telNumber) {
		// проверим, чтобы переданный параметр содержал данные
		if (telNumber == null)
			return false;
		if (telNumber.isEmpty())
			return false;
		//получим количество цифр в параметре, удалив все нецифры
		int digits = telNumber.replaceAll("\\D", "").length();
		// если первый символ + и количество цифр 12   или   если первый символ не + и количество цифр 10
		if ((telNumber.charAt(0) == '+' && digits == 12) || (telNumber.charAt(0) != '+' && digits == 10)) {
			return telNumber.matches("(\\+\\d+)?\\d*(\\(\\d{3}\\))?\\d+(-?\\d+){0,2}");
		} else
			return false;
	}

	public static void main(String[] args) {
		System.out.println(checkTelNumber("+380501234567")); //true
		System.out.println(checkTelNumber("+38(050)1234567"));//true
		System.out.println(checkTelNumber("+38050123-45-67"));//true
		System.out.println(checkTelNumber("050123-4567"));//true
		System.out.println(checkTelNumber("+38)050(1234567"));//false
		System.out.println(checkTelNumber("+38(050)1-23-45-6-7"));//false
		System.out.println(checkTelNumber("050ххх4567"));//false
		System.out.println(checkTelNumber("050123456"));//false
		System.out.println(checkTelNumber("(0)501234567"));//false

	}
}
