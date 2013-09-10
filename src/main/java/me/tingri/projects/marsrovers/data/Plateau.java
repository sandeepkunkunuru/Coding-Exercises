package me.tingri.projects.marsrovers.data;

public class Plateau {
	private static final Point origin = new Point(0,0);
	private Point rightCorner ;
	
	public Plateau(Point rightCorner){
		this.rightCorner = rightCorner;
		
	}

	public Point getUpperRightCorner() {
		return this.rightCorner;
	}

	public Point getOrigin() {
		return origin;
	}	
	
	@Override
	public String toString(){
		return "Plateau:{\n Origin: {\n" + origin.toString() +
			    "\n}\n {RightCorner:{\n" + rightCorner.toString() +"\n}\n";
	}
}
