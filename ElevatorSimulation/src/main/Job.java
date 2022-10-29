/**
* This classes primary purpose is to store requests for the Elevator to service.
* Each request comprises of a Person and the number of the floor they wish to be taken to.
* Known Bugs: None
*
* @author Archer Heffern
* hefferna@brandeis.edu
* Due 9/9/22
* COSI 21a PA0
*/

package main;

import java.security.InvalidParameterException;

public class Job {
	
	private Person person;
	private int floor;

	/**
	 * Constructs new Job instance with person and floor
	 * @param person Person the job is attributed to
	 * @param floor location the Person wants to go to
	 */
	public Job(Person person, int floor) {
		if (floor < 0) throw new InvalidParameterException("Floor should be 0 or greater");
		this.person = person;
		this.floor = floor;
	}

	/**
	 * Person getter
	 * @return Person instance
	 */
	public Person getPerson() {
		return person;
	}

	/**
	 * Floor getter
	 * @return floor Person instance wants to go to
	 */
	public int getFloor() {
		return floor;
	}
	
	/**
	 * toString method
	 * @return String of person's first name and the floor they want to go to
	 */
	public String toString() {
		return "[ " + this.person.getFirstName() + ", " + this.floor + "]";
	}
	
}