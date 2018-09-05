package com.javarush.task.task37.task3709.connectors;

import com.javarush.task.task37.task3709.security.SecurityChecker;
import com.javarush.task.task37.task3709.security.SecurityCheckerImpl;

/**
 * Created by Taly on 05.09.2018.
 */
public class SecurityProxyConnector implements Connector {
	SecurityChecker securityChecker;
	SimpleConnector simpleConnector;

	public SecurityProxyConnector(String s) {
		simpleConnector = new SimpleConnector(s);
		securityChecker = new SecurityCheckerImpl();
	}

	@Override
	public void connect() {
		if (securityChecker.performSecurityCheck()) {
			simpleConnector.connect();
		}
	}
}
