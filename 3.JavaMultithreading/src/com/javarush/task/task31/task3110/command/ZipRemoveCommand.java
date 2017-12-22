package com.javarush.task.task31.task3110.command;

import com.javarush.task.task31.task3110.ConsoleHelper;
import com.javarush.task.task31.task3110.ZipFileManager;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Taly on 21.12.2017.
 */
public class ZipRemoveCommand extends ZipCommand { //Команда удаления файла из архива
	@Override
	public void execute() throws Exception {
		ConsoleHelper.writeMessage("Удаление файла из архива");
		ZipFileManager zfm = getZipFileManager();
		ConsoleHelper.writeMessage("Введите полный путь удаляемого файла в архиве");
		Path delFile = Paths.get(ConsoleHelper.readString());
		zfm.removeFile(delFile);
		ConsoleHelper.writeMessage("Удаление файла из архива завершено.");
	}
}
