package edu.ucalgary.oop;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;

/**
 * Tests for the MedicalRecord class.
 */
public class MedicalRecordTest {

    private Location expectedLocation;
    private String expectedTreatmentDetails;
    private String expectedDateOfTreatment;
    private String validDateOfTreatment;
    private String invalidDateOfTreatment;
    MedicalRecord medicalRecord;

    /**
     * Set up initial data for testing.
     */
    @Before
    public void SetUp() {
        expectedLocation = new Location("ShelterA", "140 8 Ave NW");
        expectedTreatmentDetails = "Broken arm treated";
        expectedDateOfTreatment = "2024-01-19";
        validDateOfTreatment = "2024-02-04";
        invalidDateOfTreatment = "2024/02/04";
        medicalRecord = new MedicalRecord(expectedLocation, expectedTreatmentDetails, expectedDateOfTreatment);
    }

    /**
     * Test for medical record object creation.
     */
    @Test
    public void testMedicalRecordObjectCreation() {
        assertNotNull("The MedicalRecord constructor should create an instance of MedicalRecord", medicalRecord);
    }

    /**
     * Test for getting the location of the medical record.
     */
    @Test
    public void testGetLocation() {
        assertEquals("getLocation should return the correct Location", expectedLocation, medicalRecord.getLocation());
    }

    /**
     * Test for setting a new location for the medical record.
     */
    @Test
    public void testSetLocation() {
        Location newExpectedLocation = new Location("Shelter B", "150 8 Ave NW ");
        medicalRecord.setLocation(newExpectedLocation);
        assertEquals("setLocation should update the Location", newExpectedLocation.getName(), medicalRecord.getLocation().getName());
    }

    /**
     * Test for getting the treatment details of the medical record.
     */
    @Test
    public void testGetTreatmentDetails() {
        assertEquals("getTreatmentDetails should return the correct treatment details", expectedTreatmentDetails, medicalRecord.getTreatmentDetails());
    }

    /**
     * Test for setting new treatment details for the medical record.
     */
    @Test
    public void testSetTreatmentDetails() {
        String newExpectedTreatment = "No surgery required";
        medicalRecord.setTreatmentDetails(newExpectedTreatment);
        assertEquals("setTreatmentDetails should update the treatment details", newExpectedTreatment, medicalRecord.getTreatmentDetails());
    }

    /**
     * Test for getting the date of treatment of the medical record.
     */
    @Test
    public void testGetDateOfTreatment() {
        assertEquals("getDateOfTreatment should return the correct date of treatment", expectedDateOfTreatment, medicalRecord.getDateOfTreatment());
    }

    /**
     * Test for setting a new date of treatment for the medical record.
     */
    @Test
    public void testSetDateOfTreatment() {
        String newExpectedDateOfTreatment = "2024-02-05";
        medicalRecord.setDateOfTreatment(newExpectedDateOfTreatment);
        assertEquals("setDateOfTreatment should update date of treatment", newExpectedDateOfTreatment, medicalRecord.getDateOfTreatment());
    }

    /**
     * Test for setting a new date of treatment for the medical record with valid format.
     */
    @Test
    public void testSetDateOfTreatmentWithValidFormat() {
        medicalRecord.setDateOfTreatment(validDateOfTreatment); // Should not throw an exception
    }

    /**
     * Test for setting a new date of treatment for the medical record with invalid format.
     */
    @Test
    public void testSetDateOfTreatmentWithInvalidFormat() {
        boolean correctValue = false;
        String failureReason = "no exception was thrown";

        try {
            medicalRecord.setDateOfTreatment(invalidDateOfTreatment); // Should throw IllegalArgumentException
        } catch (IllegalArgumentException e) {
            correctValue = true;
        } catch (Exception e) {
            failureReason = "the wrong type of exception was thrown";
        }

        String message = "setDateOfTreatment() should throw an IllegalArgumentException with invalid date format '" + invalidDateOfTreatment + "' but " + failureReason + ".";
        assertTrue(message, correctValue);
    }

    /**
     * Test for setting a new date of treatment for the medical record with non-date input.
     */
    @Test
    public void testSetDateOfTreatmentWithNotADate() {
        boolean correctValue = false;
        String failureReason = "no exception was thrown";

        try {
            medicalRecord.setDateOfTreatment(expectedTreatmentDetails); // Should throw IllegalArgumentException
        } catch (IllegalArgumentException e) {
            correctValue = true;
        } catch (Exception e) {
            failureReason = "the wrong type of exception was thrown";
        }

        String message = "setDateOfTreatment() should throw an IllegalArgumentException with invalid non-date input '" + invalidDateOfTreatment + "' but " + failureReason + ".";
        assertTrue(message, correctValue);
    }
}
