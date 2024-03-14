package edu.ucalgary.oop;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;

/**
 * Tests for the Inquirer class.
 */
public class InquirerTest {

    private Inquirer inquirer;
    
    /**
     * Test for object creation with valid parameters.
     */
    @Test
    public void testObjectCreation() {
        inquirer = new Inquirer("Joe", "Martin", "Looking for Wife", "403-846-9876");
        assertNotNull("Constructor should create an instance of Inquirer", inquirer);
    }
    
    /**
     * Test for constructor with an invalid phone number.
     * Expects IllegalArgumentException to be thrown.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWithInvalidPhoneNum() {
        inquirer = new Inquirer("Joe", "Martin", "Looking for Wife", "4033/857/543");
        // Expecting IllegalArgumentException
    }
    
    /**
     * Test for retrieving the services phone number.
     * Verifies that the correct phone number is returned.
     */
    @Test
    public void testGetServicesPhoneNum() {
        inquirer = new Inquirer("Joe", "Martin", "Looking for Wife", "403-846-9876");
        String expectedPhoneNum = inquirer.getServicesPhoneNum();
        assertEquals("getServicesPhoneNum should return the phone number", expectedPhoneNum, "403-846-9876");
    }   
	 /**
     * Test for userselection query handling
     * should return the value of the attribute being searched for
     */
	@Test
	public void testValidUserSelectionInput(){
		String userInput = "Phone Number"; //this is considered correct format
		String searchResult = inquirer.userSelection(userInput);
		assertEquals("Search result should return the associated attribute", searchResult, inquirer.getServicesPhoneNum());
	}
	/**
     * Test for userselection query handling
     * In the case of invalid input, the class should return null
	 * to allow for the user interface to acknowledge the invalid input
	 * and allow the user to try again, rather than just throwing an invalid argument exception
     */
	@Test
	public void testInvalidUserSelctionInput(){
		String userInput = "What is your favourite colour"; //this is consider incorrect format
		String searchResult = inquirer.userSelection(userInput);
		assertNull("Invalid Search result should return nothing", searchResult);
	}
}
