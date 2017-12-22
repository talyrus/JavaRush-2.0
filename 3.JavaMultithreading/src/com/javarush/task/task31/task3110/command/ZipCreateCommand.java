package com.javarush.task.task31.task3110.command;

import com.javarush.task.task31.task3110.ConsoleHelper;
import com.javarush.task.task31.task3110.ZipFileManager;
import com.javarush.task.task31.task3110.exception.PathIsNotFoundException;

import java.nio.file.Paths;

/**
 * Created by Taly on 21.12.2017.
 */
public class ZipCreateCommand extends ZipCommand { // Команда создания архива (упаковки файлов в архив)
	@Override
	public void execute() throws Exception {
		try {
			ConsoleHelper.writeMessage("Создание архива.");
			ZipFileManager zipFileManager = getZipFileManager();
			ConsoleHelper.writeMessage("Введите полное имя архивируемого файла или директории.");
			String zipPath = ConsoleHelper.readString();
			zipFileManager.createZip(Paths.get(zipPath));
			ConsoleHelper.writeMessage("Архив создан.");
		} catch (PathIsNotFoundException e) {
			ConsoleHelper.writeMessage("Вы неверно указали имя файла или директории.");
		}

	}


}
