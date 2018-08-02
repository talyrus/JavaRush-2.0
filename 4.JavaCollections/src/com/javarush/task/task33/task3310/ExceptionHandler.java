package com.javarush.task.task33.task3310;

/**
 * Created by Taly on 02.08.2018.
 */
public class ExceptionHandler {
	public static void log(Exception e) { //будет выводить краткое описание исключения
		Helper.printMessage(e.getMessage());
	}
}
