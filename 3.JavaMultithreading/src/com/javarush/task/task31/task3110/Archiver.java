package com.javarush.task.task31.task3110;

import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Created by Taly on 19.12.2017.
 */
public class Archiver {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Введите полный путь куда будем архивировать с указанием имени:");
		ZipFileManager zipFile = new ZipFileManager(Paths.get(scanner.nextLine()));
		System.out.println("Введите полный путь к файлу, который будет архивироваться:");
		try {
			zipFile.createZip(Paths.get(scanner.nextLine()));
		} catch (Exception e) {

		}


	}
}
