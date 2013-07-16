package kunkunur.org.projects.marsrovers;

import kunkunur.org.projects.marsrovers.common.exception.MovementException;
import kunkunur.org.projects.marsrovers.data.Plateau;
import kunkunur.org.projects.marsrovers.data.RoverInput;
import kunkunur.org.projects.marsrovers.data.RoverOutput;

public interface IProcessor {

	public RoverOutput process(Plateau plateau,RoverInput input) throws MovementException;
}
