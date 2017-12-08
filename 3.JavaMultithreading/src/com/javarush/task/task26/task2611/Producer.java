package com.javarush.task.task26.task2611;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Taly on 08.12.2017.
 */
public class Producer implements Runnable {
	private ConcurrentHashMap<String, String> map;

	@Override
	public void run() {
		for (int i = 1; i < 5; i++) {
			try {
				map.put(String.valueOf(i), "Some text for " + i);
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println(Thread.currentThread().getName() + " thread was terminated");
			}

		}
	}

	public Producer(ConcurrentHashMap map) {
		this.map = map;
	}
}
