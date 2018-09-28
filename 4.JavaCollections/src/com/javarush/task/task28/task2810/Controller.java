package com.javarush.task.task28.task2810;

import com.javarush.task.task28.task2810.model.Provider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

	public void scan() {
		List vacancies = new ArrayList();
		try {
			for (Provider provider : providers) {
				vacancies.addAll(provider.getJavaVacancies(null));
			}
		} catch (NullPointerException ex) {
		}
		System.out.println(vacancies.size());
	}
}
