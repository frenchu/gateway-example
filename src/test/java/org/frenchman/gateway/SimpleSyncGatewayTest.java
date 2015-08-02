package org.frenchman.gateway;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.integration.MessageRejectedException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.apache.log4j.Logger;
import org.frenchman.gateway.service.SimpleSyncGateway;

/**
 * Verify that the Simple Sync Gateway working as expected.
 *
 * @author Pawel Weselak
 * @since 0.1
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/META-INF/spring/integration/spring-integration-context.xml")
public class SimpleSyncGatewayTest {

	private static Logger logger = Logger.getLogger(SimpleSyncGatewayTest.class);
	
	@Inject
	private SimpleSyncGateway service;

	@Test
	public void testPassBogusia() {
		final String name = "Bogusia";
		logger.info("Sending the message...");
		service.send(name);
		logger.info(name);
	}
	
	@Test(expected = RuntimeException.class)
	public void testFailingService() {
		final String name = "bogusia";
		logger.info("Sending the message...");
		service.send(name);
		logger.info(name);
	}
	
	@Test(expected = MessageRejectedException.class)
	public void testFailProcessingOnOla() {
		final String name = "Ola";
		logger.info("Sending the message...");
		service.send(name);
		logger.info(name);
	}
}
