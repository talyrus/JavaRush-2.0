package com.javarush.task.task32.task3209;

import javax.swing.filechooser.FileFilter;
import java.io.File;

/**
 * Created by Taly on 18.01.2018.
 */
public class HTMLFileFilter extends FileFilter { //Класс для открытия или сохранения файла
	@Override
	public boolean accept(File file) {
		if (file.isDirectory()) { // если переданный файл - директория, вернуть true
			return true;
		} else if (!file.isDirectory()) { // если Не директория
			String name = file.getName().toLowerCase(); // получим имя без учета регистра
			return name.endsWith(".htm") || name.endsWith(".html"); // вернем true при нужных типах файлов
		}
		return false; //иначе вернем false
	}

	@Override
	public String getDescription() {
		return "HTML и HTM файлы"; //сформируем описание выбираемых типов файлов
	}
}
