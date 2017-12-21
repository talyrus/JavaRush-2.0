package com.javarush.task.task31.task3110;

import com.javarush.task.task31.task3110.command.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Taly on 21.12.2017.
 */
public class CommandExecutor {
	private static final Map<Operation, Command> allKnownCommandsMap = new HashMap<>();

	static { // инициализируем карту
		allKnownCommandsMap.put(Operation.ADD, new ZipAddCommand());
		allKnownCommandsMap.put(Operation.CONTENT, new ZipContentCommand());
		allKnownCommandsMap.put(Operation.CREATE, new ZipCreateCommand());
		allKnownCommandsMap.put(Operation.EXTRACT, new ZipExtractCommand());
		allKnownCommandsMap.put(Operation.REMOVE, new ZipRemoveCommand());
		allKnownCommandsMap.put(Operation.EXIT, new ExitCommand());
	}

	private CommandExecutor() { // запрет явного вызова конструктора

	}

	public static void execute(Operation operation) throws Exception {
		allKnownCommandsMap.get(operation).execute(); //находим нужную команду и запускаем у нее метод execute()
	}
}
