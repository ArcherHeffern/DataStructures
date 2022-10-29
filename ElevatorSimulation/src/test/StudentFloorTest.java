package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import main.Floor;
import main.Person;

class StudentFloorTest {
	
	@Test
	@DisplayName("Checks if adding person to floor works")
	void shouldAddPersonToFloor() {
		Floor floor = new Floor("Floor 1");
		Person person = new Person("Archer", "Heffern");
		floor.enterFloor(person);
		assertEquals(floor.toString(), "[ Floor 1, " + person.toString() + "]");
	}

	@Test
	@DisplayName("Checks if adding several person to floor works")
	void shouldAddSeveralPeopleToFloor() {
		Floor floor = new Floor("Floor 1");
		Person person1 = new Person("A", "B");
		Person person2 = new Person("C", "D");
		Person person3 = new Person("E", "F");
		Person person4 = new Person("H", "I");
		floor.enterFloor(person1);
		floor.enterFloor(person2);
		floor.enterFloor(person3);
		floor.enterFloor(person4);
		
		System.out.println(floor.toString());
		
		assertEquals(floor.toString(), "[ Floor 1, [ A B, Waiting to be serviced][ C D, Waiting to be serviced][ E F, Waiting to be serviced][ H I, Waiting to be serviced]]");
	}
}
