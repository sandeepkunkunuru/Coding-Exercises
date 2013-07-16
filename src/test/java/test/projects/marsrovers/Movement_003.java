/**
 * 
 */
package test.projects.marsrovers;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import kunkunur.org.projects.marsrovers.MarsRovers;
import kunkunur.org.projects.marsrovers.common.exception.InputException;
import kunkunur.org.projects.marsrovers.common.exception.MovementException;
import kunkunur.org.projects.marsrovers.common.util.Constants;
import kunkunur.org.projects.marsrovers.common.util.PropertyReader;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * @author SANDEEP
 *
 */
public class Movement_003 {
	private static final String propFilePath = "ExceptionCodes.properties";


	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link kunkunur.org.projects.marsrovers.MarsRovers#process()}.
	 */
	@Test
	public final void testProcess() {
		
		try {
			String inputString = "2 1\n0 1 N\nLM";
			
			InputStream is = new ByteArrayInputStream( inputString.getBytes() );

			System.setIn(is);

			MarsRovers.process();

			System.setIn(System.in);

		} catch (MovementException e) {
			String message = PropertyReader.getProperty(propFilePath, "ROV_MOVEMENT_002");
			
			message = String.format(message,"0", "1",Constants.X, "-1", "0");
			
			assertTrue(e.getMessage().equals(message));
		} catch (InputException e) {
			assertTrue(false);
		}
	}

}
