package com.javarush.task.task33.task3310.strategy;

/**
 * Created by Taly on 02.08.2018.
 */
public interface StorageStrategy {
	boolean containsKey(Long key); //должен вернуть true, если хранилище содержит переданный ключ.

	boolean containsValue(String value); //должен вернуть true, если хранилище содержит переданное значение.

	void put(Long key, String value); //добавить в хранилище новую пару ключ -	значение.

	Long getKey(String value); //вернуть ключ для переданного значения.

	String getValue(Long key); //вернуть значение для переданного ключа.

}
