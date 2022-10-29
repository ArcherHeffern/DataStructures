package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import main.Railway;
import main.Station;
import main.Rider;

public class StudentRailwayTest {
	
	private Railway rw;

	@Test
	public void testConstructor() {
		rw = new Railway();
		assertEquals(rw.toString(), "[Alewife, Davis, Porter, Harvard, Central, Kendall/MIT, Charles/MGH, Park Street, Downtown Crossing, South Station, Broadway, Andrew, JFK/UMass, North Quincy, Wollaston, Quincy Center, Quincy Adams, Braintree]");
	}
	
	@Test
	public void testAddStation() {
		rw = new Railway();
		Station s1 = new Station("Station 1");
		Station s2 = new Station("Station 2");
		Station s3 = new Station("Station 3");
		rw.addStation(s1);
		rw.addStation(s2);
		rw.addStation(s3);
		assertEquals("[Station 1, Station 2, Station 3]", rw.toString());
	}
	
	@Test
	public void testAddRider() {
		rw = new Railway();
		Station s1 = new Station("Station 1");
		Station s2 = new Station("Station 2");
		Station s3 = new Station("Station 3");
		rw.addStation(s1);
		rw.addStation(s2);
		rw.addStation(s3);
		Rider r = new Rider("ID: 1", "Station1" , "Station 3");
		rw.addRider(r);
		
		String stuff = "";
		stuff += "Station: " + "Station 1" + "\n";
		stuff += "0 north-bound trains waiting\n";
		stuff += "0 south-bound trains waiting\n";
		stuff += "0 north-bound passengers waiting\n";
		stuff += "1 south-bound passengers waiting";
		
		// test setriderdirection
//		assertFalse(r.goingNorth());
		assertEquals(stuff, s1.toString());
	}
}
