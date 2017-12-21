package com.javarush.task.task31.task3110;

import com.javarush.task.task31.task3110.exception.PathIsNotFoundException;

import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

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
		Path zipPath = zipFile.getParent(); // получим родительскую директорию файла
		if (Files.notExists(zipPath)) { // если указанной директории не существует
			Files.createDirectories(zipPath);   // создадим ее
		}
		try (ZipOutputStream zos = new ZipOutputStream(newOutputStream(zipFile))) { //создадим поток архива
			if (Files.isRegularFile(source)) {
				addNewZipEntry(zos, source.getParent(), source.getFileName());
			} else if (Files.isDirectory(source)) {
				FileManager fileManager = new FileManager(source);
				List<Path> fileNames = fileManager.getFileList();
				for (Path el : fileNames) {
					addNewZipEntry(zos, source, el);
				}
			} else
				throw new PathIsNotFoundException();


//			// и передадим полный путь конечного файла (назначение)
//			ZipEntry entry = new ZipEntry(source.getFileName().toString()); //элемент архива передадим имя
//			// архивируемого файла (источник)
//			zos.putNextEntry(entry); // в поток архива добавим созданный элемент архива
//			try (InputStream inputStream = newInputStream(source)) { // создадим поток добавления файла
//				while (inputStream.available() > 0) {   // пока в потоке есть данные
//					zos.write(inputStream.read());  // записываем их в поток архива
//				}
//				inputStream.close(); // закроем поток
//			}
//			zos.closeEntry(); // закроем элемент архива у потока архива
//			zos.close(); // закроем поток архива

		}
	}

	private void copyData(InputStream in, OutputStream out) throws Exception {
		while (in.available() > 0) {
			out.write(in.read());
		}
	}

	private void addNewZipEntry(ZipOutputStream zipOutputStream, Path filePath, Path fileName) throws Exception {
		Path fullPath = filePath.resolve(fileName);
		try (InputStream inputStream = Files.newInputStream(fullPath)) {
			ZipEntry entry = new ZipEntry(fileName.toString());

			zipOutputStream.putNextEntry(entry);

			copyData(inputStream, zipOutputStream);

			zipOutputStream.closeEntry();
		}
	}
}
