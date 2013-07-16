package kunkunur.org.projects.marsrovers;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import kunkunur.org.projects.marsrovers.common.exception.MovementException;
import kunkunur.org.projects.marsrovers.common.util.Constants;
import kunkunur.org.projects.marsrovers.common.util.Factory;
import kunkunur.org.projects.marsrovers.data.Input;
import kunkunur.org.projects.marsrovers.data.Output;
import kunkunur.org.projects.marsrovers.data.Plateau;
import kunkunur.org.projects.marsrovers.data.RoverInput;


public class MarsRovers {
	private static final IProcessor PROCESSOR;
	private static final IIOHandler IO_HANDLER;
	private static final InputStream ISTREAM;
	private static final OutputStream OSTREAM;
	
	static{
		IO_HANDLER = (IIOHandler) Factory.getSingletonInstance(Constants.IO_HANDLER);
		PROCESSOR = (IProcessor) Factory.getSingletonInstance(Constants.PROCESSOR);
		ISTREAM = Factory.getInputStream();
		OSTREAM = Factory.getOutputStream();
			
	}
	
	public static void main(String[] args) throws MovementException {
		process();
	}
	
	public static void process() throws MovementException {
		Input input = IO_HANDLER.readInput(ISTREAM);		
		Plateau plateau = input.getPlateau();
		Output output = new Output(plateau);
		
		ArrayList<RoverInput> roversInput = input.getRoversInput();
		int numberOfRovers = roversInput.size();
		
		for (int i = 0; i < numberOfRovers; i++) {
			output.addRoverOutput(PROCESSOR.process(plateau, roversInput.get(i)));
		}
		
		IO_HANDLER.writeOutput(OSTREAM,output);
	}


}
