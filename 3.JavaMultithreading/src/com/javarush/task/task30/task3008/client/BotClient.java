package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Taly on 14.12.2017.
 */
public class BotClient extends Client {
	public class BotSocketThread extends SocketThread {
		@Override
		protected void clientMainLoop() throws IOException, ClassNotFoundException {
			sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
			super.clientMainLoop();
		}

		@Override
		protected void processIncomingMessage(String message) {
			String pattern="";
			ConsoleHelper.writeMessage(message);
			if (message!=null&&!message.isEmpty()&&message.contains(":"))
			{
				String[] strings=message.split(": ");
				switch (strings[1]) {
					case "дата": pattern="d.MM.YYYY"; break;
					case "день" : pattern="d";break;
					case "месяц" : pattern="MMMM";break;
					case "год": pattern="YYYY";break;
					case "время": pattern="H:mm:ss";break;
					case "час": pattern="H";break;
					case "минуты": pattern="m";break;
					case "секунды": pattern="s";break;
				}
				Date time = Calendar.getInstance().getTime();
				if (pattern!="") sendTextMessage(String.format("Информация для %s: %s",strings[0],new SimpleDateFormat(pattern).format(time)));
			}
		}

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
		//System.out.println(botClient.getUserName());
		botClient.run();
	}
}
