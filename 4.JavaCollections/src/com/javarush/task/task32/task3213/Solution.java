package com.javarush.task.task32.task3213;

import java.io.IOException;
import java.io.StringReader;

/* 
Шифр Цезаря
*/

public class Solution {
	public static void main(String[] args) throws IOException {
		StringReader reader = new StringReader("Khoor#Dpljr#&C,₷B'3");
		System.out.println(decode(reader, -3));  //Hello Amigo #@)₴?$0
	}

	public static String decode(StringReader reader, int key) throws IOException {
		int simbol;
		StringBuffer buffer = new StringBuffer();
		try {
			while ((simbol = reader.read()) != -1) { //считаем числовое представление символа
				buffer.append(Character.toString((char) (simbol + key))); // прибавим к нему значение ключа и добавим в буфер
			}
		} catch (Exception e) {
			return new String();
		}
		return buffer.toString();
	}
}
