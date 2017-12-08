package com.javarush.task.task26.task2610;

import java.util.concurrent.BlockingQueue;

/**
 * Created by Taly on 08.12.2017.
 */
public class Consumer implements Runnable {
	private BlockingQueue queue;

	public Consumer(BlockingQueue queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Object i = queue.take();
				System.out.println(i);

			} catch (InterruptedException e) {
				System.out.println(String.format("[%s] thread was terminated (take)", Thread.currentThread().getName()));
			}
		}
	}
}
