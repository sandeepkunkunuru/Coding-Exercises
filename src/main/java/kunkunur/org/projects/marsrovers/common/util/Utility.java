package kunkunur.org.projects.marsrovers.common.util;

import kunkunur.org.projects.marsrovers.data.CompassPoint;
import kunkunur.org.projects.marsrovers.data.ControlInstruction;

public class Utility {
	private Utility(){
		throw new AssertionError("Utility class cannot be instantiated");
	}
	
	public static CompassPoint getCompassPoint(String next) {
		if(next == null ){
			return null;		
		}
		
		String orientationString = next.trim().toUpperCase();
		
		if(orientationString.length() != 1){
			return null;
		}
		
		char orientation = orientationString.charAt(0);
		
		if(orientation == 'E'){
			return CompassPoint.E;
		} else if(orientation == 'N'){
			return CompassPoint.N;
		} else if(orientation == 'S'){
			return CompassPoint.S;
		} else if(orientation == 'W'){
			return CompassPoint.W;
		} else {
			return null;
		} 

	}

	public static ControlInstruction getControlInstruction(char next) {
		if(next == 'L'){
			return ControlInstruction.L;
		} else if(next == 'R'){
			return ControlInstruction.R;
		} else if(next == 'M'){
			return ControlInstruction.M;
		} else {
			return null;
		} 
	}
}
