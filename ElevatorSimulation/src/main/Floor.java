/**
* simulates a Floor of a building. Has a name and a list of people within it.
* Known Bugs: None
*
* @author Archer Heffern
* hefferna@brandeis.edu
* Due 9/9/22
* COSI 21a PA0
*/

package main;

public class Floor {

	private String floorName;
	private Person[] people;

	/**
	 * constructs new floor instance with floor name and empty list of people.
	 * @param floorName name of the floor
	 */
	public Floor(String floorName) {
		this.floorName = floorName;
		this.people = new Person[0];
	}

	/**
	 * toString method
	 * @return String floor name and people on floor
	 */
	public String toString() {
		return "[ " + this.floorName + ", " + personArrayToString() + "]";
	}

	//toString helper method
	private String personArrayToString() {
		String personString = "";
		for (Person person : people) {
			personString += person.toString();
		}
		return personString;
	}

	/**
	 * Adds person to floorList
	 * @param person entering floor
	 */
	public void enterFloor(Person person) {

		Person[] tempList = new Person[people.length + 1];
		for (int i = 0; i < people.length; i++) {
			tempList[i] = people[i];
		}
		tempList[people.length] = person;
		this.people = tempList;
	}
}
