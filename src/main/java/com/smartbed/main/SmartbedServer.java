package com.smartbed.main;

import java.io.IOException;
import io.grpc.Server;
import io.grpc.ServerBuilder;

/**
 * SmartbedServer - a class to create and run a gRPC server
 *
 * @author Tim Winwood - x20213638
 * @version 1.0
 */
public class SmartbedServer {

	/**
	 * entry point to the application
	 * 
	 * @param args unused
	 */
	public static void main(String[] args) {

		// initialise the services
		SmartbedBedService smartbedBedService = new SmartbedBedService();
		SmartbedCommsService smartbedCommsService = new SmartbedCommsService();

		// initialise the JMDNSManager and register the services
		SmartbedJMDNSManager smartbedJMDNSManager = new SmartbedJMDNSManager();
		smartbedJMDNSManager.registerServices();

		try {

			// build the server with the port and services
			Server server = ServerBuilder.forPort(SmartbedJMDNSSettings.SERVICE_PORT).addService(smartbedBedService).addService(smartbedCommsService).build().start();

			System.out.println("Smartbed Server running on Port: " + SmartbedJMDNSSettings.SERVICE_PORT);

			// wait for the server to be terminated
			server.awaitTermination();

		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
