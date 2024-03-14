package edu.ucalgary.oop;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class InquirerTest{
	private Inquirer inquirer;
	
	
	@Test
	public void testObjectCreation(){
		inquirer = new Inquirer("Joe", "Martin", "Looking for Wife", "403-846-9876");
		assertNotNull("Constructor should create an instance of Inquirer", inquirer);
	}
	
	#Test(expected = IllegalArgumentException.class)
	public void testConstructorWithInvalidPhoneNum(){
		inquirer = new Inquirer("Joe", "Martin", "Looking for Wife", "4033/857/543");
		//Expecting illegalArgumentException
	}
	
	@Test
	public void testGetServicesPhoneNum(){
		inquirer = new Inquirer("Joe", "Martin", "Looking for Wife", "403-846-9876");
		String expectedPhoneNum = inquirer.getServicesPhoneNum();
		assertEquals("getServicesPhoneNum should return the phone number", expectedPhoneNum, "403-846-9876");
	}
	
	
}