package kunkunur.org.projects.marsrovers.processor;

import java.util.ArrayList;

import kunkunur.org.projects.marsrovers.IProcessor;
import kunkunur.org.projects.marsrovers.common.exception.ExceptionCodes;
import kunkunur.org.projects.marsrovers.common.exception.InputException;
import kunkunur.org.projects.marsrovers.common.exception.MovementException;
import kunkunur.org.projects.marsrovers.common.util.Constants;
import kunkunur.org.projects.marsrovers.data.CompassPoint;
import kunkunur.org.projects.marsrovers.data.ControlInstruction;
import kunkunur.org.projects.marsrovers.data.Plateau;
import kunkunur.org.projects.marsrovers.data.Point;
import kunkunur.org.projects.marsrovers.data.Position;
import kunkunur.org.projects.marsrovers.data.RoverInput;
import kunkunur.org.projects.marsrovers.data.RoverOutput;


public class Processor implements IProcessor {

	
	public RoverOutput process(Plateau plateau, RoverInput roverInput) throws MovementException {
		int roverId = roverInput.getRoverId();
		ArrayList<ControlInstruction> instructions = roverInput.getInstructions();		
		int numberOfInstructions = instructions.size();
		RoverOutput output = new RoverOutput(roverId);
		
		Position currentPosition = roverInput.getPosition();
		
		for (int i = 0; i < numberOfInstructions; i++) {			
			processInstruction(plateau, currentPosition, instructions.get(i));
		}
		
		output.setPosition(currentPosition);
		
		return output;
	}

	private void processInstruction(Plateau plateau, Position currentPosition,
			ControlInstruction instruction) throws MovementException {
		
		if(instruction == null){
			throw new InputException(ExceptionCodes.ROV_INPUT_003);
		}
		
		switch (instruction) {
		case L:
			processLInstruction(plateau, currentPosition);
			break;
		case R:
			processRInstruction(plateau, currentPosition);
			break;
		case M:
			processMInstruction(plateau, currentPosition);
			break;
		default:
			throw new InputException(ExceptionCodes.ROV_INPUT_014, String.valueOf(instruction));
		}
	}

	private void processLInstruction(Plateau plateau,Position currentPosition)
			throws MovementException {
		
		CompassPoint orientation = currentPosition.getOrientation();
		
		if(orientation == null){
			throw new InputException(ExceptionCodes.ROV_INPUT_001);
		}
		
		switch(orientation){
		case E:
			currentPosition.setOrientation(CompassPoint.N);
			break;
		case N:
			currentPosition.setOrientation(CompassPoint.W);
			break;
		case W:
			currentPosition.setOrientation(CompassPoint.S);
			break;
		case S:
			currentPosition.setOrientation(CompassPoint.E);
			break;
		default:
			throw new InputException(ExceptionCodes.ROV_INPUT_015, String.valueOf(orientation));

		}
		
	}

	private void processRInstruction(Plateau plateau,Position currentPosition)
			throws MovementException {
		CompassPoint orientation = currentPosition.getOrientation();
		
		if(orientation == null){
			throw new InputException(ExceptionCodes.ROV_INPUT_001);
		}
		
		switch(orientation){
		case E:
			currentPosition.setOrientation(CompassPoint.S);
			break;
		case N:
			currentPosition.setOrientation(CompassPoint.E);
			break;
		case W:
			currentPosition.setOrientation(CompassPoint.N);
			break;
		case S:
			currentPosition.setOrientation(CompassPoint.W);
			break;
		default:
			throw new InputException(ExceptionCodes.ROV_INPUT_015, String.valueOf(orientation));
		}
	}

	private void processMInstruction(Plateau plateau,Position currentPosition)
			throws MovementException {
		Point currentPoint = currentPosition.getPoint();		
		CompassPoint orientation = currentPosition.getOrientation();

		validate(plateau,currentPosition);

		switch(orientation){
		case E:			
			currentPosition.setPoint(new Point(currentPoint.getX() + 1, currentPoint.getY()));
			break;
		case N:
			currentPosition.setPoint(new Point(currentPoint.getX(), currentPoint.getY() + 1));
			break;
		case W:
			currentPosition.setPoint(new Point(currentPoint.getX() - 1, currentPoint.getY()));
			break;
		case S:
			currentPosition.setPoint(new Point(currentPoint.getX(), currentPoint.getY() - 1));
			break;
		}
	}
	
	private void validate(Plateau plateau,Position currentPosition)
		throws MovementException {
		Point currentPoint = currentPosition.getPoint();		
		CompassPoint orientation = currentPosition.getOrientation();
		
		if(orientation == null){
			throw new InputException(ExceptionCodes.ROV_INPUT_001);
		}
		
		Point upperRightPoint = plateau.getUpperRightCorner();
		Point origin = plateau.getOrigin();
		
		switch(orientation){
		case E:	
			if(currentPoint.getX() + 1 > upperRightPoint.getX()){
				throw new MovementException(ExceptionCodes.ROV_MOVEMENT_001,String.valueOf(currentPoint.getX()), 
						String.valueOf(currentPoint.getY()), Constants.X,
						String.valueOf(currentPoint.getX() + 1), String.valueOf(upperRightPoint.getX()));
			}
			
			break;
		case N:
			if(currentPoint.getY() + 1 > upperRightPoint.getY()){
				throw new MovementException(ExceptionCodes.ROV_MOVEMENT_001,String.valueOf(currentPoint.getX()), 
						String.valueOf(currentPoint.getY()), Constants.Y,
						String.valueOf(currentPoint.getY() + 1), String.valueOf(upperRightPoint.getY()));
			}
			
			break;
		case W:
			if(currentPoint.getX() - 1 < origin.getX()){
				throw new MovementException(ExceptionCodes.ROV_MOVEMENT_002,String.valueOf(currentPoint.getX()), 
						String.valueOf(currentPoint.getY()), Constants.X,
						String.valueOf(currentPoint.getX() - 1), String.valueOf(origin.getX()));
			}
			
			break;
		case S:
			if(currentPoint.getY() - 1 < origin.getY()){
				throw new MovementException(ExceptionCodes.ROV_MOVEMENT_002,String.valueOf(currentPoint.getX()), 
						String.valueOf(currentPoint.getY()), Constants.Y,
						String.valueOf(currentPoint.getY() - 1), String.valueOf(origin.getY()));
			}
			
			break;
		default:
			throw new MovementException("Orientation is not known");
		}
	
	}

}
