package com.javarush.task.task31.task3110.command;

import com.javarush.task.task31.task3110.ConsoleHelper;
import com.javarush.task.task31.task3110.ZipFileManager;

import java.nio.file.Paths;

/**
 * Created by Taly on 21.12.2017.
 */
public abstract class ZipCommand implements Command {
	// создадим базовый класс, имеющий общий функционал для классов,
	// непосредственно работающих с архивом.
	// Объекты класса создавать не будем, поэтому сделаем  его абстрактным
	public ZipFileManager getZipFileManager() throws Exception {
		ConsoleHelper.writeMessage("Введите полный путь к создаваемому файлу архива с указанием имени файла."); //запросим путь
		String path = ConsoleHelper.readString(); // считаем введенный в консоли путь
		return new ZipFileManager(Paths.get(path)); // преобразуем String в Path и создадим объект
	}
}
