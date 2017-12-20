package com.javarush.task.task31.task3110;

import java.io.InputStream;
import java.nio.file.Path;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import static java.nio.file.Files.newInputStream;
import static java.nio.file.Files.newOutputStream;

/**
 * Created by Taly on 19.12.2017.
 */
public class ZipFileManager {
	private Path zipFile;

	public ZipFileManager(Path zipFile) {
		this.zipFile = zipFile;
	}

	public void createZip(Path source) throws Exception {
		try (ZipOutputStream zos = new ZipOutputStream(newOutputStream(zipFile))) { //создадим поток архива
			// и передадим полный путь конечного файла (назначение)
			ZipEntry entry = new ZipEntry(source.getFileName().toString()); //элемент архива передадим имя
			// архивируемого файла (источник)
			zos.putNextEntry(entry); // в поток архива добавим созданный элемент архива
			try (InputStream inputStream = newInputStream(source)) { // создадим поток добавления файла
				while (inputStream.available() > 0) {   // пока в потоке есть данные
					zos.write(inputStream.read());  // записываем их в поток архива
				}
				inputStream.close(); // закроем поток
			}
			zos.closeEntry(); // закроем элемент архива у потока архива
			zos.close(); // закроем поток архива
		}
	}
}
