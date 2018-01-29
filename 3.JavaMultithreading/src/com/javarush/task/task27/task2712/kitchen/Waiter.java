package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Taly on 29.01.2018.
 */
public class Waiter implements Observer {
	@Override
	public void update(Observable observable, Object arg) {
		ConsoleHelper.writeMessage(arg + " was cooked by " + observable);
	} //будет относить заказы назад к столику. Официант будет безымянным.
}
