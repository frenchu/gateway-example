package org.frenchman.gateway.service;

public class WaitingService {

	public String process(String message) throws InterruptedException {
		Thread.sleep(5000L);
		return message;
	}
}
