package kunkunur.org.projects.marsrovers.common.util;

import java.io.InputStream;

/**
 * This Class provides utility methods for accessing resources.
 * 
 * @author sandeep_kunkunuru
 *
 */
public class ResourceUtility {

	private ResourceUtility() {
		throw new AssertionError("ResourceUtility class cannot be instantiated");
	}
	
	/**
	 * Method that takes a resource name and locates it in the class path
	 * 
	 * @param name Resource name
	 * @return stream
	 */
	public static InputStream getResourceAsStream(String name) {

		InputStream fileStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(name);

		return fileStream;
	}

}

