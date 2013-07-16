/**
 * 
 */
package test.projects.marsrovers;

import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

import kunkunur.org.projects.marsrovers.MarsRovers;
import kunkunur.org.projects.marsrovers.common.exception.InputException;
import kunkunur.org.projects.marsrovers.common.exception.MovementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * @author SANDEEP
 *
 */
public class Success_1 {

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
	 * @throws IOException 
	 */
	@Test
	public final void testProcess() throws IOException {
		
		try {
			String inputString = "5 5\n1 2 N\nLMLMLMLMM\n";
			InputStream is = new ByteArrayInputStream( inputString.getBytes() );
			File temp = new File("temp.txt");
			PrintStream out = new PrintStream(new FileOutputStream(temp));

			System.setIn(is);
			System.setOut(out);
			
			MarsRovers.process();
			out.flush();
			out.close();
			
			FileReader fr = new FileReader(temp);
			BufferedReader bfr = new BufferedReader(fr);
			StringBuffer strBuf = new StringBuffer();
			String line = null;
			
			while ((line = bfr.readLine())  != null){
				strBuf.append(line);
			}
			
			String output = strBuf.toString();
			
			System.setIn(System.in);
			System.setOut(System.out);
			
			assertTrue(output.equals("Output for rover:1--------------------1 3 N"));

		} catch (InputException e) {
			e.printStackTrace();
			assertTrue(false);
		} catch (MovementException e) {
			assertTrue(false);
		}
	}

}
