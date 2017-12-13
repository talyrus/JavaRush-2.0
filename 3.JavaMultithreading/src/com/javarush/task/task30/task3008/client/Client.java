package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.Connection;

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
}
