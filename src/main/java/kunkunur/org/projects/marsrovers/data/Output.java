package kunkunur.org.projects.marsrovers.data;

import java.util.ArrayList;

public class Output {
	private Plateau plateau;
	private ArrayList<RoverOutput> roverOutput = new ArrayList<RoverOutput>();
	
	public Output(Plateau plateau){
		this.plateau = plateau;
	}
	
	/**
	 * @return the plateau
	 */
	public Plateau getPlateau() {
		return plateau;
	}

	
	public void addRoverOutput(RoverOutput roverOutput){
		this.roverOutput.add(roverOutput);
	}
	
	/**
	 * @return the roverContent
	 */
	public ArrayList<RoverOutput> getRoverOutput() {
		return roverOutput;
	}
	
	/**
	 * @param roverContent the roverContent to set
	 */
	public void setRoverOutput(ArrayList<RoverOutput> roverOutput) {
		this.roverOutput = roverOutput;
	}
	
	@Override
	public String toString(){
		StringBuffer strBuf = new StringBuffer();
		
		strBuf.append(plateau.toString()).append("\n");
		
		int numberofRovers = this.roverOutput.size();
		
		for (int i = 0; i < numberofRovers; i++) {
			strBuf.append(this.roverOutput.get(i).toString());
		}
		
		return strBuf.toString();
	}

	
}
