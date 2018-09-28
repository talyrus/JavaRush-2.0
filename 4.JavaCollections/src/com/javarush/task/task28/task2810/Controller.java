package com.javarush.task.task28.task2810;

import com.javarush.task.task28.task2810.model.Provider;

import java.util.Arrays;

/**
 * Created by Taly on 28.09.2018.
 */
public class Controller {
	private Provider[] providers;

	public Controller(Provider... providers) {
		if (providers.length == 0) {
			throw new IllegalArgumentException();
		}
		this.providers = providers;
	}

	@Override
	public String toString() {
		return "Controller{" +
						"providers=" + Arrays.toString(providers) +
						'}';
	}
}
