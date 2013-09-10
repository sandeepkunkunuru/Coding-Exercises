package me.tingri.projects.marsrovers.data;


/**
 * @author SANDEEP
 *
 */
public enum CompassPoint {
	E("EAST"), N("North"), W("WEST"), S("SOUTH");
	
	private String description;

	private CompassPoint(String description){
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
	
}
