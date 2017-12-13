package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.Connection;
import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;

import java.io.IOException;

/**
 * Created by Taly on 13.12.2017.
 */
public class Client {
	// обращение из класса потомков и запрет обращения из других классов вне пакета
	protected Connection connection;
	// если клиент соединился с сервером - true. Исключим использование кэшированного значения поля
	private volatile boolean clientConnected = false;

	//поток для установки сокетного соединения и чтения сообщений сервера
	public class SocketThread extends Thread {

	}

	protected String getServerAddress() {
		System.out.println("Введите адрес сервера: ");
		String address = ConsoleHelper.readString();
		return address;
	}

	protected int getServerPort() {
		System.out.println("Введите порт сервера: ");
		int port = ConsoleHelper.readInt();
		return port;
	}

	protected String getUserName() {
		System.out.println("Введите имя пользователя: ");
		String userName = ConsoleHelper.readString();
		return userName;
	}

	protected boolean shouldSendTextFromConsole() {
		return true;
	}

	protected SocketThread getSocketThread() {
		return new SocketThread();
	}

	protected void sendTextMessage(String text) {
		try {
			connection.send(new Message(MessageType.TEXT, text));
		} catch (IOException e) {
			ConsoleHelper.writeMessage("Ошибка отправки сообщения!");
			clientConnected = false;
		}
	}
}
