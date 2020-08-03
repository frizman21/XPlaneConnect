package gov.nasa.xpc.oo;

import java.io.IOException;
import java.net.SocketException;

public class Simulation {
	//	sim/time/sim_speed
	//	sim/time/sim_speed_actual
	
	public static final String RESET_FLIGHT_DREF  = "sim/operation/reset_flight";
	public static final String PAUSE_STATUS_DREF  = "sim/time/paused";
	public static final String PAUSE_COMMAND_DREF = "sim/operation/pause_toggle";
	public static final float PAUSED = 1.0f;
	
	
	public void resetFlight() throws SocketException, IOException, InterruptedException {
		Aircraft.getXPC().sendCOMM(RESET_FLIGHT_DREF);
	}
	
	public void togglePause() throws SocketException, IOException, InterruptedException {
		Aircraft.getXPC().sendCOMM(PAUSE_COMMAND_DREF);
	}
		
	public boolean isPaused() throws SocketException, IOException, InterruptedException {
		float[] result = Aircraft.getXPC().getDREF(PAUSE_STATUS_DREF);
		return result[0] == PAUSED;
	}
}

