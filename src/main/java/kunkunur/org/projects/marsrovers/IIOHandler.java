package kunkunur.org.projects.marsrovers;

import java.io.InputStream;
import java.io.OutputStream;

import kunkunur.org.projects.marsrovers.data.Input;
import kunkunur.org.projects.marsrovers.data.Output;


public interface IIOHandler {

	public Input readInput(InputStream stream);
	
	public void writeOutput(OutputStream stream,Output output);
}
