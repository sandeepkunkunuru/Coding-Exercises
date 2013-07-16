package kunkunur.org.projects.marsrovers.common.util;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;

import kunkunur.org.projects.marsrovers.common.exception.ExceptionCodes;
import kunkunur.org.projects.marsrovers.common.exception.FatalException;


public class Factory {
	private static final String propFilePath = "Configuration.properties";
	private static final HashMap<String, Object> singletons = new HashMap<String, Object>();

	private Factory(){
		throw new AssertionError("Factory class cannot be instantiated");
	}
	
	public static Object getSingletonInstance(String configProperty) {
		String className = PropertyReader.getProperty(propFilePath,	configProperty);

		try {

			if (singletons.get(className) == null) {
				Object obj = Class.forName(className).newInstance();

				singletons.put(className, obj);
			}
			
			return singletons.get(className);
			
		} catch (InstantiationException e) {
			throw new FatalException(ExceptionCodes.FATAL_CONFIG_001, e, configProperty, className);
		} catch (IllegalAccessException e) {
			throw new FatalException(ExceptionCodes.FATAL_CONFIG_002, e, configProperty, className);
		} catch (ClassNotFoundException e) {
			throw new FatalException(ExceptionCodes.FATAL_CONFIG_003, e, configProperty, className);
		}
	}

	public static InputStream getInputStream() {
		String streamIndicator = PropertyReader.getProperty(propFilePath, "InputStream");

		if(streamIndicator.equals("System.in")){
			return System.in;
		} else {
			throw new FatalException(ExceptionCodes.FATAL_CONFIG_004, "InputStream", streamIndicator);
		}
	}
	
	public static OutputStream getOutputStream() {
		String streamIndicator = PropertyReader.getProperty(propFilePath, "OutputStream");

		if(streamIndicator.equals("System.out")){
			return System.out;
		} else {
			throw new FatalException(ExceptionCodes.FATAL_CONFIG_004, "OutputStream", streamIndicator);
		}
	}
}
