package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.Person;

class StudentPersonTest {

	private static String firstName;
	private static String lastName;
	private static int location;
	
	@BeforeAll
	private static void setUp(){
	firstName = "Archer";
	lastName = "Heffern";
	location = 0;
	}
	
	@Test
	@DisplayName("Should not create Person when first name is null")
	public void shouldThrowRuntimeExceptionWhenFirstNameIsNull() {
		assertThrows(RuntimeException.class, ()-> {new Person(null, lastName);});
	}
	
	@Test
	@DisplayName("Should not create Person when last name is null")
	public void shouldThrowRuntimeExceptionWhenLastNameIsNull() {
		assertThrows(RuntimeException.class, ()-> {new Person(firstName, null);});
	}
	
	@Test
	@DisplayName("Should not create Person when location is less than 0") 
	public void shouldThrowRuntimeExceptionWhenLocationLessThan0() {
		assertThrows(RuntimeException.class, ()-> {new Person(firstName, lastName);});
	}
	
	@Test
	@DisplayName("Should return the correct location")
	public void shouldReturnCorrectLocation() {
		Person person = new Person(firstName, lastName);
		assertEquals(person.getLocation(), location);
	}

}
