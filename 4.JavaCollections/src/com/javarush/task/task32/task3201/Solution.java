package com.javarush.task.task32.task3201;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/*
Запись в существующий файл
*/
public class Solution {
	public static void main(String... args) throws IOException {
		File fileName = new File(args[0]);
		int number = Integer.parseInt(args[1]);
		String text = args[2];

		RandomAccessFile raf = new RandomAccessFile(fileName, "rw");

		if (text.length() < number) {
			raf.seek(raf.length());
		} else {
			raf.seek(number);
		}
		raf.write(text.getBytes());
		raf.close();
	}
}
