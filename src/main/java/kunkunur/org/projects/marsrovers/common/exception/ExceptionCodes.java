package kunkunur.org.projects.marsrovers.common.exception;

import kunkunur.org.projects.marsrovers.common.util.PropertyReader;

public class ExceptionCodes {
	private static final String propFilePath = "ExceptionCodes.properties";
	
	private ExceptionCodes(){
		throw new AssertionError("ExceptionCodes class cannot be instantiated");
	}
	
	public static final String COULD_NOT_LOAD_PROPERTIES_FILE = "Could not load properties files: %1";	
	
	public static final String FATAL_CONFIG_001 = PropertyReader.getProperty(propFilePath, "FATAL_CONFIG_001");
	public static final String FATAL_CONFIG_002 = PropertyReader.getProperty(propFilePath, "FATAL_CONFIG_002");
	public static final String FATAL_CONFIG_003 = PropertyReader.getProperty(propFilePath, "FATAL_CONFIG_003");
	public static final String FATAL_CONFIG_004 = PropertyReader.getProperty(propFilePath, "FATAL_CONFIG_004");
	
	public static final String ROV_INPUT_001 = PropertyReader.getProperty(propFilePath, "ROV_INPUT_001");
	public static final String ROV_INPUT_002 = PropertyReader.getProperty(propFilePath, "ROV_INPUT_002");
	public static final String ROV_INPUT_003 = PropertyReader.getProperty(propFilePath, "ROV_INPUT_003");
	public static final String ROV_INPUT_004 = PropertyReader.getProperty(propFilePath, "ROV_INPUT_004");
	public static final String ROV_INPUT_005 = PropertyReader.getProperty(propFilePath, "ROV_INPUT_005");
	public static final String ROV_INPUT_006 = PropertyReader.getProperty(propFilePath, "ROV_INPUT_006");
	public static final String ROV_INPUT_007 = PropertyReader.getProperty(propFilePath, "ROV_INPUT_007");
	public static final String ROV_INPUT_008 = PropertyReader.getProperty(propFilePath, "ROV_INPUT_008");
	public static final String ROV_INPUT_009 = PropertyReader.getProperty(propFilePath, "ROV_INPUT_009");
	public static final String ROV_INPUT_010 = PropertyReader.getProperty(propFilePath, "ROV_INPUT_010");
	public static final String ROV_INPUT_011 = PropertyReader.getProperty(propFilePath, "ROV_INPUT_011");
	public static final String ROV_INPUT_012 = PropertyReader.getProperty(propFilePath, "ROV_INPUT_012");
	public static final String ROV_INPUT_013 = PropertyReader.getProperty(propFilePath, "ROV_INPUT_013");
	public static final String ROV_INPUT_014 = PropertyReader.getProperty(propFilePath, "ROV_INPUT_014");
	public static final String ROV_INPUT_015 = PropertyReader.getProperty(propFilePath, "ROV_INPUT_015");

	public static final String ROV_MOVEMENT_001 = PropertyReader.getProperty(propFilePath, "ROV_MOVEMENT_001");
	public static final String ROV_MOVEMENT_002 = PropertyReader.getProperty(propFilePath, "ROV_MOVEMENT_002");
	


}
