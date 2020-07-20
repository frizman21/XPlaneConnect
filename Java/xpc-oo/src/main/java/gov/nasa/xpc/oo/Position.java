package gov.nasa.xpc.oo;

public class Position {
	public double x,y,z;
	
	public Position(double x, double y, double z) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public Position(double[] posi) {
		this(posi[0],posi[1],posi[2]);
	}
	
}
