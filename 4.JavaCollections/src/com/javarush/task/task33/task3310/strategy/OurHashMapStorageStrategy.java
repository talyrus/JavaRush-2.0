package com.javarush.task.task33.task3310.strategy;

/**
 * Created by Taly on 02.08.2018.
 */
public class OurHashMapStorageStrategy implements StorageStrategy {

	@Override

	public boolean containsKey(Long key) {
		return false;
	}

	@Override
	public boolean containsValue(String value) {
		return false;
	}

	@Override
	public void put(Long key, String value) {

	}

	@Override
	public Long getKey(String value) {
		return null;
	}

	@Override
	public String getValue(Long key) {
		return null;
	}
}
