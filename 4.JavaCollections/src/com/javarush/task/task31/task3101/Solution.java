package com.javarush.task.task31.task3101;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/*
Проход по дереву файлов
*/
public class Solution {
	public static TreeSet<File> fileList = new TreeSet<>();

	public static void main(String[] args) {
		File path = new File(args[0]);
		File resultFileAbsolutePath = new File(args[1]);
		File allFilesContent = new File(resultFileAbsolutePath.getParent() + "/allFilesContent.txt");
		FileUtils.renameFile(resultFileAbsolutePath, allFilesContent);

		try (FileOutputStream fos = new FileOutputStream(allFilesContent)) { // откроем поток
			recurSearch(path); // запустим обход директории
			TreeMap<String, File> fileResult = new TreeMap<>();
			for (File el : fileList)
				fileResult.put(el.getName(), el);
			for (Map.Entry<String, File> pair : fileResult.entrySet()) {
				BufferedReader reader = new BufferedReader(new FileReader(pair.getValue()));
				String result;
				while ((result = reader.readLine()) != null)
					fos.write((result + "\n").getBytes()); // запишем значения
				reader.close(); // закроем поток
			}
		} catch (IOException e) {

		}
	}

	public static void recurSearch(File file) { // рекурсивный обход
		if (file.isDirectory()) { //
			for (File el : file.listFiles()) { //  если это директория, то обходим все, что в ней
				recurSearch(el);
			}
		} else if (file.isFile()) { // если это файл
			if (file.length() <= 50) { // и его размер не более 50 байт
				fileList.add(file); // добавим его
			}
		}
	}
}
