package com.javarush.task.task31.task3110.command;

import com.javarush.task.task31.task3110.ConsoleHelper;
import com.javarush.task.task31.task3110.FileProperties;
import com.javarush.task.task31.task3110.ZipFileManager;

import java.util.List;

/**
 * Created by Taly on 21.12.2017.
 */
public class ZipContentCommand extends ZipCommand { //Команда просмотра содержимого архива
	@Override
	public void execute() throws Exception {
		ConsoleHelper.writeMessage("Просмотр содержимого архива.");
		ZipFileManager zfm = getZipFileManager();
		ConsoleHelper.writeMessage("Содержимое архива:");
		List<FileProperties> files = zfm.getFilesList();
		for (FileProperties file : files) {
			ConsoleHelper.writeMessage(file.toString());
		}
		ConsoleHelper.writeMessage("Содержимое архива прочитано.");
	}
}
