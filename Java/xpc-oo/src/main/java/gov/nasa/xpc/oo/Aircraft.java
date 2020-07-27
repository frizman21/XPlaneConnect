package gov.nasa.xpc.oo;

import java.io.IOException;
import java.net.SocketException;
import java.util.concurrent.Semaphore;

import gov.nasa.xpc.XPlaneConnect;

public class Aircraft {

	private static XPlaneConnect xpcSingleton;
	private static Semaphore xpcLock = new Semaphore(1);
	
	private static int AIRCRAFT_ID = 0;
	
	static XPlaneConnect getXPC() throws SocketException, InterruptedException {
		
		xpcLock.acquire();
		
		if(xpcSingleton == null) {
			xpcSingleton = new XPlaneConnect();
		}
		
		xpcLock.release();
		
		return xpcSingleton;
		
	}
	
	private XPlaneConnect xpc;
	private Cockpit cockpit;
	private Autopilot autopilot;
	
	public Aircraft(XPlaneConnect xpc) {		
		cockpit = new Cockpit(xpc, this);
		autopilot = new Autopilot(xpc, this);
	}
	
	public Aircraft() throws SocketException, InterruptedException {
		xpc = Aircraft.getXPC();
		
		cockpit = new Cockpit(xpc, this);
		autopilot = new Autopilot(xpc, this);
	}
	
	public Position getPosition() throws IOException {
		double[] posi = xpc.getPOSI(AIRCRAFT_ID); 
		return new Position(posi);
	}
	
	public Control getControl() throws IOException {
		float[] posi = xpc.getCTRL(AIRCRAFT_ID); 
		return new Control(posi);
	}
	
	public float getAltitude() throws IOException {
		int aircraft = 0;
		double[] posi = xpc.getPOSI(aircraft);
		return (float) posi[2];
	}
	
	public float getHeading() throws IOException {
		return xpc.getDREF("sim/flightmodel/position/true_psi")[0];
	}
	
	public float getAirSpeed() throws IOException {
		return xpc.getDREF("sim/flightmodel/position/true_airspeed")[0];
	}

	public Cockpit getCockpit() {
		return cockpit;
	}

	public Autopilot getAutopilot() {
		return autopilot;
	}
	
}
