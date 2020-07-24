package gov.nasa.xpc.oo;

import java.io.IOException;

import gov.nasa.xpc.XPlaneConnect;

public class Cockpit extends Base {

	private Joystick joystick;
	
	public Cockpit(XPlaneConnect xpc) {
		super(xpc);
		
		joystick = new Joystick(xpc);
	}
	
	public void setParkingBrake(boolean isBrakeSet) throws IOException {
		
		xpc.sendDREF(PARKING_BRAKE_DREF, 
				     isBrakeSet ? PARKING_BRAKE_ON : PARKING_BRAKE_OFF);
		
	}

	public static final String PARKING_BRAKE_DREF = "sim/flightmodel/controls/parkbrake";
	public static final float  PARKING_BRAKE_ON   = 1.0f;
	public static final float  PARKING_BRAKE_OFF  = 0.0f;
	
	/**
	 * 
	 * @param value must be between 0.0f and 1.0f
	 * @throws IOException 
	 */
	public void setEngineThrottle(float value) throws IOException {
		if(value < 0.0f || value > 1.0f) {
			throw new IllegalArgumentException("throttle must be between 0 and 1 (inclusive)");
		}
		
		xpc.sendDREF(ENGINE_THROTTLE_DREF, value);
	}
	
	public float getEngineThrottle() throws IOException {
		float value = xpc.getDREF(ENGINE_THROTTLE_DREF)[0];
		return value;
	}
	
	public static final String ENGINE_THROTTLE_DREF = "sim/flightmodel/engine/ENGN_thro";
	
	
	public static final String GEAR_HANDLE_DREF = "sim/cockpit/switches/gear_handle_status";
	public static final int  GEAR_UP   		= 0;
	public static final int  GEAR_DOWN   		= 1;
	
	public enum Gear {
		Up, Down
	}
	
	public void setGear(Gear gear) throws IOException {
		xpc.sendDREF(GEAR_HANDLE_DREF, gear.ordinal());
	}
	
	public Gear getGear() throws IOException {
		float value = xpc.getDREF(GEAR_HANDLE_DREF)[0];
		int index = (int) value;
		return Gear.values()[index];	
	}
	
	public Joystick getJoystick() {
		return joystick;
	}
}
