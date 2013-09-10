package me.tingri.projects.marsrovers;

import java.io.InputStream;
import java.io.OutputStream;

import me.tingri.projects.marsrovers.data.Input;
import me.tingri.projects.marsrovers.data.Output;



public interface IIOHandler {

	public Input readInput(InputStream stream);
	
	public void writeOutput(OutputStream stream,Output output);
}
