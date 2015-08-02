package org.frenchman.gateway.service;

public class FailingService {
	
	public void process(String message) {
		if (!"Bogusia".equals(message))
			throw new RuntimeException("Execution of Service failed");
	}

}
