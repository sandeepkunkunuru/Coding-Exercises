package me.tingri.projects.marsrovers.data;

/**
 * POINT is a representation of a point in the plateau.
 * It is immutable and hence can be returned by Plateau post its construction.
 * 
 * @author SANDEEP
 */
public class Point {
	private int x;
	private int y;

	public Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public Point clone(){
		Point newPoint = new Point(this.x, this.y);
	
		return newPoint;
	}
	
	@Override
	public String toString(){
		return "X:" + x + "Y:" + y;
	}
}
