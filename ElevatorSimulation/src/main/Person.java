/**
* Simulates a person with a name and location
* Known Bugs: None
*
* @author Archer Heffern
* hefferna@brandeis.edu
* Due 9/9/22
* COSI 21a PA0
*/

package main;

import java.security.InvalidParameterException;

public class Person {
	
	private String firstName;
	private String lastName;
	
	//if location 0; waiting to be serviced
	//if location 0; person in lobby and will never be processed
	//if location > 0; person waiting to be serviced
	
	private int location;
	
	/**
	 * Constructs new Person instance with first Name and last Name
	 * @param firstName String first Name of person
	 * @param lastName String last Name of person
	 * @throws InvalidParameterException when firstName is null
	 * @throws InvalidParameterException when lastName is null
	 */
	public Person(String firstName, String lastName) {
		if (firstName == null) throw new InvalidParameterException("firstName cannot be null");
		if (lastName == null) throw new InvalidParameterException("lastName cannot be null");
		this.firstName = firstName;
		this.lastName = lastName;
		this.location = -1;
	}
	
	/**
	 * Sets Person's location
	 * @param location new location of Person
	 */
	public void setLocation(int location) {
		this.location = location;
	}

	/**
	 * Enters person into building instance
	 * @param building Building instance
	 * @param floor int of floor person wants to go to
	 * @return boolean 
	 */
	public boolean enterBuilding(Building building, int floor) {
		boolean success = building.enterElevatorRequest(this, floor);
		if (!success) {
			this.location = 0;
			return false;
		}
		else return true; 
	}
	
	/**
	 * @return String representing where the Person instance is located
	 */
	public String getLocation() {
		if (location > 0) return "In Floor " + location;
		else if (location == 0) return "In Lobby";
		else return "Waiting to be serviced";
	}
	
	/**
	 * @return String of person name and location
	 */
	public String toString() {
		return "[ " + firstName + " " + lastName + ", " + getLocation() + "]";
	}
	
	/**
	 * @return String first name of person
	 */
	public String getFirstName() {
		return this.firstName;
	}
	
	
}
