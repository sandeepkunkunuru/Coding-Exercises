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
import me.tingri.projects.marsrovers.common.util.Constants;
import me.tingri.projects.marsrovers.common.util.PropertyReader;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * @author SANDEEP
 *
 */
public class Movement_002 {
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
	 * Test method for {@link me.tingri.projects.marsrovers.MarsRovers#process()}.
	 */
	@Test
	public final void testProcess() {
		
		try {
			String inputString = "2 1\n1 1 W\nRM";
			
			InputStream is = new ByteArrayInputStream( inputString.getBytes() );

			System.setIn(is);

			MarsRovers.process();

			System.setIn(System.in);

		} catch (MovementException e) {
			String message = PropertyReader.getProperty(propFilePath, "ROV_MOVEMENT_001");
			
			message = String.format(message,"1", "1",Constants.Y, "2", "1");
			
			assertTrue(e.getMessage().equals(message));
		} catch (InputException e) {
			assertTrue(false);
		}
	}

}
