/**
 * 
 */
package me.tingri.projects.marsrovers.iohandlers;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import me.tingri.projects.marsrovers.IIOHandler;
import me.tingri.projects.marsrovers.common.exception.ExceptionCodes;
import me.tingri.projects.marsrovers.common.exception.InputException;
import me.tingri.projects.marsrovers.common.util.Constants;
import me.tingri.projects.marsrovers.common.util.Utility;
import me.tingri.projects.marsrovers.data.CompassPoint;
import me.tingri.projects.marsrovers.data.ControlInstruction;
import me.tingri.projects.marsrovers.data.Input;
import me.tingri.projects.marsrovers.data.Output;
import me.tingri.projects.marsrovers.data.Plateau;
import me.tingri.projects.marsrovers.data.Point;
import me.tingri.projects.marsrovers.data.Position;
import me.tingri.projects.marsrovers.data.RoverInput;
import me.tingri.projects.marsrovers.data.RoverOutput;



/**
 * @author SANDEEP
 *
 */
public class IOHandler implements IIOHandler {

	private static final int STOP = 0;
	private static final int CONTINUE = 1;

	/* (non-Javadoc)
	 * @see com.thoughtworks.marsrovers.IIOHandler#readInput()
	 */
	@Override
	public Input readInput(InputStream stream){
		Scanner in = new Scanner(stream);

		Plateau plateau = readPlateau(in);
		Input input = new Input(plateau);

		while (in.hasNextLine()) {
			int action = readRoverInput(plateau, in, input);
			
			if(action == STOP){
				break;
			}
		}
		
		return input;
	}
	
	private Plateau readPlateau(Scanner consoleScanner){
		int upperRightCornerX = readCoordinate(consoleScanner, Constants.X);
		int upperRightCornerY = readCoordinate(consoleScanner, Constants.Y);;
		
		if(consoleScanner.findInLine("[^\n]") != null){
			throw new InputException(ExceptionCodes.ROV_INPUT_009,String.valueOf(upperRightCornerX), String.valueOf(upperRightCornerY), consoleScanner.next());
		}
		
		return new Plateau(new Point(upperRightCornerX, upperRightCornerY));
		
	}
	
	private int readCoordinate(Scanner consoleScanner, String coordinateType){
		if(consoleScanner.hasNextInt()){
			int value = consoleScanner.nextInt();
			
			if(value < 0){
				throw new InputException(ExceptionCodes.ROV_INPUT_007, coordinateType, String.valueOf(value));
			}
			return value;
		} else if(consoleScanner.hasNext()){
			throw new InputException(ExceptionCodes.ROV_INPUT_007, coordinateType, consoleScanner.next());
		}  else {
			throw new InputException(ExceptionCodes.ROV_INPUT_006, coordinateType);
		}
	}
	
	private int readRoverInput(Plateau plateau, Scanner consoleScanner, Input input){
		int numOfRovers = input.getRoversInput().size();
		
		if(input.getRoversInput().size() == 0 &&  !consoleScanner.hasNext()){
			throw new InputException(ExceptionCodes.ROV_INPUT_013);
		} 
		
		RoverInput newRoverInput = new RoverInput(numOfRovers + 1);
		
		readRoverPosition(plateau,consoleScanner,newRoverInput);
		readControlInstructions(consoleScanner, newRoverInput);
		
		input.addRoverInput(newRoverInput);
		
		if(!consoleScanner.hasNextInt()){
			return STOP;
		}
		
		return CONTINUE;
	}
	
	private void readRoverPosition(Plateau plateau,Scanner consoleScanner, RoverInput input){
		Position position = new Position();
		Point upperRightCorner = plateau.getUpperRightCorner();
		int x = readRoverCoordinate(consoleScanner,Constants.X,upperRightCorner.getX(), input.getRoverId());
		int y = readRoverCoordinate(consoleScanner,Constants.Y,upperRightCorner.getY(), input.getRoverId());
		
		position.setPoint(new Point(x, y));
		
		if(consoleScanner.hasNext("[N|n|S|s|E|e|W|w]")){
			String orientationString = consoleScanner.next();			
			CompassPoint orientation = Utility.getCompassPoint(orientationString);
			
			if(orientation == null){
				throw new InputException(ExceptionCodes.ROV_INPUT_002, orientationString, String.valueOf(input.getRoverId()));
			}
			
			position.setOrientation(orientation);
			
			input.setPosition(position);
		} else if(consoleScanner.hasNext()){
			throw new InputException(ExceptionCodes.ROV_INPUT_002,consoleScanner.next(), String.valueOf(input.getRoverId()));
		} else {
			throw new InputException(ExceptionCodes.ROV_INPUT_001);
		}
		
		if(consoleScanner.findInLine("[^\n]") != null){
			throw new InputException(ExceptionCodes.ROV_INPUT_010,String.valueOf(x), String.valueOf(y),
					String.valueOf(position.getOrientation()), consoleScanner.next());
		}
	}
	
	private int readRoverCoordinate(Scanner consoleScanner, String coordinateType,int upperLimit,int roverId){		
		if(consoleScanner.hasNextInt()){
			int value = consoleScanner.nextInt();
			
			if(value < 0){
				throw new InputException(ExceptionCodes.ROV_INPUT_007, coordinateType, String.valueOf(value));
			} else if(value > upperLimit){
				throw new InputException(ExceptionCodes.ROV_INPUT_012, coordinateType, String.valueOf(value),
						String.valueOf(upperLimit), String.valueOf(roverId));
			}
			
			return value;
		}  else if(consoleScanner.hasNext()){
			throw new InputException(ExceptionCodes.ROV_INPUT_008, coordinateType, consoleScanner.next(), String.valueOf(roverId));
		}  else {
			throw new InputException(ExceptionCodes.ROV_INPUT_006, coordinateType);
		}
	}
	
	private void readControlInstructions(Scanner consoleScanner, RoverInput input){
		String instrLn = null;
		
		if(consoleScanner.hasNext("[L|l|R|r|M|m]*")){
			instrLn = consoleScanner.next();
			
			if(consoleScanner.findInLine("[^\n]") != null){
				throw new InputException(ExceptionCodes.ROV_INPUT_011,instrLn, consoleScanner.next());
			}
			
			int numOfInstructions = instrLn.length();
			
			for (int i = 0; i < numOfInstructions; i++) {
				char instrChar = instrLn.charAt(i);
				ControlInstruction instruction = Utility.getControlInstruction(instrChar);
				
				if(instruction == null){
					throw new InputException(ExceptionCodes.ROV_INPUT_005,String.valueOf(instrChar) , String.valueOf(input.getRoverId()));
				}
				
				input.addInstruction(instruction);			
			}
		} else if(consoleScanner.hasNext()){
			throw new InputException(ExceptionCodes.ROV_INPUT_004, consoleScanner.next(), String.valueOf(input.getRoverId()));
		} else {
			throw new InputException(ExceptionCodes.ROV_INPUT_003 );
		}
	}

	@Override
	public void writeOutput(OutputStream out,Output output) {
		ArrayList<RoverOutput> roversoutput = output.getRoverOutput();
		PrintWriter writer = new PrintWriter(out);
		
		for (RoverOutput roverOutput : roversoutput) {
			Point point = roverOutput.getPosition().getPoint();
			CompassPoint orientation  = roverOutput.getPosition().getOrientation();
			
			writer.println("\nOutput for rover:"+ roverOutput.getRoverId());
			writer.println("--------------------");
			writer.println(point.getX() + " " + point.getY() + " " + orientation);
		}
		
		writer.flush();
		writer.close();
	}
	
}
