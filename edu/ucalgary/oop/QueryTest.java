package edu.ucalgary.oop;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;

/**
 * Tests for the Query class.
 */
public class QueryTest {

    private Query query;
    private Location location;
    private DisasterVictim victim;
    private String data;
    private String date;

    /**
     * Set up initial data for testing.
     */
    @Before
    public void setUp() {
        data = "Q:Where is my Husband A:last seen 12 hours ago at University of Calgary.";
        date = "2024-02-04";
        victim = new DisasterVictim("John", "2024-02-02");
        location = "University of Calgary";
        query = new Query(data, date, victim);
    }
    
    /**
     * Test for query object creation.
     */
    @Test
    public void testQueryObjectCreation() {
        assertNotNull("The query constructor should create an instance of Query", query);
    }

    /**
     * Test for invalid object creation with incorrect date format.
     * Expects IllegalArgumentException to be thrown.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidObjectCreation() {
        String badDate = "2024/02/04";
        new Query(data, date, location);
        // Expecting IllegalArgumentException due to invalid date format
    }

    /**
     * Test for retrieving the data of the query.
     */
    @Test
    public void testGetData() {
        assertEquals("getData should return the correct data", query.getData(), data);
    }

    /**
     * Test for retrieving the date of the query.
     */
    @Test
    public void testGetDate() {
        assertEquals("getData should return the correct data", query.getDate(), date);
    }

    /**
     * Test for retrieving the associated disaster victim of the query.
     */
    @Test
    public void testGetDisasterVictim() {
        assertEquals("getData should return the correct data", query.getDisasterVictim(), victim);
    }

    /**
     * Test for retrieving the last known location associated with the query.
     */
    @Test
    public void testGetLocation() {
        assertEquals("getData should return the correct data", query.getLastKnownLocation(), location);
    }

    /**
     * Test for setting new data for the query.
     */
    @Test
    public void testSetData() {
        String newData = "Q:What is this? A:it's a banana";
        query.setData(newData);
        assertEquals("setData should correctly set the data attribute", query.getData(), newData);
    }

    /**
     * Test for setting a new date for the query with valid input.
     */
    @Test
    public void testSetDateWithValidInput() {
        String newDate = "2024-02-20";
        query.setDate(newDate);
        assertEquals("SetDate should correctly set the date attribute", query.getDate(), newDate);
    }

    /**
     * Test for setting a new date for the query with invalid input.
     * Expects IllegalArgumentException to be thrown.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetDateWithInvalidInput() {
        String badDate = "2023/04/20";
        query.setDate(badDate);
        // Expecting IllegalArgumentException due to invalid date format
    }

    /**
     * Test for setting a new disaster victim for the query.
     */
    @Test
    public void testSetDisasterVictim() {
        DisasterVictim newVictim = new DisasterVictim("Jim", "2024-02-25");
        query.setDisasterVictim(newVictim);
        assertEquals("setDisasterVictim should properly change the disasterVictim attribute", query.getDisasterVictim(), newVictim);
    }

    /**
     * Test for setting a new location for the query.
     */
    @Test
    public void testSetLocation() {
        Location newLocation = new Location("abc", "bde");
        query.setLastKnownLocation(newLocation);
        assertEquals("setLastKnownLocation should properly change the lastKnownLocation attribute", query.getLastKnownLocation(), newLocation);
    }
}
