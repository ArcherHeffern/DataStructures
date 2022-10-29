package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import main.Job;
import main.Person;

public class StudentJobTest {
	private static String firstName;
	private static String lastName;
	private static int floor;

	@BeforeAll
	public static void setup(){
	firstName = "Archer";
	lastName = "Heffern";
	floor = 5;
	}
	
	@Test
	@DisplayName("Checks if getPerson method works")
	void getPersonTest() {
		System.out.println(firstName + ", " + lastName);
		Job job = new Job(new Person(firstName, lastName), floor);
		assertEquals(job.getPerson().toString(), new Person(firstName, lastName).toString());
	}
	
	@Test
	void getFloorTest() {
		Job job = new Job(new Person(firstName, lastName), floor);
		assertEquals(job.getFloor(), floor);
	}
	
	@Test
	@DisplayName("Should not create Job when floor is less than 0")
	void shouldThrowRuntimeExceptionWhenFloorIsLessThan0() {
		assertThrows(RuntimeException.class, ()-> new Job(new Person(firstName, lastName), -1));
	}

}
