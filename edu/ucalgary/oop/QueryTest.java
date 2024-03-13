package edu.ucalgary.oop;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;


public class QueryTest{
	private Query query;
	private Location location;
	private DisasterVictim victim;
	private String data;
	private String date;
	
	
	@Before
	public void setUp(){
		data = "Q:Where is my Husband A:last seen 12 hours ago at University of Calgary.";
		date = "2024-02-04";
		victim = new DisasterVictim("John", "2024-02-02");
		location = "University of Calgary";
		query = new Query(data, date, victim);
	}
	
	@Test
	public void testQueryObjectCreation(){
		assertNotNull("The query constructor should create an instance of Query", query);
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testInvalidObjectCreation(){
		String badDate = "2024/02/04";
		new Query(data, date, location);
		//Expecting Illegal ArgumentException due to invalid date format
	}
	
	@Test
	public void testGetData(){
		assertEquals("getData should return the correct data", query.getData(), data);
	}
	@Test
	public void testGetDate(){
		assertEquals("getData should return the correct data", query.getDate(), date);
	}
	@Test
	public void testGetDisasterVictim(){
		assertEquals("getData should return the correct data", query.getDisasterVictim(), victim);
	}
	@Test
	public void testGetLocation(){
		assertEquals("getData should return the correct data", query.getLastKnownLocation(), location);	
	}
	
	@Test
	public void testSetData(){
		String newData = "Q:What is this? A:it's a banana";
		query.setData(newData);
		assertEquals("setData should correctly set the data attribute", query.getData(), newData);
	}
	@Test
	public void testSetDateWithValidInput(){
		String newDate = "2024-02-20";
		query.setDate(newDate);
		assertEquals("SetDate should correctly set the date attribute", query.getDate(), newDate);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSetDateWithInvalidInput(){
		String badDate = "2023/04/20";
		query.setDate(badDate);
		//Expecting Illegal ArgumentException due to invalid date format
	}
	
	@Test
	public void testSetDisasterVictim(){
		DiasasterVictim newVictim = new DisasterVictim("Jim", "2024-02-25");
		query.setDisasterVictim(newVictim);
		assertEquals("setDisasterVictim should properly change the disasterVictim attribute", query.getDisasterVictim(), newVictim);
		
	}
	
	@Test
	public void testSetLocation(){
		Location newLocation = new Location("abc", "bde");
		query.setLastKnownLocation(newLocation);
		assertEquals("setLastKnownLocation should properly change the lastKnownLocation attribute", query.getLastKnownLocation(), newLocation);
	}
	
	
}
