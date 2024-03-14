package edu.ucalgary.oop;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;

/**
 * Tests for the ReliefService class.
 */
public class ReliefServiceTest {
    
    private ReliefService reliefService;
    private Inquirer inquirer;
    private DisasterVictim victim;
    private Query expectedQuery;
    
    /**
     * Sets up the initial conditions for each test method.
     */
    @Before
    public void setUp(){
        inquirer = new Inquirer("Joe", "Martin", "Looking for Wife", "403-846-9876");
        reliefService = new ReliefService(inquirer);
        victim = new DisasterVictim("Freda", "2024-04-04");
    }
    
    /**
     * Test for adding a record with no location and valid input.
     */
    @Test
    public void testAddRecordWithNoLocationAndValidInput(){
        String data = "Health Condition is Ok";
        String date = "2024-04-05";
        reliefService.addRecord(date, data, victim);
        expectedQuery = reliefService.getRecord(date);
        
        assertEquals("addRecord should correctly assign the date", date, expectedQuery.getDate());
        assertEquals("addRecord should correctly assign the data", data, expectedQuery.getData());
        assertEquals("addRecord should correctly assign the disaster victim", victim, expectedQuery.getDisasterVictim());
        assertNull("addRecord should leave location as Null", expectedQuery.getLastKnownLocation());
    }
    
    /**
     * Test for adding a record with no location and invalid input.
     * Expects IllegalArgumentException to be thrown.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testAddRecordWithNOLocationAndInvalidInput(){
        String data = "Health Condition is Ok";
        String date = "2024/04/05";
        reliefService.addRecord(date, data, victim);
        //expecting an illegal argument exception
    }
    
    /**
     * Test for adding a record with location and valid input.
     */
    @Test
    public void testAddRecordWithLocationAndValidInput(){
        String data = "Health Condition is Ok";
        String date = "2024-04-05";
        Location location = new Location("University of Calgary", "438 Ave Street");
        reliefService.addRecord(date, data, victim, location);
        expectedQuery = reliefService.getRecord(date);
        
        assertEquals("addRecord should correctly assign the date", date, expectedQuery.getDate());
        assertEquals("addRecord should correctly assign the data", data, expectedQuery.getData());
        assertEquals("addRecord should correctly assign the disaster victim", victim, expectedQuery.getDisasterVictim());
        assertEquals("addRecord should correctly assign the location", location, expectedQuery.getLastKnownLocation());
    }
    
    /**
     * Test for adding a record with location and invalid input.
     * Expects IllegalArgumentException to be thrown.
     */
    @Test (expected = IllegalArgumentException.class)
    public void testAddRecordWithLocationAndInvalidInput(){
        String data = "Health Condition is Ok";
        String date = "2024/04/05";
        Location location = new Location("University of Calgary", "438 Ave Street");
        reliefService.addRecord(date, data, victim, location);
        //Expecting an Illegal Argument exception
    }
    
    /**
     * Test for removing a record.
     */
    @Test
    public void testRemoveRecord(){
        String data = "Health Condition is Ok";
        String date = "2024-04-05";
        reliefService.addRecord(date, data, victim);
        reliefService.removeRecord(date);
        expectedQuery = reliefService.getRecord(date);
        assertNull("Remove Record should delete the associated Query", expectedQuery);
    }
    
    /**
     * Test for getting the inquirer associated with the relief service.
     */
    @Test
    public void testGetInquirer(){
        Inquirer expectedInquirer = reliefService.getInquirer();
        assertEquals("getInquirer should return the inquirer", expectedInquirer, inquirer);
    }
}
