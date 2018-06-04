package com.javarush.task.task32.task3208;

import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/* 
RMI-2
*/
public class Solution {
	public static Registry registry;
	public static final String BINDING_CAT = "server.cat";
	public static final String BINDING_DOG = "server.dog";


	//pretend we start rmi client as CLIENT_THREAD thread
	public static Thread CLIENT_THREAD = new Thread(new Runnable() {
		@Override
		public void run() {
			try {
				for (String bindingName : registry.list()) {
					Animal service = (Animal) registry.lookup(bindingName);
					service.printName();
					service.say();
				}
			} catch (RemoteException e) {
				e.printStackTrace();
			} catch (NotBoundException e) {
				e.printStackTrace();
			}
		}
	});

	//pretend we start rmi server as SERVER_THREAD thread
	public static Thread SERVER_THREAD = new Thread(new Runnable() {
		@Override
		public void run() {
			//напишите тут ваш код
			try {
				registry = LocateRegistry.createRegistry(2099); // создаем реестр
				Animal cat = new Cat("Spoke"); // создаем объекты
				Animal dog = new Dog("Jarvis");

				Remote stubCat = UnicastRemoteObject.exportObject(cat, 2099); //создаем заглушки
				Remote stubDog = UnicastRemoteObject.exportObject(dog, 2099); //приемники удаленных вызовов

				registry.bind(BINDING_CAT, stubCat); // свяжем ключ и удаленный объект (регистрация заглушки)
				registry.bind(BINDING_DOG, stubDog);

			} catch (RemoteException e) {
				e.printStackTrace();
			} catch (AlreadyBoundException e) {
				e.printStackTrace();
			}

		}
	});

	public static void main(String[] args) throws InterruptedException {
		//start rmi server thread
		SERVER_THREAD.start();
		Thread.sleep(1000);
		//start client
		CLIENT_THREAD.start();
	}
}
