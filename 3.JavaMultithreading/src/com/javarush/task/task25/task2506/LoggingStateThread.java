package com.javarush.task.task25.task2506;

/**
 * Created by Taly on 24.10.2017.
 */
public class LoggingStateThread extends Thread {
	private Thread target;
	private State prState = null;

	public LoggingStateThread(Thread target) {
		this.target = target;
		this.setDaemon(true);
	}

	public void run() {
		while (true) {
			State state = target.getState();
			if (prState == null) {
				prState = state;
				System.out.println(state.toString());
			} else if (!state.equals(prState)) {
				System.out.println(state.toString());
				prState = state;
			}
			if (state.equals(State.TERMINATED)) {
				break;
			}
		}
	}
}
