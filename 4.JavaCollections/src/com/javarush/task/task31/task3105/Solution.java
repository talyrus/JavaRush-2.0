package com.javarush.task.task31.task3105;

import java.io.*;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Добавление файла в архив
*/
public class Solution {
	public static void main(String[] args) throws IOException {
		String fileName = args[0]; // считаем параметры - путь и имя архивируемого файла
		String zipFileName = args[1]; // путь и имя файла архива
		File file = new File(fileName);

		Map<String, ByteArrayOutputStream> archFile = new HashMap<>();
		// создадим поток для считывания содержимого архива
		try (ZipInputStream zipReader = new ZipInputStream(new FileInputStream(zipFileName))) {
			ZipEntry zipEntry;
			while ((zipEntry = zipReader.getNextEntry()) != null) { // пока есть очередной объект в архиве
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				byte[] buffer = new byte[1024];
				int count = 0;
				while ((count = zipReader.read(buffer)) != -1) { // пока есть байты в потоке чтения
					baos.write(buffer, 0, count); // считать их в массив выходного потока
				}
				archFile.put(zipEntry.getName(), baos); // вставить считанные байты
			}
		}
		// создадит поток записи в архивный файл
		try (ZipOutputStream zipWriter = new ZipOutputStream(new FileOutputStream(zipFileName))) {
			// переберая считанные ранее объекты
			for (Map.Entry<String, ByteArrayOutputStream> pair : archFile.entrySet()) {
				System.out.println(pair.getKey() + " - " + file.getName());
				if (pair.getKey().substring(pair.getKey().lastIndexOf("/") + 1).equals(file.getName())) {
					System.out.println(pair.getKey().substring(pair.getKey().lastIndexOf("/") + 1) + " - " + file.getName());
					continue; // если файл в архиве уже существует - пропустить
				}
				zipWriter.putNextEntry(new ZipEntry(pair.getKey())); // добавить  объект в архив
				zipWriter.write(pair.getValue().toByteArray()); // записать содержимое
			}
			ZipEntry zipEntry = new ZipEntry("new/" + file.getName()); // создать директорию
			zipWriter.putNextEntry(zipEntry); // добавить объект в архив
			Files.copy(file.toPath(), zipWriter);   // записать данные в файл
		}


	}
}
