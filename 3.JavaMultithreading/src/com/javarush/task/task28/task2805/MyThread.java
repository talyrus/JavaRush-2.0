package com.javarush.task.task28.task2805;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Taly on 11.01.2018.
 */
public class MyThread extends Thread {
	public static AtomicInteger counter = new AtomicInteger(1);

	private void initPriority() {
		if (counter.get() < 10) {
			setPriority(counter.getAndIncrement());
		} else {
			setPriority(counter.get());
			counter.set(1);
		}
	}

	public MyThread() {
		initPriority();
	}

	public MyThread(Runnable target) {
		super(target);
		initPriority();
	}

	public MyThread(ThreadGroup group, Runnable target) {
		super(group, target);
		initPriority();
	}

	public MyThread(String name) {
		super(name);
		initPriority();
	}

	public MyThread(ThreadGroup group, String name) {
		super(group, name);
		initPriority();
	}

	public MyThread(Runnable target, String name) {
		super(target, name);
		initPriority();
	}

	public MyThread(ThreadGroup group, Runnable target, String name) {
		super(group, target, name);
		initPriority();
	}

	public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
		super(group, target, name, stackSize);
		initPriority();
	}
}
