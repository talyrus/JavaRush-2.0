package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.Connection;
import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;

import java.io.IOException;
import java.net.Socket;

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
		protected void processIncomingMessage(String message) {
			ConsoleHelper.writeMessage(message);
		}

		protected void informAboutAddingNewUser(String userName) {
			ConsoleHelper.writeMessage(userName + " присоединился к чату!");
		}

		protected void informAboutDeletingNewUser(String userName) {
			ConsoleHelper.writeMessage(userName + " покинул чат!");
		}

		protected void notifyConnectionStatusChanged(boolean clientConnected) {
			synchronized (Client.this) {
				Client.this.clientConnected = clientConnected;
				Client.this.notify();
			}
		}

		protected void clientHandshake() throws IOException, ClassNotFoundException {
			while (true) {
				Message message = connection.receive();
				if (message.getType() == MessageType.NAME_REQUEST) {
					connection.send(new Message(MessageType.USER_NAME, getUserName()));
				} else if (message.getType() == MessageType.NAME_ACCEPTED) {
					notifyConnectionStatusChanged(true);
					break;
				} else {
					throw new IOException("Unexpected MessageType");
				}
			}
		}

		protected void clientMainLoop() throws IOException, ClassNotFoundException {
			while (true) {
				Message message = connection.receive();
				if (message.getType() == MessageType.TEXT) {
					processIncomingMessage(message.getData());
				} else if (message.getType() == MessageType.USER_ADDED) {
					informAboutAddingNewUser(message.getData());
				} else if (message.getType() == MessageType.USER_REMOVED) {
					informAboutDeletingNewUser(message.getData());
				} else {
					throw new IOException("Unexpected MessageType");
				}
			}
		}

		@Override
		public void run() {
			String address = getServerAddress(); //запросим адрес сервера
			int port = getServerPort(); // запросим порт сервера
			try {
				Socket socket = new Socket(address, port); // создадим сокет
				connection = new Connection(socket); //инициализируем соединение
				clientHandshake();
				clientMainLoop();
			} catch (IOException | ClassNotFoundException e) {
				notifyConnectionStatusChanged(false);
			}

		}
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

	public void run() {
		SocketThread socketThread = getSocketThread(); //создадим сокетный поток
		socketThread.setDaemon(true); // пометим созданный поток как демон
		socketThread.start(); //запустим поток
		synchronized (this) { //синхронизируем текущий поток
			try {
				this.wait(); //запустим текущий поток
				if (clientConnected) {  // если клиент соединился, вывести сообщение
					ConsoleHelper.writeMessage("Соединение установлено. Для выхода наберите команду 'exit'.");
					while (clientConnected) { // пока клиент соединен
						String text = ConsoleHelper.readString(); // считывать текст с консоли
						if (text.trim() == "exit") { // если введено exit
							break;  // выйти из цикла
						}
						if (shouldSendTextFromConsole()) { //  если получен текст с консоли
							sendTextMessage(text);  // отправить считанный текст
						}
					}
				} else {
					ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента.");
				}
			} catch (InterruptedException e) {
				ConsoleHelper.writeMessage("Ошибка создания потока сокета!");
			}
		}

	}

	public static void main(String[] args) {
		Client client = new Client(); // создадим новый объект Client
		client.run();   // вызовем метод run()
	}
}
