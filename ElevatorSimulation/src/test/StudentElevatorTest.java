package test;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.Elevator;
import main.Person;
import main.Job;

import main.Building;

class StudentElevatorTest {

	@Test
	@DisplayName("Should create several new jobs")
	void shouldCreateSeveralNewJobs() {
		Building building = new Building(3);
		Elevator elevator = new Elevator(building);
		
		Person person = new Person("A", "B");
		
		elevator.createJob(person, 0);
		elevator.createJob(person, 0);
		elevator.createJob(person, 0);
		elevator.createJob(person, 0);
		
		System.out.println(elevator);
	}
	
	@Test
	@DisplayName("Should set person location to floor and removes first element from jobList when running exit")
	void shouldExitPersonProperly() {
		Building building = new Building(3);
		Elevator elevator = new Elevator(building);
		
		Person person = new Person("A", "B");
		elevator.createJob(person, 5);
		elevator.exit(person, 5);
		
		assertArrayEquals(elevator.getJobList(), new Job[0], "jobList should be empty");
		assertEquals(person.getLocation(), "In Floor 5", "Person should be on floor 5");
	}
	
	
	@Test
	@DisplayName("Should process a single job")
	void shouldProcessAllJobs() {
		Building building = new Building(3);
		Elevator elevator = new Elevator(building);
		
		Person person = new Person("A", "B");
		
		elevator.processJob(new Job(person, 5));
	}
	
	@Test
	@DisplayName("Should process several jobs")
	void shouldProcess() {
		Building building = new Building(3);
		Elevator elevator = new Elevator(building);
		
		Person person1 = new Person("A", "B");
		Person person2 = new Person("C", "D");
		Person person3 = new Person("E", "F");
		
		elevator.processJob(new Job(person1, 3));
		elevator.processJob(new Job(person2, 3));
		elevator.processJob(new Job(person3, 3));
		
		elevator.processAllJobs();
		assertArrayEquals(elevator.getJobList(), new Job[0], "jobList should be empty");
	}

}
