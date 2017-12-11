package com.javarush.task.task30.task3008;

import java.io.Closeable;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * Created by Taly on 08.12.2017.
 */
public class Connection implements Closeable {
	final private Socket socket;
	final private ObjectOutputStream out;
	final private ObjectInputStream in;

	public Connection(Socket socket) throws IOException {
		this.socket = socket;
		out = new ObjectOutputStream(socket.getOutputStream());
		in = new ObjectInputStream(socket.getInputStream());
	}

	public void send(Message message) throws IOException {
		synchronized (out) {
			out.writeObject(message);
		}
	}

	public Message receive() throws IOException, ClassNotFoundException {
		synchronized (in) {
			Message message;
			message = (Message) in.readObject();
			return message;
		}
	}

	public SocketAddress getRemoteSocketAddress() {
		return socket.getRemoteSocketAddress();
	}

	public void close() throws IOException {
		out.close();
		in.close();
		socket.close();
	}
}
