package me.tingri.projects.marsrovers;

import me.tingri.projects.marsrovers.common.exception.MovementException;
import me.tingri.projects.marsrovers.data.Plateau;
import me.tingri.projects.marsrovers.data.RoverInput;
import me.tingri.projects.marsrovers.data.RoverOutput;

public interface IProcessor {

	public RoverOutput process(Plateau plateau,RoverInput input) throws MovementException;
}
