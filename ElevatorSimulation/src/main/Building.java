/**
* Simulates a building with a single elevator and multiple floors
* Known Bugs: None
*
* @author Archer Heffern
* hefferna@brandeis.edu
* Due 9/9/22
* COSI 21a PA0
*/

package main;

import java.security.InvalidParameterException;

public class Building {
	
	private Floor[] floors;
	private Elevator elevator;

	/**
	 * constructs a building instance with numFloors amount of Floors and an elevator
	 * @param numFloors int - number of floors the building has
	 */
	public Building(int numFloors) {
		if (numFloors <= 0) throw new InvalidParameterException();
		generateFloors(numFloors);
		this.elevator = new Elevator(this);
	}
	/*
	 * Helper function to generate floors for building constructor
	 */
	private void generateFloors(int numFloors) {
		this.floors = new Floor[numFloors + 1];
		floors[0] = new Floor("Lobby");
		for (int i = 1; i <= numFloors; i++) {
			floors[i] = new Floor("Floor " + i);
		}
	}
	
	/**
	 * This method will handle the request made by a Person to enter this Building and
	 * be taken to some floor
	 * @param person The person entering the elevator
	 * @param floor the floor the person wants to go to
	 * @return boolean If the Elevator cannot reach the Person’s desired floor, 
	 * return false. If the elevator can reach the person’s desired floor, return true.
	 */
	public boolean enterElevatorRequest(Person person, int floor) {
		if (floor > floors.length || floor < 0) return false;
		else elevator.createJob(person, floor);
		return true;
	}
	
	/**
	 * Gets elevator to process all jobs
	 */
	public void startElevator() {
		elevator.processAllJobs();
	}
	
	/**
	 * Gets person to enter the floor
	 * @param person who is entering the floor
	 * @param floor number being entered
	 */
	public void enterFloor(Person person, int floor) {
		floors[floor].enterFloor(person);
	}
	
	/**
	 * toString method
	 * @return String of all floors
	 */
	public String toString() {
		String floorsString = "[ " + floors[0];
		for (int i = 1; i < floors.length; i++) {
			floorsString += ", " + floors[i];
		}
		return floorsString + "]";
	}
}
