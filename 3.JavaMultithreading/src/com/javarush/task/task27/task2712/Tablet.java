package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.AdvertisementManager;
import com.javarush.task.task27.task2712.kitchen.Order;

import java.io.IOException;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Created by Taly on 24.01.2018.
 */
public class Tablet extends Observable { //Класс Tablet должен быть потомком класса Observable.
	public final int number; // номер планшета, чтобы узнать откуда поступил заказ
	private static java.util.logging.Logger logger = Logger.getLogger(Tablet.class.getName());

	public Tablet(int number) { // инициализируем номер планшета в конструкторе
		this.number = number;
	}

	public Order createOrder() { // метод будет создавать заказ из тех блюд, что выберет пользователь
		Order order = null;
		try {
			order = new Order(this);
			ConsoleHelper.writeMessage(order.toString());
			setChanged();       //В методе createOrder класса Tablet должен быть вызван метод setChanged.
			notifyObservers(order); //В методе createOrder класса Tablet должен быть вызван метод notifyObservers с текущим заказом в качестве параметра.
			AdvertisementManager advertisementManager = new AdvertisementManager(order.getTotalCookingTime() * 60);
			advertisementManager.processVideos();
		} catch (IOException e) {
			logger.log(Level.SEVERE, "Console is unavailable.");
		}
		return order;
	}

	@Override
	public String toString() {
		return "Tablet{" +
				"number=" + number +
				'}';
	}


}
