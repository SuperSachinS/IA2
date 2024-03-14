package edu.ucalgary.oop;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;

/**
 * This class contains test cases for the Person class.
 */
public class PersonTest {

    private Person person;
    
    /**
     * Setup method to initialize a Person object before each test case.
     */
    @Before
    public void setUp() {
        person = new Person("John");
    }
    
    /**
     * Test case for single-argument constructor of Person class.
     * It checks if the firstname field is populated correctly.
     */
    @Test
    public void testSingleArgumentConstructor() {
        assertEquals("the firstname field should be populated", person.getFirstName(), "John");
    }
    
    /**
     * Test case for multi-argument constructor of Person class.
     * It checks if the constructor implements firstName, lastName, and comments correctly.
     */
    @Test
    public void testMultiArgumentConstructor() {
        Person person2 = new Person("Jim", "Smith", "BABABOOYE");
        assertEquals("constructor should implement firstName", person2.getFirstName(), "Jim");
        assertEquals("constructor should implement lastName", person2.getLastName(), "Smith");
        assertEquals("constructor should implement comments", person2.getComments(), "BABABOOYE");
    }
    
    /**
     * Test case for setFirstName method of Person class.
     * It checks if setFirstName updates the first name correctly.
     */
    @Test
    public void testSetFirstName() {
        String newFirstName = "Alice";
        person.setFirstName(newFirstName);
        assertEquals("setFirstName should update the new first name", newFirstName, person.getFirstName());
    }
    
    /**
     * Test case for setLastName method of Person class.
     * It checks if setLastName updates the last name correctly.
     */
    @Test
    public void testSetLastName() {
        String newLastName = "Smith";
        person.setLastName(newLastName);
        assertEquals("setLastName should update the new last name", newLastName, person.getLastName());
    }
    
    /**
     * Test case for setComments method of Person class.
     * It checks if setComments updates the comments correctly.
     */
    @Test
    public void testSetComments() {
        String comments = "Has a minor injury on the left arm";
        person.setComments(comments);
        assertEquals("setComments should update the comments correctly", comments, person.getComments());
    }
}
