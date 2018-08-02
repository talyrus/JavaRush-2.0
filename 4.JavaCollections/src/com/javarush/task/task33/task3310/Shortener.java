package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.StorageStrategy;

/**
 * Created by Taly on 02.08.2018.
 */
public class Shortener {
	private Long lastId = 0L; //будет отвечать за последнее значение идентификатора, которое было использовано при добавлении новой строки в хранилище
	private StorageStrategy storageStrategy; //будет храниться стратегия хранения данных

	public Shortener(StorageStrategy storageStrategy) { //инициализирует соответствующее поле класса
		this.storageStrategy = storageStrategy;
	}

	public synchronized Long getId(String string) {
		if (storageStrategy.containsValue(string)) {
			return storageStrategy.getKey(string);
		} else {
			lastId++;
			storageStrategy.put(lastId, string);
		}
		return lastId;
	}

	public synchronized String getString(Long id) {
		return storageStrategy.getValue(id);
	}
}
