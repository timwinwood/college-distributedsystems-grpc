package com.smartbed.main;

import java.util.Properties;

/**
 * SmartbedJMDNSSettings - a class used to Read the smartbed.properties file containing JMDNS Settings
 *
 * @author Tim Winwood - x20213638
 * @version 1.0
 */
public class SmartbedJMDNSSettings {
	
	// declare variables
	public static String SERVICE_TYPE;
	public static int SERVICE_PORT;
	
	public static String SERVICE_1_NAME;
	public static String SERVICE_1_DESC;
	
	public static String SERVICE_2_NAME;
	public static String SERVICE_2_DESC;
	
	
	/**
	 * Used to Read smartbed.properties and Populate relevant Properties.
	 * smartbed.properties must be placed in the src/main/resources folder of the project
	 * 
	 * @param propFile the properties file
	 */
	public static void readPropFile(Properties propFile) {

		try {

			SERVICE_TYPE = getString(propFile,"SERVICE_TYPE");
			SERVICE_PORT = getInteger(propFile,"SERVICE_PORT");
			
			SERVICE_1_NAME = getString(propFile,"SERVICE_1_NAME");
			SERVICE_1_DESC = getString(propFile,"SERVICE_1_DESC");
			
			SERVICE_2_NAME = getString(propFile,"SERVICE_2_NAME");
			SERVICE_2_DESC = getString(propFile,"SERVICE_2_DESC");

		} catch (Exception e) {

			e.printStackTrace();

		}

	}
	
	
	/**
	 * get a string from a properties file
	 * 
	 * @param propFile the properties file
	 * @param key the key
	 * @return the string
	 */
	private static String getString(Properties propFile, String key) {

		return propFile.getProperty(key);

	}
	
	/**
	 * get an int from a properties file
	 * 
	 * @param propFile the properties file
	 * @param key the key
	 * @return the int
	 */
	private static int getInteger(Properties propFile, String key) {

		return Integer.parseInt(propFile.getProperty(key));

	}

}
