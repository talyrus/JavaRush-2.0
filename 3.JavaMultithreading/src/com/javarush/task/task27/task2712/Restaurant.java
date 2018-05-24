package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Waiter;

/**
 * Created by Taly on 24.01.2018.
 */
public class Restaurant {
	public static void main(String[] args) {
		//В методе main класса Restaurant должен быть создан новый повар
		// и добавлен планшету в качестве наблюдателя с помощью метода addObserver.
		Tablet tablet = new Tablet(5);
		Cook cook = new Cook("Amigo");
		Waiter waiter = new Waiter();
		tablet.addObserver(cook);
		cook.addObserver(waiter);

		tablet.createOrder();


	}
}
