package com.smartbed.main;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Properties;
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;
import com.smartbed.grpc.BedServiceGrpc;
import com.smartbed.grpc.CommsServiceGrpc;
import com.smartbed.grpc.BedServiceGrpc.BedServiceBlockingStub;
import com.smartbed.grpc.BedServiceGrpc.BedServiceStub;
import com.smartbed.grpc.CommsServiceGrpc.CommsServiceBlockingStub;
import com.smartbed.grpc.CommsServiceGrpc.CommsServiceStub;


import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

/**
 * SmartbedJMDNSManager - a class that manages the JMDNS naming services
 *
 * @author Tim Winwood - x20213638
 * @version 1.0
 */
public class SmartbedJMDNSManager {

	// declare instance variables
	
	// service stubs

	private BedServiceBlockingStub bedBlockingStub;
	private BedServiceStub bedAsyncStub;
	
	private CommsServiceBlockingStub commsBlockingStub;
	private CommsServiceStub commsAsyncStub;

	private ServiceInfo bedServiceInfo;
	private ServiceInfo commsServiceInfo;
	
	
	/**
	 * constructor - used to initialise a SmartbedJMDNSManager object
	 * 
	 */
	public SmartbedJMDNSManager() {
		
		// load the properties file
		Properties prop = this.loadPropFile();
		SmartbedJMDNSSettings.readPropFile(prop);
		
	}
	
	
	/**
	 * Loads the properties file
	 * 
	 * @return the properties file
	 */
	private Properties loadPropFile() {

		Properties propFile = new Properties();
		FileInputStream fs=null;
		try  {
			fs = new FileInputStream("src/main/resources/smartbed.properties");
			propFile.load(fs);
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(fs!= null) {
				try {
					fs.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return propFile;

	}
	
	
	/**
	 * initialise the service stubs
	 * 
	 */
	public void initStubs() {
		
		// discover the services
		String service_type = SmartbedJMDNSSettings.SERVICE_TYPE;
		discoverServices(service_type);

		
		// initialise comms service
		String host1 = commsServiceInfo.getHostAddresses()[0];
		int port1 = commsServiceInfo.getPort();
		ManagedChannel channel1 = ManagedChannelBuilder.forAddress(host1, port1).usePlaintext().build();
		commsBlockingStub = CommsServiceGrpc.newBlockingStub(channel1);
		commsAsyncStub =  CommsServiceGrpc.newStub(channel1);
	
		// initialise bed service
		String host2 = bedServiceInfo.getHostAddresses()[0];
		int port2 = bedServiceInfo.getPort();
		ManagedChannel channel2 = ManagedChannelBuilder.forAddress(host2, port2).usePlaintext().build();
		bedBlockingStub = BedServiceGrpc.newBlockingStub(channel2);
		bedAsyncStub =  BedServiceGrpc.newStub(channel2);

	}
	
	/**
	 * discover the services
	 * 
	 */
	private void discoverServices(String service_type) {

		try {

			// jmdns on localhost
			JmDNS jmdns = JmDNS.create();
			
			// listen for services of type
			jmdns.addServiceListener(service_type, new ServiceListener() {

				@Override
				public void serviceResolved(ServiceEvent event) {
					
					System.out.println("Service resolved: " + event.getInfo());

					// when a service is resolved, get the relevant event info
					String name = event.getInfo().getName();
					if(name.equals(SmartbedJMDNSSettings.SERVICE_1_NAME)) {
						commsServiceInfo = event.getInfo();
					}else if(name.equals(SmartbedJMDNSSettings.SERVICE_2_NAME)){
						bedServiceInfo = event.getInfo();
					}

					// print the service details
					String serviceResolved =
							"-- Service Resolved --" + "\n" +
							"Port: " + event.getInfo().getPort() + "\n" +
							"Type: " + event.getType() + "\n" +
							"Name: " +  event.getName() + "\n" +
							"Description: " + event.getInfo().getNiceTextString() + "\n" +
							"Host: " + event.getInfo().getHostAddresses()[0]+ "\n";
					
					System.out.println(serviceResolved);

				}

				@Override
				public void serviceRemoved(ServiceEvent event) {
					System.out.println("Service removed: " + event.getInfo());

				}

				@Override
				public void serviceAdded(ServiceEvent event) {
					
					jmdns.requestServiceInfo(service_type, event.getName());
					System.out.println("Service added: " + event.getInfo());

				}
			});

			// sleep for 2 seconds to ensure services are discovered
			Thread.sleep(2000);

			// close jmdns
			jmdns.close();

		} catch (UnknownHostException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	/**
	 * registers the services on JmDNS
	 * 
	 */
	public void registerServices() {
		
		 try {
	            // create JmDNS instance on local host
	            JmDNS jmdns = JmDNS.create();

	            // register the service
	            ServiceInfo serviceInfo1 = ServiceInfo.create(SmartbedJMDNSSettings.SERVICE_TYPE, SmartbedJMDNSSettings.SERVICE_1_NAME, SmartbedJMDNSSettings.SERVICE_PORT, SmartbedJMDNSSettings.SERVICE_1_DESC);
	            jmdns.registerService(serviceInfo1);
	            
	            System.out.println("Service Registered - " + " Type: " + SmartbedJMDNSSettings.SERVICE_TYPE  + " Name: " + SmartbedJMDNSSettings.SERVICE_1_NAME);
	            
	            // wait for 1 second
	            Thread.sleep(1000);

	            // register the service
	            ServiceInfo serviceInfo2 = ServiceInfo.create(SmartbedJMDNSSettings.SERVICE_TYPE, SmartbedJMDNSSettings.SERVICE_2_NAME, SmartbedJMDNSSettings.SERVICE_PORT, SmartbedJMDNSSettings.SERVICE_2_DESC);
	            jmdns.registerService(serviceInfo2);
	            
	            System.out.println("Service Registered - " + " Type: " + SmartbedJMDNSSettings.SERVICE_TYPE  + " Name: " + SmartbedJMDNSSettings.SERVICE_2_NAME);
	            
	            // wait for 1 second
	            Thread.sleep(1000);

	            
	        } catch (IOException e) {
	        	e.printStackTrace();
	        } catch (InterruptedException e) {
				e.printStackTrace();
			}
	    
	}

	/**
	 * get the bedBlockingStub
	 * 
	 * @return the bedBlockingStub
	 */
	public BedServiceBlockingStub getBedBlockingStub() {
		return bedBlockingStub;
	}

	/**
	 * get the bedAsyncStub
	 * 
	 * @return the bedAsyncStub
	 */
	public BedServiceStub getBedAsyncStub() {
		return bedAsyncStub;
	}

	/**
	 * get the commsBlockingStub
	 * 
	 * @return the commsBlockingStub
	 */
	public CommsServiceBlockingStub getCommsBlockingStub() {
		return commsBlockingStub;
	}

	/**
	 * get the commsAsyncStub
	 * 
	 * @return the commsAsyncStub
	 */
	public CommsServiceStub getCommsAsyncStub() {
		return commsAsyncStub;
	}
	
}
