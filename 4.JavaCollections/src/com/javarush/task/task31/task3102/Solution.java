package com.javarush.task.task31.task3102;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/* 
Находим все файлы
*/
public class Solution {
	public static List<String> getFileTree(String root) throws IOException {
		List<String> pathFiles = new ArrayList<>();

		Files.walk(Paths.get(root))
						.filter(Files::isRegularFile)
						.forEach(i -> pathFiles.add(i.toString()));

		return pathFiles;
	}

	public static void main(String[] args) throws IOException {
		System.out.println(getFileTree("d:\\Reports\\"));
	}
}
