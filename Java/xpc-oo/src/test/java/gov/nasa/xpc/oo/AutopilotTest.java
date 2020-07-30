package gov.nasa.xpc.oo;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.SocketException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import gov.nasa.xpc.oo.Autopilot.State;

public class AutopilotTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws InterruptedException, IOException {
		Aircraft craft = new Aircraft();
		Autopilot pilot = craft.getAutopilot();
		
//		pilot.setState(State.Autothrottle, true);
		
		System.out.println("autothrottle: " + pilot.isState(State.Autothrottle));
		System.out.println("heading:      " + pilot.isState(State.Heading));
		System.out.println("Altitude:     " + pilot.isState(State.Altitude));
		System.out.println("vviClimb:     " + pilot.isState(State.vviClimb));
		System.out.println("WingLevel:    " + pilot.isState(State.WingLevel));
		System.out.println("AltitudeHoldEngaged:" + pilot.isState(State.AltitudeHoldEngaged));
		
		
		
		
	}

}
