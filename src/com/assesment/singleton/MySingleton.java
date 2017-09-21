package com.assesment.singleton;

public class MySingleton {

	private static MySingleton singleInstance = null;

	private MySingleton() {

	}
	// Lazy Initialization with double check locking for thread safety
	public static MySingleton getInstance() {
		if (singleInstance == null) {
			synchronized (MySingleton.class) {
				if (singleInstance == null) {
					singleInstance = new MySingleton();
				}
			}
		}
		return singleInstance;
	}
}
