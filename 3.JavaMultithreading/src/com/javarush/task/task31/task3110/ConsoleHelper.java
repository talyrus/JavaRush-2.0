package com.javarush.task.task31.task3110;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Taly on 20.12.2017.
 */
public class ConsoleHelper {
	public static void writeMessage(String message) {
		System.out.println(message); // выводим полученный message в консоль
	}

	public static String readString() throws IOException {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();  // возвращаем считанный с консоли текст
	}

	public static int readInt() throws IOException {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextInt(); // возвращаем считанное с консоли число
	}
}
