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
import kunkunur.org.projects.marsrovers.common.util.PropertyReader;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * @author SANDEEP
 *
 */
public class Input009 {
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
			String inputString = "5 4 S";
			
			InputStream is = new ByteArrayInputStream( inputString.getBytes() );

			System.setIn(is);

			MarsRovers.process();

			System.setIn(System.in);

		} catch (InputException e) {
			String message = PropertyReader.getProperty(propFilePath, "ROV_INPUT_009");
			
			message = String.format(message, "5","4","S" );
			
			assertTrue(e.getMessage().equals(message));
		} catch (MovementException e) {
			assertTrue(false);
		}
	}

}
