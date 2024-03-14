package edu.ucalgary.oop;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;

/**
 * Tests for the SupplyItem class.
 */
public class SupplyItemTest {
    private SupplyItem expectedSupplyItem;
	/*
	• AVML - Asian vegetarian meal
	• DBML - Diabetic meal
	• GFML - Gluten intolerant meal
	• KSML - Kosher meal
	• LSML - Low salt meal
	• MOML - Muslim meal
	• PFML - Peanut-free meal
	• VGML - Vegan meal
	• VJML - Vegetarian Jain meal
	*/
    /**
     * Setting up initial data for testing.
     */
    @Before
    public void setUp() {
        expectedSupplyItem = new SupplyItem("block", 100);
    }

    /**
     * Test case for creating a supply item with a non-dietary type using the constructor.
     */
    @Test
    public void testCreateSupplyItemConstructorNonDietary() {
        String type = expectedSupplyItem.getType();
        int quantity = expectedSupplyItem.getQuantity();

        assertEquals("Type should be of type: block", "block", type);
        assertEquals("Amount should be of amount: 100", 100, quantity);
    }

    /**
     * Test case for creating a supply item with dietary codes using the constructor.
     */
    @Test
    public void testCreateSupplyItemConstructorDietary() {
        ArrayList<String> dietaryCodes = new ArrayList<>();
        dietaryCodes.add("AVML");
        dietaryCodes.add("DBML");
        expectedSupplyItem = new SupplyItem("cube", 101, dietaryCodes);

        String type = expectedSupplyItem.getType();
        int quantity = expectedSupplyItem.getQuantity();
        ArrayList<String> testedDietaryCodes = expectedSupplyItem.getDietaryCode();

        assertEquals("Type should be: cube", "cube", type);
        assertEquals("Amount should be 101", 101, quantity);

        assertTrue("Dietary codes should be: AVML and DBML", testedDietaryCodes.containsAll(dietaryCodes));
    }

    /**
     * Test case for setting the quantity of a supply item.
     */
    @Test
    public void testSetQuantity() {
        expectedSupplyItem.setQuantity(50);

        int quantity = expectedSupplyItem.getQuantity();
        assertEquals("Amount should be of amount: 50", 50, quantity);
    }

    /**
     * Test case for setting dietary codes for a supply item.
     */
    @Test
    public void testSetDietaryCodes() {
        ArrayList<String> dietaryCodes = new ArrayList<>();
        dietaryCodes.add("AVML");
        dietaryCodes.add("DBML");
        expectedSupplyItem = new SupplyItem("cube", 101, dietaryCodes);
        ArrayList<String> newDietaryCodes = new ArrayList<>();
        newDietaryCodes.add("GFML");
        newDietaryCodes.add("VJML");

        expectedSupplyItem.setDietaryCode(newDietaryCodes);

        ArrayList<String> testedDietaryCodes = expectedSupplyItem.getDietaryCode();
        assertTrue("Dietary codes should be set to the new codes GFML and VJML", testedDietaryCodes.containsAll(newDietaryCodes));
    }

    /**
     * Test case for adding quantity to a supply item.
     */
    @Test
    public void testAddQuantity() {
        expectedSupplyItem.addQuantity(50);

        int quantity = expectedSupplyItem.getQuantity();

        assertEquals("Amount should be 150", 150, quantity);
    }

    /**
     * Test case for adding a dietary code to a supply item.
     */
    @Test
    public void testAddDietaryCode() {
        expectedSupplyItem.addDietaryCode("GFML");
        ArrayList<String> dietaryCodes = expectedSupplyItem.getDietaryCode();

        assertTrue("Dietary code should be: GFML", dietaryCodes.contains("GFML"));
    }

    /**
     * Test case for removing a dietary code from a supply item.
     */
    @Test
    public void testRemoveDietaryCode() {
        ArrayList<String> dietaryCodes = new ArrayList<>();
        dietaryCodes.add("AVML");
        dietaryCodes.add("DBML");
        expectedSupplyItem = new SupplyItem("cube", 101, dietaryCodes);

        expectedSupplyItem.removeDietaryCode("AVML");

        ArrayList<String> testedDietaryCodes = expectedSupplyItem.getDietaryCode();
        assertFalse("Dietary code AVML should be removed", testedDietaryCodes.contains("AVML"));
    }


    /**
     * Test for seeing that SupplyItem references the enumeration DietaryCodes
	 * In correct behavior invalid dietaryCodes would be rejected and throw an illegal argument exception
     */
	@Test(expected = IllegalArgumentException.class)
	public void testEnumerationInvalidDietaryCode(){
		SupplyItem invalidSupplyItem = new SupplyItem("car", 5, "ABCD");
		//expecting an illegal arguement exception
	}

}
