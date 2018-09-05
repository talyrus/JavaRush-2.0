package com.javarush.task.task37.task3711;

/**
 * Created by Taly on 05.09.2018.
 */
public class Computer {
	private CPU cpu = new CPU();
	private Memory memory = new Memory();
	private HardDrive hardDrive = new HardDrive();

	protected void run() {
		cpu.calculate();
		memory.allocate();
		hardDrive.storeData();
	}
}
