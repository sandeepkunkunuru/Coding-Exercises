package me.tingri.projects.marsrovers.data;

public enum ControlInstruction {
	L("Rotate Left by 90 degrees"),
	R("Rotate Right by 90 degrees"),
	M("Move by 1 Unit");
	
	private String description;

	private ControlInstruction(String description){
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}
