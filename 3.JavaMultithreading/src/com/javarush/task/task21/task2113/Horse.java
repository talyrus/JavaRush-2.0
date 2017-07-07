package com.javarush.task.task21.task2113;
/**
 * Created by Taly on 07.07.2017.
 */
public class Horse { //1. Создадим класс
	String name;    //4. создадим необходимые поля
	double speed;
	double distance;

	public Horse(String name, double speed, double distance) { //5. Создадим конструктор класса Horse
		this.name = name;
		this.speed = speed;
		this.distance = distance;
	}

	public String getName() { //5. Создадим getter’ы и setter’ы для всех полей класса Horse.
		return name;
	}

	public double getSpeed() {
		return speed;
	}

	public double getDistance() {
		return distance;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}
}
