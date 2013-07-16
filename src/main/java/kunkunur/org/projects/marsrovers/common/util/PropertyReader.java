package kunkunur.org.projects.marsrovers.common.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

import kunkunur.org.projects.marsrovers.common.exception.ExceptionCodes;
import kunkunur.org.projects.marsrovers.common.exception.FatalException;


public class PropertyReader {
	private static final HashMap<String, Properties> propFiles = new HashMap<String, Properties>();

	private PropertyReader() {
		throw new AssertionError("PropertyReader class cannot be instantiated");
	}
	
	public static String getProperty(String propFilePath, String key)
			throws FatalException {
		Properties props = null;

		if (propFiles.get(propFilePath) == null) {
			props = new Properties();
			
			try {
				props.load(ResourceUtility.getResourceAsStream(propFilePath));
			} catch(IOException e){
				throw new FatalException(ExceptionCodes.COULD_NOT_LOAD_PROPERTIES_FILE, e, propFilePath);
			}
			
			propFiles.put(propFilePath, props);
		} else {
			props = propFiles.get(propFilePath);
		}

		return props.getProperty(key);
	}

}
