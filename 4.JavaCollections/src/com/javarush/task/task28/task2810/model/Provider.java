package com.javarush.task.task28.task2810.model;

/**
 * Created by Taly on 28.09.2018.
 */
public class Provider {
	Strategy strategy;

	public Provider(Strategy strategy) {
		this.strategy = strategy;
	}

	public void setStrategy(Strategy strategy) {
		this.strategy = strategy;
	}
}
