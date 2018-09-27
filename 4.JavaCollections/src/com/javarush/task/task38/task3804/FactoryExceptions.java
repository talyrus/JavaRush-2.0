package com.javarush.task.task38.task3804;

/**
 * Created by Taly on 27.09.2018.
 */
public class FactoryExceptions {
	public static Throwable getException(Enum error) {
		if (error == null) {
			return new IllegalArgumentException();
		}
		String message = error.name().charAt(0) +
						error.name().substring(1).toLowerCase().replace("_", " ");
		if (error instanceof ExceptionApplicationMessage) {
			return new Exception(message);
		}
		if (error instanceof ExceptionDBMessage) {
			return new RuntimeException(message);
		}
		if (error instanceof ExceptionUserMessage) {
			return new Error(message);
		}
		return new IllegalArgumentException();
	}
}
