package com.javarush.task.task31.task3112;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/* 
Загрузчик файлов
*/
public class Solution {

	public static void main(String[] args) throws IOException {
		Path passwords = downloadFile("https://javarush.ru/testdata/secretPasswords.txt", Paths.get("d:\\!Virus\\"));

		for (String line : Files.readAllLines(passwords)) {
			System.out.println(line);
		}
	}

	public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException {
		// implement this method
		URL url = new URL(urlString);       //создаем объект URL
		InputStream inputStream = url.openStream(); // создаем поток
		Path tempFile = Files.createTempFile("temp-", ".tmp");  // создаем временный файл
		Files.copy(inputStream, tempFile);      // скачиваем содержимое URL во временный файл
		String fileName = urlString.substring(urlString.lastIndexOf("/") + 1);  // получаем имя файла назначения
		Path target = downloadDirectory.resolve(fileName);      //  получаем абсолютный путь к файлу назначения
		Files.move(tempFile, target);   // копируем временный файл в файл назначения
		return target;
	}
}
