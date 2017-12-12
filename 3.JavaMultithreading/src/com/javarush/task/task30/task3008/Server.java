package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Created by Taly on 08.12.2017.
 */
public class Server {
	static private Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

	static void sendBroadcastMessage(Message message) {

		for (Map.Entry<String, Connection> comp : connectionMap.entrySet()) {
			try {
				comp.getValue().send(message);

			} catch (IOException e) {
				ConsoleHelper.writeMessage("Сообщение не отправлено. Ошибка: " + e.getMessage());
			}
		}
	}

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

		private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
			while (true) {
				connection.send(new Message(MessageType.NAME_REQUEST)); // отправляем запрос имени
				Message answer = connection.receive(); // получаем ответ от клиента
				if (answer.getType().equals(MessageType.USER_NAME)) { // если вернулось имя пользователя
					if (!answer.getData().isEmpty()) { //проверим, что оно не пустое
						if (!connectionMap.containsKey(answer.getData())) { //если такого пользователя нет
							connectionMap.put(answer.getData(), connection); // добавим  его
							connection.send(new Message(MessageType.NAME_ACCEPTED)); // уведомим пользователя о принятии имени
							return answer.getData();    // вернем строку с именем
						}
					}
				}
			}
		}

		private void sendListOfUsers(Connection connection, String userName) throws IOException {
			for (Map.Entry<String, Connection> user : connectionMap.entrySet()) {
				String name = user.getKey();
				if (!name.equals(userName)) {
					connection.send(new Message(MessageType.USER_ADDED, name));
				}
			}
		}

		private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
			while (true) {
				Message answer = connection.receive(); // принимаем сообщения от клиентов
				if (answer.getType() == (MessageType.TEXT)) { // если тип сообщения TEXT
					String message = userName + ": " + answer.getData(); // сформируем ответное сообщение
					sendBroadcastMessage(new Message(MessageType.TEXT, message)); // отправим его всем клиентам
				} else {
					ConsoleHelper.writeMessage("Error!"); // если тип сообщения НЕ TEXT, выведем ошибку
				}
			}
		}

	}


}
