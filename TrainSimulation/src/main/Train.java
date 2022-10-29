/**
* This class represents a Train on the red line. All Trains hold a specified number of
*  passengers in an array, the current number of passengers, the current Station where
*   the Train is, and the Train’s current direction
* Known Bugs: None
*
* @author Archer Heffern
* hefferna@brandeis.edu
* 10/15/22
* COSI 21A PA1
*/

package main;

public class Train {

	public static final int TOTAL_PASSENGERS = 10;
	public Rider[] passengers;
	public int passengerIndex;
	private String currentStation;
	private int direction;	// south (1) north (0)
	
	/**
	 * constructs an empty Train at a given Station going either North or South
	 * @param currentStation the Station the Train starts at
	 * @param direction South (1), North (0)
	 */
	public Train(String currentStation, int direction) {
		if (direction != 0 && direction != 1) throw new IllegalArgumentException();
		this.currentStation = currentStation;
		this.direction = direction;
		passengers = new Rider[TOTAL_PASSENGERS];
		passengerIndex = 0;
	}
	
	/**
	 * Gets direction Train is going
	 * @return true if this Train is northbound, false otherwise
	 * O(1)
	 */
	public boolean goingNorth() {
		return direction == 0;
	}
	
	/**
	 * Swaps direction of train
	 * O(1)
	 */
	public void swapDirection() {
		direction = (direction + 1) % 2;
	}
	
	/**
	 * Gets String of all passengers on train
	 * @return String of the current passengers on the Train
	 * O(n)
	 */
	public String currentPassengers() {
		String passengersString = "";
		for (Rider passenger: passengers) {
			if (passenger != null) {
				passengersString += passenger.getRiderID() + ", " + passenger.getDestination() + "\n";				
			}
		}
		return "[" + passengersString + "]";
	}
	
	/**
	 * adds a passenger to the Train as long as (i) the Rider is at the correct Station to enter the Train, 
	 * (ii) the Train is going in the appropriate direction, and (iii) there is space on the Train.
	 * @return True if operation completed, false if not
	 * O(n)
	 */
	public boolean addPassenger(Rider r) {
		if (!currentStation.equals(r.getStarting())) return false;
		if (goingNorth() != r.goingNorth()) return false;
		if (!hasSpaceForPassengers()) return false;
		int index = 0;
		while (passengers[index] != null) {
			index += 1;
		}
		passengers[index] = r;
		passengerIndex++;
		return true;
	}
	
	/**
	 * Checks if Train instance has space for passengers
	 * @return true if space, false otherwise
	 * O(1)
	 */
	public boolean hasSpaceForPassengers() {
		return passengerIndex < TOTAL_PASSENGERS;
	}
	
	/**
	 * Removes all passengers who should be exiting the Train at the Train’s current station
	 * @return String of the removed passengers.
	 * O(n)
	 */
	public String disembarkPassengers() {
		String passengersString = "";
		for (int i = 0; i < passengers.length; i++) {
			Rider passenger = passengers[i];
			if (passenger != null && passenger.getDestination().toLowerCase().equals(currentStation.toLowerCase())) {
				passengersString += passenger.getRiderID() + ", " + passenger.getDestination() + "\n";
				passengers[i] = null;
				passengerIndex--;
			}
		}
		return passengersString;
	}
	
	/**
	 * Updates the name of this Train’s current station to be the name of another station.
	 * @param s new Station
	 * O(1)
	 */
	public void updateStation(String s) {
		currentStation = s;
	}
	
	/**
	 * Gets current station
	 * @return name of the Train’s current Station
	 * O(1)
	 */
	public String getStation() {
		return currentStation;
	}
	
	/**
	 * toString method
	 * @return string representation of Train with passengers
	 */
	@Override
	public String toString() {
		return "[Current passengers: " + currentPassengers() + ", Current Station: " + currentStation + ", Direction: " + (goingNorth()?"North":"South") + "]";
	}
}
