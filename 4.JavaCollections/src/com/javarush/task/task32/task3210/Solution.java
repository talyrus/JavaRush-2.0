package com.javarush.task.task32.task3210;

import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Используем RandomAccessFile
*/

public class Solution {
	public static void main(String... args) throws IOException {
		//File fileName = new File(args[0]);
		RandomAccessFile raf = new RandomAccessFile(args[0], "rw");
		int number = Integer.parseInt(args[1]);
		String text = args[2];


		//RandomAccessFile raf = new RandomAccessFile(fileName, "rw");

		byte[] buffer = new byte[text.length()];
		raf.seek(number);
		raf.read(buffer, 0, buffer.length);
		String convertLine = new String(buffer);
		String writeToFile;
		if (convertLine.equals(text)) {
			writeToFile = "true";
		} else {
			writeToFile = "false";
		}
		raf.seek(raf.length());
		raf.write(writeToFile.getBytes());
		raf.close();


	}
}
