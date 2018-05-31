package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* 
Генератор паролей
*/
public class Solution {

	public static void main(String[] args) {
		ByteArrayOutputStream password = getPassword();
		System.out.println(password.toString());
	}

	public static ByteArrayOutputStream getPassword() {
		String sourceNum = "0123456789";
		String sourceLaters = "qwertyuioplkjhgfdsazxcvbnm";

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		StringBuffer pass = new StringBuffer();
		for (int i = 0; i < 3; i++) {
			pass.append(sourceLaters.charAt((int) (Math.random() * sourceLaters.length())));
		}
		for (int i = 0; i < 2; i++) {
			pass.append(sourceNum.charAt((int) (Math.random() * sourceNum.length())));
		}
		for (int i = 0; i < 3; i++) {
			pass.append(sourceLaters.toUpperCase().charAt((int) (Math.random() * sourceLaters.length())));
		}
		try {
			baos.write(pass.toString().getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return baos;
	}


}
