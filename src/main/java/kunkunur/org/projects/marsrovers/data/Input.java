package kunkunur.org.projects.marsrovers.data;

import java.util.ArrayList;

public class Input {
	private Plateau plateau;
	private ArrayList<RoverInput> roverInput = new ArrayList<RoverInput>();
	
	public Input(Plateau plateau){
		this.plateau = plateau;
	}
	
	/**
	 * @return the plateau
	 */
	public Plateau getPlateau() {
		return plateau;
	}

	
	public void addRoverInput(RoverInput roverInput){
		this.roverInput.add(roverInput);
	}
	
	/**
	 * @return the roverInput
	 */
	public ArrayList<RoverInput> getRoversInput() {
		return roverInput;
	}
	
	/**
	 * @param roverInput the roverInput to set
	 */
	public void setRoverInput(ArrayList<RoverInput> roverInput) {
		this.roverInput = roverInput;
	}
}
