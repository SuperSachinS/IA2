
package edu.ucalgary.oop;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class MedicalRecordTest {

	private Location expectedLocation;
	private String expectedTreatmentDetails;
	private String expectedDateOfTreatment;
	private String validDateOfTreatment;
	private String invalidDateOfTreatment;
	MedicalRecord medicalRecord;

	@Before
	public void SetUp(){
		expectedLocation = new Location("ShelterA", "140 8 Ave NW");
		expectedTreatmentDetails = "Broken arm treated";
		expectedDateOfTreatment = "2024-01-19"l
		validDateOfTreatment = "2024-02-04";
		invalidDateOfTreatment = "2024/02/04";
		medicalRecord = new MedicalRecord(expectedLocation, expectedTreatmentDetails, expectedDateOfTreatment);
	}


    @Test
    public void testMedicalRecordObjectCreation() {
        assertNotNull("The MedicalRecord constructor should create an instance of MedicalRecord"medicalRecord);
    }	
	
    @Test
    public void testGetLocation() {
    assertEquals("getLocation should return the correct Location", expectedLocation, medicalRecord.getLocation());
    }

    @Test
    public void testSetLocation() {
	Location newExpectedLocation = new Location("Shelter B", "150 8 Ave NW ");
	medicalRecord.setLocation(newExpectedLocation);
        assertEquals("setLocation should update the Location", newExpectedLocation.getName(), medicalRecord.getLocation().getName());
    }

    @Test
    public void testGetTreatmentDetails() {
        assertEquals("getTreatmentDetails should return the correct treatment details", expectedTreatmentDetails, medicalRecord.getTreatmentDetails());
    }
	@Test
    public void testSetTreatmentDetails() {
	String newExpectedTreatment = "No surgery required";
	medicalRecord.setTreatmentDetails(newExpectedTreatment);
    assertEquals("setTreatmentDetails should update the treatment details", newExpectedTreatment, medicalRecord.getTreatmentDetails());
    }


    @Test
    public void testGetDateOfTreatment() {
    assertEquals("getDateOfTreatment should return the correct date of treatment", expectedDateOfTreatment, medicalRecord.getDateOfTreatment());
    }
	
	@Test
    public void testSetDateOfTreatment() {
	String newExpectedDateOfTreatment = "2024-02-05";
	medicalRecord.setDateOfTreatment(newExpectedDateOfTreatment);
    assertEquals("setDateOfTreatment should update date of treatment", newExpectedDateOfTreatment, medicalRecord.getDateOfTreatment());
    }
	@Test
    public void testSetDateOfTreatmentWithValidFormat() {
        
        medicalRecord.setDateOfTreatment(validDateOfTreatment); // Should not throw an exception
    }

    @Test
    public void testSetDateOfTreatmentWithInvalidFormat() {
        boolean correctValue = false;
        String failureReason = "no exception was thrown";

        try {
           medicalRecord.setDateOfTreatment(inValidDateOfTreatment); // Should throw IllegalArgumentException
        }
        catch (IllegalArgumentException e) {
           correctValue = true;
        }
        catch (Exception e) {
           failureReason = "the wrong type of exception was thrown";
        }

        String message = "setDateOfTreatment() should throw an IllegalArgumentException with invalid date format '" + inValidDateOfTreatment + "' but " + failureReason + ".";
        assertTrue(message, correctValue);
    }

    @Test
    public void testSetDateOfTreatmentWithNotADate() {
        boolean correctValue = false;
        String failureReason = "no exception was thrown";

        try {
           medicalRecord.setDateOfTreatment(expectedTreatmentDetails); // Should throw IllegalArgumentException
        }
        catch (IllegalArgumentException e) {
           correctValue = true;
        }
        catch (Exception e) {
           failureReason = "the wrong type of exception was thrown";
        }

        String message = "setDateOfTreatment() should throw an IllegalArgumentException with invalid non-date input '" + inValidDateOfTreatment + "' but " + failureReason + ".";
        assertTrue(message, correctValue);
    }
}

