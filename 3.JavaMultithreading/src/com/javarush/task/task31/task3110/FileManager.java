package com.javarush.task.task31.task3110;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Taly on 21.12.2017.
 */
public class FileManager {
	private Path rootPath;
	private List<Path> fileList;

	public List<Path> getFileList() {
		return fileList;
	}

	private void collectFileList(Path path) throws IOException {
		if (Files.isRegularFile(path)) { //если переданный путь является файлом
			fileList.add(rootPath.relativize(path)); // получить его относительный путь и добавить в список
		}
		if (Files.isDirectory(path)) { // если переданный путь является директорией
			DirectoryStream<Path> stream = null;
			try {
				stream = Files.newDirectoryStream(path); // откроем поток
				for (Path p : stream) { // пройдемся по всем элементам
					collectFileList(p); // и добавим их в список
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				stream.close();
			}
		}
	}

	public FileManager(Path rootPath) throws IOException {
		this.rootPath = rootPath;
		fileList = new ArrayList<>();
		collectFileList(rootPath);
	}
}
