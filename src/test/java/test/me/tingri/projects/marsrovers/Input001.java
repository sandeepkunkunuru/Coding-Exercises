/**
 * 
 */
package test.me.tingri.projects.marsrovers;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import me.tingri.projects.marsrovers.MarsRovers;
import me.tingri.projects.marsrovers.common.exception.InputException;
import me.tingri.projects.marsrovers.common.exception.MovementException;
import me.tingri.projects.marsrovers.common.util.PropertyReader;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


/**
 * @author SANDEEP
 * 
 */
public class Input001 {

	private static final String propFilePath = "ExceptionCodes.properties";

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

	}
	
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
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * Test method for {@link me.tingri.projects.marsrovers.MarsRovers#process()}.
	 */
	@Test
	public final void testProcess() {
		try {
			String inputString = "5 5\n1 2 \n";

			InputStream is = new ByteArrayInputStream(inputString.getBytes());

			System.setIn(is);

			MarsRovers.process();

		} catch (InputException e) {
			String message = PropertyReader.getProperty(propFilePath,
					"ROV_INPUT_001");

			message = String.format(message);

			assertTrue(e.getMessage().equals(message));
		} catch (MovementException e) {
			assertTrue(false);
		}
	}
}
