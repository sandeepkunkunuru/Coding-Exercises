package kunkunur.org.projects.marsrovers.data;


/**
 * This class represents the position of the rover.
 * It is mutable.
 * 
 * @author SANDEEP
 *
 */
public class Position {
	private Point point;
	private CompassPoint orientation;
	
	public Position(){
	}

	public Point getPoint() {
		return point;
	}

	public CompassPoint getOrientation() {
		return orientation;
	}

	public void setPoint(Point point) {
		this.point = point;
	}

	public void setOrientation(CompassPoint orientation) {
		this.orientation = orientation;
	}
	
	public Position clone(){
		Position newPosition = new Position();
		
		newPosition.setOrientation(this.orientation);//Enums are singletons
		newPosition.setPoint(this.point.clone());
		
		return newPosition;
	}
	
	@Override
	public String toString(){
		return "Position: {\n Coordinates:{\n" + this.point.toString() +"\n}"
			+ "Orientation:" + this.orientation.getDescription()
			+"\n}";
	}
	
}
