package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

import static java.nio.file.FileVisitResult.CONTINUE;

/* 
Что внутри папки?
*/
public class Solution {

	private static long countFolders = 0;
	private static long countFiles = 0;
	private static long countsize = 0;


	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String sourcePathStr = reader.readLine();   // считаем с консоли директорию
		reader.close(); // закроем reader

		Path sourcePath = Paths.get(sourcePathStr); // конвертируем строку в путь
		if (!Files.isDirectory(sourcePath)) { // если не директория
			System.out.println(sourcePath.toAbsolutePath().toString() + " - не папка"); // выведем сообщение
			return; // завершим работу
		}

		Files.walkFileTree(sourcePath, new Visitor()); // обход директории

		System.out.println("Всего папок - " + (countFolders - 1));
		System.out.println("Всего файлов - " + countFiles);
		System.out.println("Общий размер - " + countsize);

	}

	private static class Visitor extends SimpleFileVisitor<Path> {
		@Override
		public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
			countFolders += 1; // считаем каталоги
			return CONTINUE;    // продолжаем
		}

		@Override
		public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
			countFiles += 1;    // считаем файлы
			countsize = countsize + attrs.size(); // суммируем размер
			return CONTINUE;    // продолжаем
		}
	}
}
