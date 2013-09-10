package me.tingri.projects.marsrovers.data;

public class RoverOutput {
	private int roverId ;
	private Position position;
	
	public RoverOutput(int roverId){
		this.roverId = roverId;
	}
	
	/**
	 * @return the roverId
	 */
	public int getRoverId() {
		return roverId;
	}

	/**
	 * @return the position
	 */
	public Position getPosition() {
		return position;
	}
	/**
	 * @param position the position to set
	 */
	public void setPosition(Position position) {
		this.position = position;
	}
	
	@Override
	public String toString(){
		return "RoverOutput:{\n" + "RoverId:" + this.roverId + "\n" 
			+ "RoverPosition:{\n" + this.position.toString()+ "}\n"
			+"}";
	}
	
}
