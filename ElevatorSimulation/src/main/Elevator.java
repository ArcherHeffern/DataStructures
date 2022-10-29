/**
* Simulates an elevator that can take jobs and bring people to the floor they want
* Known Bugs: None
*
* @author Archer Heffern
* hefferna@brandeis.edu
* Due 9/9/22
* COSI 21a PA0
*/
package main;

public class Elevator {

	/**
	 * This specifies the number of people that can be brought to their floors by an Elevator 
	 * instance at any given time. 
	 * <p>DO NOT REMOVE THIS FIELD</p>
	 * <p>You may edit it. But keep it public.</p>
	 */
	public static int maxOccupants = 3;
	private Job[] jobList = new Job[0];
	private int location = 0;
	private Building building;
	
	/**
	 * Constructs new Elevator instance with reference to the building it belongs to
	 * @param building the Building instance the Elevator belongs to
	 */
	public Elevator(Building building) {
		this.building = building;
	}
	
	/**
	 * Adds new Job to jobList: Assumes floor is valid
	 * @param person instance who wants a job
	 * @param floor the person wants to go to
	 */
	
	public void createJob(Person person, int floor) {
			Job[] tempList = new Job[jobList.length + 1];
			for (int i = 0; i < jobList.length; i++) {
				tempList[i] = jobList[i];
			}
			tempList[jobList.length] = new Job(person, floor);
			this.jobList = tempList;
	}
	
	/**
	 * processes all jobs: every maxOccupants amount of jobs, the elevator goes back to the lobby
	 */
	public void processAllJobs() {
		int jobsLength = jobList.length;
		int counter = 0;
		for (int i = 0; i < jobsLength; i++) {
			processJob(jobList[0]);
			counter++;
			if (counter % maxOccupants == 0) processJob(new Job(null, 0));
		}
		if (location != 0) processJob(new Job(null, 0));
	}
	
	/**
	 * elevator goes to the floor and puts the person on the floor; prints each changing of floors
	 * @param job The job being processed
	 */
	public void processJob(Job job) {
		int desiredFloor = job.getFloor();
		Person person = job.getPerson();
		
		while (this.location != desiredFloor) {
			//print statements
			if (this.location == 0) System.out.println("Elevator at Lobby");
			else System.out.println("Elevator at floor " + location);
			
			//changing location
			if (this.location < desiredFloor) {
				location++;
			}
			else if (this.location > desiredFloor) {
				location--;
			}
		}
		if (this.location == 0) System.out.println("Elevator at Lobby");
		else System.out.println("Elevator at floor " + location);
		
		if (person != null) {
			exit(person, desiredFloor);			
		}
		//---------------
		
		
	}
	
	/**
	 * Sets person location to floor and removes first element from jobList, adds person to floor
	 * Assumes jobList is not empty
	 * @param person whose location is being changed
	 * @param floor new location of person instance
	 */
	public void exit(Person person, int floor) {
		if (jobList.length == 0) return;
		person.setLocation(floor);
		building.enterFloor(person, floor);
		
		//removes Job from jobList and resizes array
		Job[] tempList = new Job[jobList.length - 1];
		for (int i = 1; i < jobList.length; i++) {
			tempList[i - 1] = jobList[i];
		}
		this.jobList = tempList;
	}
	
	/**
	 * toString method
	 * @return String all jobs elevator has to process
	 */
	public String toString() {
		String jobs = "[ ";
		for (Job job:jobList) {
			jobs += job.toString();
		}
		return jobs + "]";
	}
	
	/**
	 * jobList getter
	 * @return Job[] instance jobList
	 */
	public Job[] getJobList() {
		return this.jobList;
	}
}