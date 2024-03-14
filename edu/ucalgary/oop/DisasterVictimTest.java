package edu.ucalgary.oop;
/*
Copyright Ann Barcomb and Khawla Shnaikat, 2024
Licensed under GPL v3
See LICENSE.txt for more information.
*/

package edu.ucalgary.oop;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class DisasterVictimTest {
    private DisasterVictim victim;
    private SupplyItem suppliesToSet; 
    private FamilyRelation familyRelations; 
    private String expectedFirstName = "Freda";
    private String EXPECTED_ENTRY_DATE = "2024-01-18";
    private String validDate = "2024-01-15";
    private String invalidDate = "15/13/2024";
    private String expectedGender = "female"; 
    private String expectedComments = "Needs medical attention and speaks 2 languages";

    /**
     * Sets up the test environment before each test method runs.
     */
    @Before
    public void setUp() {
        victim = new DisasterVictim(expectedFirstName, EXPECTED_ENTRY_DATE);
		victim.setUseDateOfBirth(true);
        suppliesToSet = new ArrayList<>();
        suppliesToSet.add(new SupplyItem("Water Bottle", 10));
        suppliesToSet.add(new SupplyItem("Blanket", 5));

        DisasterVictim victim1 = new DisasterVictim("Jane", "2024-01-20");
        DisasterVictim victim2 = new DisasterVictim("John", "2024-01-22");
        DisasterVictim victim3 = new DisasterVictim("Jim", "2024-01-22");
    }

    /**
     * Tests the constructor of DisasterVictim with a valid entry date.
     */
    @Test
    public void testConstructorWithValidEntryDate() {
        String validEntryDate = "2024-01-18";
        DisasterVictim validVictim = new DisasterVictim("Freda", validEntryDate);
        assertNotNull("Constructor should successfully create an instance with a valid entry date", validVictim);
        assertEquals("Constructor should set the entry date correctly", validEntryDate, validVictim.getEntryDate());
		assertEquals("constructor should set the firstName correctly", "Freda", validVictim.getFirstName());
    }

    /**
     * Tests the constructor of DisasterVictim with an invalid entry date format.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWithInvalidEntryDateFormat() {
        String invalidEntryDate = "18/01/2024"; // Incorrect format according to your specifications
        new DisasterVictim("Freda", invalidEntryDate);
        // Expecting IllegalArgumentException due to invalid date format
    }

    /**
     * Tests the setDateOfBirth method of DisasterVictim.
     */
    @Test
    public void testSetDateOfBirth() {
        String newDateOfBirth = "1987-05-21";
        victim.setDateOfBirth(newDateOfBirth);
        assertEquals("setDateOfBirth should correctly update the date of birth", newDateOfBirth, victim.getDateOfBirth());
    }

    /**
     * Tests the setDateOfBirth method of DisasterVictim with an invalid date format.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetDateOfBirthWithInvalidFormat() {
		
        victim.setDateOfBirth(invalidDate); // This format should cause an exception
    }
	
	
    /**
     * Tests using the setDateOfBirth while using approximate age.
     */
	@Test(expected = IllegalArgumentException.class)
    public void testSetDateOfBirthWhileUsingApproximateAge() {
		victim.setUseDateOfBirth(false);
		victim.setApproximateAge(45);
		
		String newDateOfBirth = "1987-05-21";
        victim.setDateOfBirth(newDateOfBirth);
		// Expecting an illegal argument exception
    }
	
	
    /**
     * Tests that dateOfBirth is set to null after switching to using approximate age
     */
	@Test
	public void testDateOfBirthIsNullWhileApproximateAgeIsNotNull(){
		victim.setUseDateOfBirth(false);
		assertNull("cannot use both birthdate and approximate age at the same time", victim.getDateOfBirth());
	}


    /**
     * Tests that setapproximateage properly update approximate age
     */
	@Test
	public void testSetApproximateAge(){
		victim.setUseDateOfBirth(false);
		victim.setApproximateAge(45);
		
		assertEquals("setApproximateage should update the associate field", 45, victim.getApproximateAge());
	}

	/**
     * Tests that setapproximateage only allows valid age values
	 * expects an illegal argument exception
     */
	@Test(expected = IllegalArgumentException.class)
	public void testSetApproximateAgeWithInvalidInput(){
		victim.setUseDateOfBirth(false);
		victim.setApproximateAge(-20);
		//expecting an illegal argument exception
	}



	/**
     * Tests that setapproximateage only allows for input while not using dateOfBirth
	 * expects an illegal argument exception
     */
	@Test (expected = IllegalArgumentException.class)
	public void testSetApproximateAgeWhileUsingDateOfBirth(){
		victim.setApproximateAge(40);
		//Expecting an illegal argument exception
	}

    /**
     * Tests that approximateAge is set to null after switching to using dateOfBirth
     */
	@Test
	public void testApproximateAgeIsNullWhileUsingDateOfBirth(){
		victim.setUseDateOfBirth(false);
		victim.setApproximateAge(45);
		victim.setUseDateOfBirth(true);
		
		assertNull("approximate age should be null while using dateOfBirth", victim.getDateOfBirth());
		
		
	}
    /**
     * Tests the getAssignedSocialID method of DisasterVictim.
     * The next victim should have an ID one higher than the previous victim.
     * Tests can be run in any order so two victims will be created.
     */
    @Test
    public void testGetAssignedSocialID() {
        DisasterVictim newVictim = new DisasterVictim("Kash", "2024-01-21");
        int expectedSocialId = newVictim.getAssignedSocialID() + 1;
        DisasterVictim actualVictim = new DisasterVictim("Adeleke", "2024-01-22");

        assertEquals("getAssignedSocialID should return the expected social ID", expectedSocialId, actualVictim.getAssignedSocialID());
    }

    /**
     * Tests the getEntryDate method of DisasterVictim.
     */
    @Test
    public void testGetEntryDate() {
        assertEquals("getEntryDate should return the expected entry date", EXPECTED_ENTRY_DATE, victim.getEntryDate());
    }
   
    /**
     * Tests the setGender and getGender methods of DisasterVictim.
     */
    @Test
    public void testSetAndGetGender() {
        String newGender = "male";
        victim.setGender(newGender);
        assertEquals("setGender should update and getGender should return the new gender", newGender.toLowerCase(), victim.getGender());
    }
	
	
    /**
     * Tests for invalid input for setting the gender
     */
	@Test(expected = IllegalArgumentException.class)
	public void testSetGenderWithInvalidInput(){
		String newGender = "abc";
        victim.setGender(newGender);
		//Expecting an illegalArgumentException
	}
	
	
    /**
     * Tests the addFamilyConnection method of DisasterVictim.
     * This method tests the functionality of adding family connections to a victim.
     * It verifies that the relationship integrity is maintained and that the correct relationships are added.
     */
    @Test
    public void testAddFamilyConnection() {
		
		victim1.addFamilyConnection(victim2, "SIBLING");
		victim1.addFamilyConnection(victim3, "PARENT");
		
		FamilyRelation victimRelation = victim1.getFamilyConnections();
		
		ArrayList<DisasterVictim> victimRelatives = victimRelation.getRelatives();

		ArrayList<String> victimRelations = victimRelation.getRelations();
  
		correct = true
		
		for (int i = 0; i < victimRelatives.size(); i++){
			if (victimRelatives.get(i) != victim2 || victimRelatives.get(i) != victim3){
				correct = false
			}
			if (victimRelations.get(i) != "SIBLING" || victimRelations.get(i) != "PARENT"){
				correct = false
			}
			
		}
		
		assertTrue("Relationship integrity is not held within one of the disastervictims", victim1.veriftyRelationshipIntegrity());
		assertTrue("Relationship integrity is not held within one of the disastervictims", victim2.veriftyRelationshipIntegrity());
		assertTrue("Relationship integrity is not held within one of the disastervictims", victim3.veriftyRelationshipIntegrity());
		assertTrue("A Relationship is missing", correct);
    }

    /**
     * Tests the addPersonalBelonging method of DisasterVictim.
     * This method tests the functionality of adding personal belongings to a victim.
     * It verifies that the added supply is included in the victim's personal belongings.
     */
    @Test
    public void testAddPersonalBelonging() {
        SupplyItem newSupply = new SupplyItem("Emergency Kit", 1);
        victim.addPersonalBelonging(newSupply);
        
        Supply testedSupply = victim.getPersonalBelongings();
        ArrayList<SupplyItem> testedSupplies = testedSupply.getSupplies();
        
        boolean correct = false;
        
        for (int i = 0; i < testedSupplies.size(); i++){
            if (testedSupplies.get(i) == newSupply){
                correct = true;
                break; // No need to continue the loop if the supply is found
            }
        }

        assertTrue("addPersonalBelonging should add the supply to personal belongings", correct);
    }
	
	
    /**
     * Tests the removeFamilyConnection method of DisasterVictim.
     * This method tests the functionality of removing a family connection from a victim.
     * It verifies that the specified family member is successfully removed from the victim's family connections.
     */
	@Test
	public void testRemoveFamilyConnection() {
		
		victim1.addFamilyConnection(victim2, "SIBLING");
		victim1.addFamilyConnection(victim3, "PARENT");
		victim1.removeFamilyConnection(victim2);
		
		FamilyConnection testedFamilyConnections = victim1.getFamilyConnections();
		ArrayList<DisasterVictim> relatives = testedFamilyConnections.getRelatives();
		
		boolean correct = true;
		
		
		for (int i = 0; i < relatives.size(); i++){
			if (victim2 == relatives.get(i)){
				correct = false;
			}
		}
		
		assertTrue("removeFamilyConnection should remove the family member", correct);
	}  


    /**
     * Tests the removePersonalBelonging method of DisasterVictim.
     * This method tests the functionality of removing a personal belonging from a victim.
     * It verifies that the specified supply is successfully removed from the victim's personal belongings.
     */
	@Test
	public void testRemovePersonalBelonging() {
		
			SupplyItem supplyToRemove = suppliesToSet.get(0); 
			victim.addPersonalBelonging(supplyToRemove); 
			victim.removePersonalBelonging(supplyToRemove);

			Supply testedSupply = victim.getPersonalBelongings();
			ArrayList<SupplyItem> testedSupplies = testedSupply.getSupplies();
			boolean correct = true;
	 
			for (int i = 0; i < testedSupplies.size(); i++){
				if (supplyToRemove == testedSupplies.get(i)){
					correct = false;
					break;
				}
			}

		assertTrue("removePersonalBelonging should remove the supply from personal belongings", correct);
	}



	/**
     * Tests the setFamilyConnection method of DisasterVictim.
     * This method tests the functionality of setting family connections for a victim.
     * It verifies that the family relation is correctly set by comparing expected and actual relations.
     */
	@Test
	public void testSetFamilyConnection() {
		FamilyRelation relation = new FamilyRelation(victim1);
		
		relation.addRelative(victim2, "SIBLING");
		relation.addRelative(victim3, "PARENT");
		
		victim1.setFamilyConnections(relation);
		FamilyRelation testedRelation = victim1.getFamilyConnections();
		
		ArrayList<DisasterVictim> expectedRelatives = relation.getRelatives();
		ArrayList<String> expectedRelations = relation.getRelations();
		
		ArrayList<DisasterVictim> testedRelatives = testedRelation.getRelatives();
		ArrayList<String> testedRelations = testedRealtion.getRelations();
		
		boolean correct = true;
		
		for (int i = 0; i < testedRelatives.size(); i++){
			if (testedRelatives.get(i) != expectedRelatives.get(i) || testedRelations.get(i) != expectedRelations.get(i)){
				correct = false;
				break;
			}
		}
	   assertTrue("Family relation should be set", correct);
	}


	/**
     * Tests the setMedicalRecords method of DisasterVictim.
     * This method tests the functionality of setting medical records for a victim.
     * It verifies that the medical records are correctly updated by comparing expected and actual records.
     */
	@Test
	public void testSetMedicalRecords() {
		Location testLocation = new Location("Shelter Z", "1234 Shelter Ave");
		MedicalRecord testRecord = new MedicalRecord(testLocation, "test for strep", "2024-02-09");
		boolean correct = true;

		ArrayList<MedicalRecord> newRecords = new ArrayList<>();
		newRecords.add(testRecord);
		victim.setMedicalRecords(newRecords);
		ArrayList<MedicalRecord> actualRecords = victim.getMedicalRecords();


		boolean correct = true;
		// We have not studied overriding equals in arrays of custom objects so we will manually evaluate equality
		if (newRecords.size() != actualRecords.size()) {
			correct = false;
		} else {
			int i;
			for (i=0;i<newRecords.size();i++) {
				if (actualRecords.get(i) != newRecords.get(i)) {
					correct = false;
				}
			}
		}
		assertTrue("setMedicalRecords should correctly update medical records", correct);
	}


    /**
     * Tests the setPersonalBelongings method of DisasterVictim.
     * This method tests the functionality of setting personal belongings for a victim.
     * It verifies that the personal belongings are correctly updated by comparing expected and actual supplies.
     */
    @Test
    public void testSetPersonalBelongings() {
        ArrayList<SupplyItem> expectedSupplies = new ArrayList<>();
        expectedSupplies.add(new SupplyItem("Tent", 1));
        expectedSupplies.add(new SupplyItem("Jug", 3));
        Supply expectedSupply = new Supply();
        expectedSupply.setSupplies(expectedSupplies);
        victim.setPersonalBelongings(expectedSupply);
        
        Supply testedSupply = victim.getPersonalBelongings();
        
        
        ArrayList<SupplyItem> testedSupplies = testedSupply.getSupplies();
        
        
        boolean correct = true;
        
        if (testedSupplies.size() != expectedSupplies.size()){
            correct = false;
        }
        else{
            for (int i = 0; i < testedSupplies.size(); i++){
                if(!testedSupplies.get(i).getType().equals(expectedSupplies.get(i).getType()) || testedSupplies.get(i).getQuantity() != expectedSupplies.get(i).getQuantity()){
                    correct = false;
                    break; // No need to continue the loop if a discrepancy is found
                }
            }
        }

        assertTrue("setPersonalBelongings should correctly update personal belongings", correct);
    }


}

