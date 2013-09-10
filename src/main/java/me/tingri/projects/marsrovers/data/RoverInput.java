package me.tingri.projects.marsrovers.data;

import java.util.ArrayList;

/**
 * @author SANDEEP
 *
 */
public class RoverInput{
	private int roverId ;
	private Position position;
	private ArrayList<ControlInstruction> instructions = new ArrayList<ControlInstruction>();
	
	public RoverInput(int roverId){
		this.roverId = roverId;
	}
	
	public int getRoverId() {
		return roverId;
	}
	
	public Position getPosition() {
		return position;
	}
	
	public void setPosition(Position position) {
		this.position = position;
	}
	
	/**
	 * @param controlInstruction
	 */
	public void addInstruction(ControlInstruction controlInstruction){
		this.instructions.add(controlInstruction);
	}
	
	/**
	 * @return
	 */
	public ArrayList<ControlInstruction> getInstructions() {
		return instructions;
	}
	
	public void setInstructions(ArrayList<ControlInstruction> instructions) {
		this.instructions = instructions;
	}	
}

