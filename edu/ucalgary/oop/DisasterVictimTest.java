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

    @Before
    public void setUp() {
        victim = new DisasterVictim(expectedFirstName, EXPECTED_ENTRY_DATE);
        suppliesToSet = new ArrayList<>();
        suppliesToSet.add(new SupplyItem("Water Bottle", 10));
        suppliesToSet.add(new SupplyItem("Blanket", 5));
        
        DisasterVictim victim1 = new DisasterVictim("Jane", "2024-01-20");
        DisasterVictim victim2 = new DisasterVictim("John", "2024-01-22");
        DisasterVictim victim3 = new DisasterVictim("Jim", "2024-01-22");

        
    }

  		  

  @Test
    public void testConstructorWithValidEntryDate() {
        String validEntryDate = "2024-01-18";
        DisasterVictim victim = new DisasterVictim("Freda", validEntryDate);
        assertNotNull("Constructor should successfully create an instance with a valid entry date", victim);
        assertEquals("Constructor should set the entry date correctly", validEntryDate, victim.getEntryDate());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWithInvalidEntryDateFormat() {
        String invalidEntryDate = "18/01/2024"; // Incorrect format according to your specifications
        new DisasterVictim("Freda", invalidEntryDate);
        // Expecting IllegalArgumentException due to invalid date format
    }


   @Test
    public void testSetDateOfBirth() {
        String newDateOfBirth = "1987-05-21";
        victim.setDateOfBirth(newDateOfBirth);
        assertEquals("setDateOfBirth should correctly update the date of birth", newDateOfBirth, victim.getDateOfBirth());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetDateOfBirthWithInvalidFormat() {
        victim.setDateOfBirth(invalidDate); // This format should cause an exception
    }
	

    @Test
    public void testGetAssignedSocialID() {
        // The next victim should have an ID one higher than the previous victim
        // Tests can be run in any order so two victims will be created
        DisasterVictim newVictim = new DisasterVictim("Kash", "2024-01-21");
        int expectedSocialId = newVictim.getAssignedSocialID() + 1;
        DisasterVictim actualVictim = new DisasterVictim("Adeleke", "2024-01-22");

        assertEquals("getAssignedSocialID should return the expected social ID", expectedSocialId, actualVictim.getAssignedSocialID());
    }

    @Test
    public void testGetEntryDate() {
        assertEquals("getEntryDate should return the expected entry date", EXPECTED_ENTRY_DATE, victim.getEntryDate());
    }
   
    @Test
    public void testSetAndGetGender() {
        String newGender = "male";
        victim.setGender(newGender);
        assertEquals("setGender should update and getGender should return the new gender", newGender.toLowerCase(), victim.getGender());
    }
	
	

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
			}
		}

        assertTrue("addPersonalBelonging should add the supply to personal belongings", correct);
    }

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


	@Test
	public void testSetPersonalBelongings() {
		ArrayList<SupplyItem> expectedSupplies = new ArrayList<>();
		expectedSupplies.add(new SupplyItem("Tent", 1));
		expectedSupplies.add(new SupplyItem("Jug", 3));
		Supply expectedSupply = new supply();
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
				if(testedSupplies.get(i).getType() != expectedSupplies.get(i).getType() && testedSupplies.get(i).getQuantity() != expectedSupplies.get(i).getQuantity()){
					correct = false;
				}
			}
		}

		assertTrue("setPersonalBelongings should correctly update personal belongings", correct);
	}

}

