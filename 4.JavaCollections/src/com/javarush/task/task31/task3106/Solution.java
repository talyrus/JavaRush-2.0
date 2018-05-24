package com.javarush.task.task31.task3106;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.zip.ZipInputStream;

/*
Разархивируем файл
*/
public class Solution {
	public static void main(String[] args) throws IOException {
		String resultFileName = args[0]; // считали имя файла
		int filePartCount = args.length - 1; // получили количество частей
		String[] fileNamePart = new String[filePartCount]; // создали строковый массив требуемого размера
		for (int i = 0; i < filePartCount; i++) {
			fileNamePart[i] = args[i + 1]; // запишем в массив строки
		}
		Arrays.sort(fileNamePart); // отсортируем массив

		List<FileInputStream> fileInputStreamList = new ArrayList<>(); // создадим параметризованный список
		for (int i = 0; i < filePartCount; i++) { // считаем его содержимое
			fileInputStreamList.add(new FileInputStream(fileNamePart[i]));
		}
		// соединим вместе все экземпляры fileInputStreamList
		SequenceInputStream sequenceInputStream = new SequenceInputStream(Collections.enumeration(fileInputStreamList));
		ZipInputStream zipInputStream = new ZipInputStream(sequenceInputStream); // создадим поток чтения архивов
		FileOutputStream fileOutputStream = new FileOutputStream(resultFileName); // создадим поток вывода данных в файл
		byte[] buffer = new byte[1024 * 1024]; // создадим байтовый массив
		while (zipInputStream.getNextEntry() != null) { // пока в потоке чтения есть объекты
			int count;
			while ((count = zipInputStream.read(buffer)) != -1) {  // получим последний байт в буфере
				fileOutputStream.write(buffer, 0, count); // запишем в файл буфер с позиции 0 по последнюю
			}
		}
		// закроем потоки
		sequenceInputStream.close();
		zipInputStream.close();
		fileOutputStream.close();
	}
}
