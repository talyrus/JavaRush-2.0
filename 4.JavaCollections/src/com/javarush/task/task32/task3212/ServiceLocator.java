package com.javarush.task.task32.task3212;

import com.javarush.task.task32.task3212.contex.InitialContext;
import com.javarush.task.task32.task3212.service.Service;


public class ServiceLocator {
	private static Cache cache;

	static {
		cache = new Cache();
	}

	/**
	 * First check the service object available in cache
	 * If service object not available in cache do the lookup using
	 * JNDI initial context and get the service object. Add it to
	 * the cache for future use.
	 *
	 * @param jndiName The name of service object in context
	 * @return Object mapped to name in context
	 */
	public static Service getService(String jndiName) {
		Service service = cache.getService(jndiName); // получим из кэша нужный сервис
		if (service != null) {
			return service; // если в кэше есть нужный сервис - вернем его
		}
		InitialContext context = new InitialContext(); // создадим контекст
		Service newService = (Service) context.lookup(jndiName);    // найдем в нем сервис
		cache.addService(newService);   // добавим его в кэш

		return newService;
	}
}
