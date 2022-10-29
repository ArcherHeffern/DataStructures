/**
* This class represents a Rider on the red line. A rider has an ID, starting station, 
* destination station, and a direction.
* Known Bugs: None
*
* @author Archer Heffern
* hefferna@brandeis.edu
* 10/15/22
* COSI 21A PA1
*/

package main;

import java.security.InvalidParameterException;

public class Rider {
	
	private String riderID;
	private String startingStation;
	private String destinationStation;
	private boolean direction;	// true if going north, false if going south

	/**
	 * Constructs new Rider instance with riderID, startingStation, and destinationStation
	 * @param riderID
	 * @param startingStation
	 * @param destinationStation
	 */
	public Rider(String riderID, String startingStation, String destinationStation) {
		if (riderID == null || startingStation == null || destinationStation == null) throw new InvalidParameterException();
		this.riderID = riderID;
		this.startingStation = startingStation;
		this.destinationStation = destinationStation;
		this.direction = false;
	}
	
	/**
	 * Gets riders starting station
	 * @return name of this Rider’s starting station
	 * O(1)
	 */
	public String getStarting() {
		return startingStation;
	}
	
	/**
	 * Gets riders ending station
	 * @return name of this Rider’s ending station
	 * O(1)
	 */
	public String getDestination() {
		return destinationStation;
	}
	
	/**
	 * Gets riders ID
	 * @return riderID
	 * O(1)
	 */
	public String getRiderID() {
		return riderID;
	}
	
	/**
	 * Gets direction of Rider
	 * @return true if this Rider is northbound. Else, false.
	 * O(q)
	 */
	public boolean goingNorth() {	
		return direction;
	}
	
	/**
	 * swaps the Rider’s current direction
	 * O(1)
	 */
	public void swapDirection() {
		direction = !direction;
	}
	
	/**
	 * toString method
	 * @return String representation of this Rider
	 * O(n)
	 */
	@Override
	public String toString() {
		return "[" + riderID + ", " + startingStation + ", " + destinationStation + ", " + (direction ? "North":"South") + "]";
		
	}
	
	/**
	 * Compares Object o and this Rider
	 * @return boolean if riderID is the same
	 * O(1)
	 */
	@Override
	public boolean equals(Object s) {
		if (s instanceof Rider) {
			return ((Rider) s).getRiderID().equals(riderID);
		}
		return false;
	}
}
