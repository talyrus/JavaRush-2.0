package com.javarush.task.task31.task3110;

import com.javarush.task.task31.task3110.command.ExitCommand;
import com.javarush.task.task31.task3110.exception.WrongZipFileException;

import java.io.IOException;

/**
 * Created by Taly on 19.12.2017.
 */
public class Archiver {

	public static void main(String[] args) {
		Operation operation = null;
		do {
			try {
				operation = askOperation();
				CommandExecutor.execute(operation);
			} catch (WrongZipFileException e) {
				ConsoleHelper.writeMessage("Вы не выбрали файл архива или выбрали неверный файл.");
			} catch (Exception e1) {
				ConsoleHelper.writeMessage("Произошла ошибка. Проверьте введенные данные.");
			}
		} while (operation != Operation.EXIT);

//		Scanner scanner = new Scanner(System.in);
//		System.out.println("Введите полный путь куда будем архивировать с указанием имени:");
//		ZipFileManager zipFile = new ZipFileManager(Paths.get(scanner.nextLine()));
//		System.out.println("Введите полный путь к файлу, который будет архивироваться:");
//		try {
//			zipFile.createZip(Paths.get(scanner.nextLine()));
//		} catch (Exception e) {
//
//		}
		ExitCommand exitCommand = new ExitCommand();
		try {
			exitCommand.execute();
		} catch (Exception e) {

		}

	}

	public static Operation askOperation() throws IOException {
		ConsoleHelper.writeMessage("");
		ConsoleHelper.writeMessage("Выберите операцию:\t");
		ConsoleHelper.writeMessage(Operation.CREATE.ordinal() + " - упаковать файлы в архив\t");
		ConsoleHelper.writeMessage(Operation.ADD.ordinal() + " - добавить файл в архив\t");
		ConsoleHelper.writeMessage(Operation.REMOVE.ordinal() + " - удалить файл из архива\t");
		ConsoleHelper.writeMessage(Operation.EXTRACT.ordinal() + " - распаковать архив\t");
		ConsoleHelper.writeMessage(Operation.CONTENT.ordinal() + " - просмотреть содержимое архива\t");
		ConsoleHelper.writeMessage(Operation.EXIT.ordinal() + " - выход\t");
		int select = ConsoleHelper.readInt();
		if (select == 0)
			return Operation.CREATE;
		if (select == 1)
			return Operation.ADD;
		if (select == 2)
			return Operation.REMOVE;
		if (select == 3)
			return Operation.EXTRACT;
		if (select == 4)
			return Operation.CONTENT;
		else
			return Operation.EXIT;
	}
}
