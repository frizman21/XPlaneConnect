package gov.nasa.xpc.oo;

public class Control {
	
	public float aileron;
	public float elevator;
	public float rudder;
	
	public Control(float aileron, float elevator, float rudder) {
		super();
		
		this.aileron = aileron;
		this.elevator = elevator;
		this.rudder = rudder;
	}
	
	public Control(float[] ctrl) {
		this(ctrl[0],ctrl[1],ctrl[2]);
	}
	
}
