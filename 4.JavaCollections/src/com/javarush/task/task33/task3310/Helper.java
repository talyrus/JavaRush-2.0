package com.javarush.task.task33.task3310;


import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * Created by Taly on 02.08.2018.
 */
public class Helper {
	public static String generateRandomString() { //будет генерировать случайную строку
		SecureRandom secureRandom = new SecureRandom();
		BigInteger bigInteger = new BigInteger(130, secureRandom);
		return bigInteger.toString(36);
	}

	public static void printMessage(String message) { //должен выводить переданный текст в консоль
		System.out.println(message);
	}
}
