package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Taly on 08.12.2017.
 */
public class Server {
	public static void main(String[] args) throws IOException {
		int portServer = ConsoleHelper.readInt(); // считаем номер порта с консоли
		Socket socket = null;
		try (ServerSocket serverSocket = new ServerSocket(portServer)) { //создаем серверный сокет
			System.out.println("Сервер запущен!"); // выведем сообщение о запуске сервера
			while (true) {
				socket = serverSocket.accept(); // слушаем и принимает сокетные соединения
				Handler handler = new Handler(socket);
				handler.start();
			}
		} catch (IOException e) {
			System.out.println("Ошибка! " + e); // выводим сообщение об ошибке
			socket.close(); // закрываем сокет
		}

	}

	private static class Handler extends Thread {
		private Socket socket;

		public Handler(Socket socket) {
			this.socket = socket;
		}


	}


}
