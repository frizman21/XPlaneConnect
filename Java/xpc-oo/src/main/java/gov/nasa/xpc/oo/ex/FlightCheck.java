package gov.nasa.xpc.oo.ex;

import java.io.IOException;
import java.math.BigDecimal;
//import java.net.SocketException;

import gov.nasa.xpc.oo.Aircraft;
import gov.nasa.xpc.oo.Cockpit.Gear;
import gov.nasa.xpc.oo.Joystick;
import gov.nasa.xpc.oo.Joystick.JoystickAxis;

public class FlightCheck {

	public static void main(String[] args) throws InterruptedException, IOException {
		Aircraft aircraft = new Aircraft();
		
		if(!thresholdBasedFloatsComparison(aircraft.getAirSpeed(), 0.0)) {
			System.out.println("Airspeed should be zero: it's " + aircraft.getAirSpeed());
		} 
		
		if(aircraft.getCockpit().getGear().equals(Gear.Up)) {
			System.out.println("Gear should be down");
		}
		
		if(!thresholdBasedFloatsComparison(aircraft.getCockpit().getEngineThrottle(), 0.0)) {
			System.out.println("Throttle should be zero: it's " + aircraft.getCockpit().getEngineThrottle());	
		}
		
		System.out.println("enabling joystick controls");
		Joystick stick = aircraft.getCockpit().getJoystick();
		stick.enableJoystickAxis(JoystickAxis.Heading);
		stick.enableJoystickAxis(JoystickAxis.Pitch);
		stick.enableJoystickAxis(JoystickAxis.Roll);		
	}
	
	
	public static boolean compare(double v0, double v1, double threshold) {
		BigDecimal b0 = new BigDecimal(v0);
		BigDecimal b1 = new BigDecimal(v1);
		
//		System.out.println(b0.compareTo(b1));
		
		return b0.compareTo(b1) == 0;
	}
	
	public static boolean compare(double v0, double v1) {
		BigDecimal b0 = new BigDecimal(v0);
		BigDecimal b1 = new BigDecimal(v1);
		
//		System.out.println(b0.compareTo(b1));
		
		return b0.compareTo(b1) == 0;
	}
	
	private static boolean thresholdBasedFloatsComparison(double f1, double f2) {
		final double THRESHOLD = .001;
		
		return thresholdBasedFloatsComparison(f1,f2,THRESHOLD);
	}	
	
	private static boolean thresholdBasedFloatsComparison(double f1, double f2, double threshold) 
	{	 
		return Math.abs(f1 - f2) < threshold;
	}
	 

	

}
