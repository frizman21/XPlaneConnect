package gov.nasa.xpc.oo;

import java.io.IOException;

import gov.nasa.xpc.XPlaneConnect;

public class Joystick extends Base {

	public Joystick(XPlaneConnect xpc, Aircraft aircraft) {
		super(xpc, aircraft);
	}
	
	public static final String JOYSTICK_PITCH_OVERRIDE_DREF   = "sim/operation/override/override_joystick_pitch";
	public static final String JOYSTICK_HEADING_OVERRIDE_DREF = "sim/operation/override/override_joystick_heading";
	public static final String JOYSTICK_ROLL_OVERRIDE_DREF    = "sim/operation/override/override_joystick_roll";
	public static final String JOYSTICK_HEADING_RATIO_DREF    = "sim/joystick/yoke_heading_ratio";
	public static final String JOYSTICK_PITCH_RATIO_DREF      = "sim/joystick/yoke_pitch_ratio";

	public enum Mode {
		Override(1), Normal(0);
		
		int value;
		
		Mode(int value) {
			this.value = value;
		}

		int getValue() {
			return value;
		}
	}
	
	public enum JoystickAxis {
		Heading(JOYSTICK_HEADING_OVERRIDE_DREF), 
		Pitch(JOYSTICK_PITCH_OVERRIDE_DREF), 
		Roll(JOYSTICK_ROLL_OVERRIDE_DREF);
	
		private String dref;
		
		JoystickAxis(String dref) {
			this.dref = dref;
		}

		String getDref() {
			return dref;
		}	
	}
	
	public void disableJoystickAxis(JoystickAxis axis) throws IOException {
		setJoystickAxis(axis, Mode.Override);
	}
	
	public void enableJoystickAxis(JoystickAxis axis) throws IOException {
		setJoystickAxis(axis, Mode.Normal);
	}
	
	public void setJoystickAxis(JoystickAxis axis, Mode mode) throws IOException {
		xpc.sendDREF(axis.getDref(), mode.getValue());
	}
	
	/**
	 * 
	 * @param value between -1.0f and 1.0f
	 * @throws IOException 
	 */
	public void setHeadingRatio(float value) throws IOException {
		xpc.sendDREF(JOYSTICK_HEADING_RATIO_DREF, value);
	}
	
	/**
	 * 
	 * @param value between -1.0f and 1.0f
	 * @throws IOException
	 */
	public void setPitchRatio(float value) throws IOException {
		xpc.sendDREF(JOYSTICK_PITCH_RATIO_DREF, value);	
	}
}
