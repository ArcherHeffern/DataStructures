/**
* This Class creates a building instance and adds several people to it to be processed. 
* Known Bugs: None
*
* @author Archer Heffern
* hefferna@brandeis.edu
* Due 9/9/22
* COSI 21a PA0
*/

package main;

import java.util.Scanner;
import java.util.Random;

public class Simulation {
	
	/*
	 * List of first names
	 */
	private static String[] firstNames = new String[] {
		"Liam",
		"Olivia",
		"Noah",
		"Emma",
		"Oliver", 
		"Charlotte",
		"Elijah",
		"Amelia",
		"James", 
		"Ava",
		"William",
		"Sophia",
		"Benjamin", 
		"Isabella", 
		"Lucas", 
		"Mia",
		"Henry", 
		"Evelyn",
		"Theodore",
		"Harper",
		"Jonah",
		"Archer",
		"Dhruv"
		};
	
	/*
	 * List of last names
	 */
	private static String[] lastNames = new String[] {
		"Jr.",
		"Sr.",
		"the Fourth",
		"Smith",
		"Heffern", 
		"Greene",
		"Gardenshwartz",
		"the Fifth",
		"Zyzz",
		"Liu",
		"Reddy",
		"the Magnificent"
	};
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int floors = numFloors();
		
		Building building = new Building(floors);
		
//		Person person1 = new Person("A", "B");
//		Person person2 = new Person("C", "D");
//		Person person3 = new Person("E", "F");
//		
//		person1.enterBuilding(building, 3);
//		person2.enterBuilding(building, 3);
//		person3.enterBuilding(building, 3);
	/*	
		//batch 1
		addPeople(building, 5, floors);
		building.startElevator();
		
		//batch 2
		addPeople(building, 2, floors);
		building.startElevator();
*/
/*		
		(new Person("a", "b")).enterBuilding(building, 7);
		building.startElevator();
*/		

		(new Person("a", "b")).enterBuilding(building, 2);
		(new Person("c", "e")).enterBuilding(building, 1);
		building.startElevator();
	}

	/**
	 * Adds person to building / randomly generates person / randomly generates floor they want to go to.
	 * @param building instance
	 * @param num_people Number of people entering the building
	 * @param floors number of floors the building has
	 */
	public static void addPeople(Building building, int num_people, int floors) {
		Random random = new Random();
		for (int i = 1; i < num_people; i++) {
			Person person = new Person(firstNames[random.nextInt(firstNames.length)], lastNames[random.nextInt(lastNames.length)]);
			building.enterElevatorRequest(person, random.nextInt(1, floors + 1));
		}
	}
	
	/**
	 * Prompts user for number of floors the building has
	 * @return int number of floors wanted
	 */
	public static int numFloors() {
		Scanner console = new Scanner(System.in);
		System.out.print("How many floors does this building have: ");
		while (!console.hasNextInt()) {
			System.out.print("Invalid input, please provide an integer: ");
			console.next();
		}
		int numFloors = console.nextInt();
		console.close();
		return numFloors;
	}
	
}
