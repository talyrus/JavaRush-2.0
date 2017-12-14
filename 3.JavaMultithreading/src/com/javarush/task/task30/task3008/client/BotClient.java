package com.javarush.task.task30.task3008.client;

/**
 * Created by Taly on 14.12.2017.
 */
public class BotClient extends Client {
	public class BotSocketThread extends SocketThread {
	}

	@Override
	protected String getUserName() {
		int max = 99;
		int x = (int) (Math.random() * ++max);
		String botName = "date_bot_" + x;
		return botName;
	}

	@Override
	protected boolean shouldSendTextFromConsole() {
		return false;
	}

	@Override
	protected SocketThread getSocketThread() {
		return new BotSocketThread();
	}

	public static void main(String[] args) {
		BotClient botClient = new BotClient();
		System.out.println(botClient.getUserName());
		botClient.run();
	}
}
