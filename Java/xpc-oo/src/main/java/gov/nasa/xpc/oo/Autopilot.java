package gov.nasa.xpc.oo;

import java.io.IOException;

import gov.nasa.xpc.XPlaneConnect;

/**
 * Definition of autopilot constants comes from
 * http://www.xsquawkbox.net/xpsdk/mediawiki/Sim/cockpit/autopilot/autopilot_state
 * @author mike
 *
 */
public class Autopilot extends Base {

	public Autopilot(XPlaneConnect xpc) {
		super(xpc);
	}
	
	public static final String AIR_SPEED_DREF   = "sim/cockpit/autopilot/airspeed";
	public static final String HEADING_MAG_DREF = "sim/cockpit/autopilot/heading_mag";
	public static final String ALTITUDE_DREF    = "sim/cockpit/autopilot/altitude";
	public static final String VERTICAL_VELOCITY_DREF = "sim/cockpit/autopilot/vertical_velocity";
	    	
	public void setAirspeed(float value) throws IOException {
		xpc.sendDREF(Autopilot.AIR_SPEED_DREF, value);
	}

	public void setAltitude(float value) throws IOException {
		xpc.sendDREF(Autopilot.ALTITUDE_DREF, value);
	}

	public void setHeadingMagnetic(float value) throws IOException {
		xpc.sendDREF(Autopilot.HEADING_MAG_DREF, value);
	}
	
	enum Mode {
		Off(0), FlightDirector(1), On(2);
		
		int value;
		
		Mode(int value) {
			this.value = value;
		}

		int getValue() {
			return value;
		}
	}
	
	public static final String AUTOPILOT_MODE_DREF = "sim/cockpit/autopilot/autopilot_mode";
	
	public void setMode(Mode mode) throws IOException {
		xpc.sendDREF(AUTOPILOT_MODE_DREF, mode.getValue());
	}
	
	public static final String AUTOPILOT_STATE_DREF = "sim/cockpit/autopilot/autopilot_state";
	
	/**
	 * Autothrottle Engage
	 */
	public static int STATE_AUTOTHROTTLE = 1;
	
	/**
	 * Heading Hold Engage 
	 */
	public static int STATE_HEADING = 2;
	
	 
	/**
	 * Wing Leveler Engage 
	 */
	public static int STATE_WING_LEVEL = 4;
	
	/**
	 * Airspeed Hold With Pitch Engage 
	 */
	public static int STATE_AIRSPEED     = 8;
	
	public static int STATE_VVI_CLIMB_ENGAGE = 16;
	public static int STATE_ALTITUDE     = 32;
	
	enum State {
		Autothrottle(1), 
		Heading(2), 
		Airspeed(8),
		Altitude(32);
		
		int value;
		
		State(int value) {
			this.value = value;
		}

		int getValue() {
			return value;
		}
	}
	
	public void toggleState(State state) throws IOException {
		xpc.sendDREF(AUTOPILOT_STATE_DREF, state.getValue());
	}
	
	public void changeToAltitude(float altitude, float verticalVelocity) throws IOException {
    	xpc.sendDREF(ALTITUDE_DREF, altitude);
    	xpc.sendDREF(VERTICAL_VELOCITY_DREF, verticalVelocity);
		xpc.sendDREF(AUTOPILOT_STATE_DREF, STATE_VVI_CLIMB_ENGAGE);
		xpc.sendDREF(AUTOPILOT_STATE_DREF, STATE_ALTITUDE);
	}
	
}
