package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.vo.Vacancy;

import java.util.List;

/**
 * Created by Taly on 28.09.2018.
 */
public class Provider {
	Strategy strategy;

	public Provider(Strategy strategy) {
		this.strategy = strategy;
	}

	public Provider() {

	}

	public void setStrategy(Strategy strategy) {
		this.strategy = strategy;
	}

	public List<Vacancy> getJavaVacancies(String searchString) {

		return strategy.getVacancies(searchString);
	}
}
