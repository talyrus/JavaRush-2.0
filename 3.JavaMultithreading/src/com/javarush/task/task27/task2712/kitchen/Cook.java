package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Taly on 29.01.2018.
 */
public class Cook extends Observable implements Observer { //класс будет готовить //Класс Cook должен реализовывать интерфейс Observer.
	private String name;

	public Cook(String name) { //Конструктор класса Cook должен принимать в качестве параметра строку и инициализировать имя повара (поле name).
		this.name = name;
	}

	@Override
	public String toString() { //Метод toString класса Cook должен возвращать значение поля name.
		return name;
	}

	@Override
	//observable - объект, который отправил нам значение
	//- arg - само значение, в нашем случае - это объект Order
	public void update(Observable observable, Object arg) { //Метод update в классе Cook должен выводить на экран строку форматированную согласно заданию.
		Order order = (Order) arg;
		ConsoleHelper.writeMessage("Start cooking - " + arg + ", cooking time " + order.getTotalCookingTime() + "min");
		setChanged();
		notifyObservers(arg);
	}
}
