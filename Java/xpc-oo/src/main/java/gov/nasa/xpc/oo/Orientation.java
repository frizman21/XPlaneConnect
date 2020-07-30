package gov.nasa.xpc.oo;

public class Orientation {
	public double pitch, roll;

	public Orientation(double pitch, double roll) {
		super();
		this.pitch = pitch;
		this.roll = roll;
	}
	
	Orientation(double[] posi) {
		this.pitch = posi[3];
		this.roll = posi[4];
	}

	public double getPitch() {
		return pitch;
	}

	public double getRoll() {
		return roll;
	}
}
