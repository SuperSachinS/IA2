package edu.ucalgary.oop;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class ReliefServiceTest {
	private ReliefService reliefService;
	private Inquirer inquirer;
	private DisasterVictim victim;
	private Query expectedQuery;
	
	
	@Before
	public void setUp(){
		inquirer = new Inquirer("Joe", "Martin", "Looking for Wife", "403-846-9876");
		reliefService = new ReliefService(inquirer);
		victim = new DisasterVictim("Freda", "2024-04-04");
	}
	
	
	@Test
	testAddRecordWithNoLocationAndValidInput(){
		String data = "Health Condition is Ok";
		String date = "2024-04-05";
		reliefService.addRecord(date, data, victim);
		expectedQuery = reliefService.getRecord(date);
		
		assertEquals("addRecord should correctly assign the date", date, expectedQuery.getDate());
		assertEquals("addRecord should correctly assign the data", data, expectedQuery.getData());
		assertEquals("addRecord should correctly assign the disastervictim", victim, expectedQuery.getDisasterVictim());
		assertNull("addRecord should leave location as Null", expectedQuery.getLastKnownLocation());
	}
	
	@Test(expected = IllegalArgumentException.class)
	testAddRecordWithNOLocationAndInvalidInput(){
		String data = "Health Condition is Ok";
		String date = "2024/04/05";
		reliefService.addRecord(date, data, victim);
		//expecting an illegal argument exception
	}
	
	
	@Test
	testAddRecordWithLocationAndValidInput(){
		String data = "Health Condition is Ok";
		String date = "2024-04-05";
		Location location = new Location("University of Calgary", "438 Ave Street");
		reliefService.addRecord(date, data, victim, location);
		expectedQuery = reliefService.getRecord(date);
		
		assertEquals("addRecord should correctly assign the date", date, expectedQuery.getDate());
		assertEquals("addRecord should correctly assign the data", data, expectedQuery.getData());
		assertEquals("addRecord should correctly assign the disastervictim", victim, expectedQuery.getDisasterVictim());
		assertEquals("addRecord should correctly assign the location", location, expectedQuery.getLastKnownLocation());

	}
	
	@Test (expected = IllegalArgumentException.class)
	testAddRecordWithLocationAndInvalidInput(){
		String data = "Health Condition is Ok";
		String date = "2024/04/05";
		Location location = new Location("University of Calgary", "438 Ave Street");
		reliefService.addRecord(date, data, victim, location);
		//Expecting an Illegal Argument exception
	}
	
	@Test
	testRemoveRecord(){
		String data = "Health Condition is Ok";
		String date = "2024-04-05";
		reliefService.addRecord(date, data, victim);
		reliefService.removeRecord(date);
		expectedQuery = reliefService.getRecord(date);
		assertNull("Remove Record should delete the associate Query", expectedQuery);
	}
	
	@Test
	testGetInquirer(){
		Inquirer expectedInquirer = reliefService.getInquirer();
		assertEquals("getInquirer should return the inquirer", expectedInquirer, inquirer);
	}
}