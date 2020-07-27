package gov.nasa.xpc.oo;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PositionTest {
	
	
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
	public void bearingNorthTest() {
		Position laxPos      = new Position(33.9416, -118.4085, 0);
		Position laxPosNorth = new Position(34.9416, -118.4085, 0);
		
//		Position sfaPos = new Position(37.6213, -122.3790, 0);
		
		double bearing = laxPos.bearing(laxPosNorth);
		
		assertEquals(0.0, bearing, .1);
	}
	
	@Test
	public void bearingSouthTest() {
		Position laxPos      = new Position(33.9416, -118.4085, 0);
		Position laxPosSouth = new Position(32.9416, -118.4085, 0);
				
		double bearing = laxPos.bearing(laxPosSouth);
		
		assertEquals(180.0, bearing, .1);
	}
	
	@Test
	public void bearingEastTest() {
		Position laxPos     = new Position(33.9416, -118.4085, 0);
		Position laxPosEast = new Position(33.9416, -117.4085, 0);
				
		double bearing = laxPos.bearing(laxPosEast);
		
		assertEquals(90.0, bearing, 18);
	}
	
	@Test
	public void bearingEast2Test() {
		Position laxPos     = new Position(0.0, 12.0, 0);
		Position laxPosWest = new Position(0.0, 13.0, 0);
				
		double bearing = laxPos.bearing(laxPosWest);
		
		assertEquals(90.0, bearing, .1);
	}

	@Test
	public void bearingTest() {
		Position laxPos = new Position(33.9416, -118.4085, 0);
		Position sfaPos = new Position(37.6213, -122.3790, 0);
				
		double bearing = laxPos.bearing(sfaPos);
		
		assertEquals(318.81, bearing, 1.5);
	}

}
