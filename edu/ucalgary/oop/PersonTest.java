package edu.ucalgary.oop;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class PersonTest{
	private Person person;
	
	@Before
	public void setUp(){
		person = new Person("John");
	}
	
	@Test
	public void testSingleArugmentConstructor(){
		assertEquals("the firstname field should be populated", person.getFirstName(), "John");
	}
	
	@Test
	public void testMultiArgumentConstructor(){
		Person person2 = new Person("Jim", "Smith", "BABABOOYE");
		assertEquals("constructor should implement firstName", perseon.getFirstName(), "Jim");
		assertEquals("constructor should implement lastName", perseon.getLastName(), "Smith");
		assertEquals("constructor should implement comments", perseon.getCommentsName(), "BABABOOYE");
	}
	
	@Test
	public void testSetFirstName(){
        String newFirstName = "Alice";
        person.setFirstName(newFirstName);
        assertEquals("setFirstName should update the new first name", newFirstName, person.getFirstName());
	}
	
	@Test
	public void testSetLastName(){
        String newLastName = "Smith";
        person.setLastName(newLastName);
        assertEquals("setLastName should update the new last name", newLastName, person.getLastName());
	}
	
	@Test
	public void testSetComments(){
		String comments = "Has a minor injury on the left arm";
        person.setComments(comments);
        assertEquals("setComments should update the comments correctly", comments, person.getComments());
 
	}
	
	
	
}