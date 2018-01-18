package com.javarush.task.task32.task3209;

import javax.swing.filechooser.FileFilter;
import java.io.File;

/**
 * Created by Taly on 18.01.2018.
 */
public class HTMLFileFilter extends FileFilter { //Класс для открытия или сохранения файла
	@Override
	public boolean accept(File file) {
		if (file.isDirectory()) {
			return true;
		}
		else if (!file.isDirectory()) {
			String name = file.getName().toLowerCase();
			return name.endsWith(".htm") || name.endsWith(".html");
		}
		return false;
	}

	@Override
	public String getDescription() {
		return "HTML и HTM файлы";
	}
}
