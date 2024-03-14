package edu.ucalgary.oop;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;

/**
 * Tests for the Supply class.
 */
public class SupplyTest {
    private Supply supply;
    private ArrayList<SupplyItem> supplyItems;
    private ArrayList<SupplyItem> newSupplyItems;
    private ArrayList<String> dietaryCodes1;
    private ArrayList<String> dietaryCodes2;

    /**
     * Setting up initial data for testing.
     */
    @Before
    public void setUp() {
        supplyItems = new ArrayList<>();
        newSupplyItems = new ArrayList<>();
        dietaryCodes1 = new ArrayList<>();
        dietaryCodes2 = new ArrayList<>();

        dietaryCodes1.add("AVML");
        dietaryCodes2.add("AVML");
        dietaryCodes2.add("DBML");

        supplyItems.add(new SupplyItem("cube", 100));
        supplyItems.add(new SupplyItem("triangle", 200, dietaryCodes1));
        supplyItems.add(new SupplyItem("circle", 400, dietaryCodes2));

        supply = new Supply();
        supply.setSupplies(supplyItems);
    }
    /**
     * Test that constructor created an instance of the supply class.
     */


	@Test
	public void testConstructor(){
		assertnotNull("Constructor should create a non-null Supply object", supply);
	}



    /**
     * Test for setting supplies.
     */
    @Test
    public void testSetSupplies() {
        newSupplyItems = supply.getSupplies();

        for (int i = 0; i < 3; i++) {
            assertEquals("Supply items do not match", newSupplyItems.get(i), supplyItems.get(i));
        }
    }

    /**
     * Test for removing supplies.
     */
    @Test
    public void testRemoveSupplies() {
        supply.removeSupply("cube", 100);
        supply.removeSupply("triangle", 150);

        newSupplyItems = supply.getSupplies();

        assertEquals("First item should be triangle with 50 items", "triangle", newSupplyItems.get(0).getType());
        assertEquals("First item should be triangle with 50 items", 50, newSupplyItems.get(0).getQuantity());
        assertEquals("Second item should be circle with 400 items", "circle", newSupplyItems.get(1).getType());
        assertEquals("Second item should be circle with 400 items", 400, newSupplyItems.get(1).getQuantity());
        assertEquals("Length of array should be 2", 2, newSupplyItems.size());
    }

    /**
     * Test for removing supplies with invalid amounts.
     */
    @Test
    public void testRemoveSuppliesInvalidAmount() {
        supply.setSupplies(supplyItems);

        boolean validRemoval = supply.remove("cube", 100);
        boolean validRemoval2 = supply.remove("triangle", 1);
        boolean invalidRemoval = supply.remove("circle", 800);

        assertTrue("The removal from cube is valid", validRemoval);
        assertTrue("The removal from triangle is valid", validRemoval2);
        assertFalse("The removal from circle is invalid", invalidRemoval);
    }

    /**
     * Test for getting supply items with specific dietary codes.
     */
    @Test
    public void testGetDietaryCode() {
        ArrayList<String> dietaryCodes = new ArrayList<>();
        dietaryCodes.add("AVML");
        dietaryCodes.add("DBML");
        newSupplyItems = supply.getDietaryFood(dietaryCodes);

        assertEquals("getDietaryFood should return the supply items that meet the search field", supplyItems.get(2), newSupplyItems.get(0));
    }

    /**
     * Test for getting a specific supply item by its type.
     */
    @Test
    public void testGetSupply() {
        newSupplyItems.add(supply.getSupply("cube"));

        assertEquals("getSupply should return the expected supply item", supplyItems.get(0), newSupplyItems.get(0));
    }
	
	@Test
	public void testAddSupplyWithNoDietaryCode(){

		supply.addSupply("cylinder", 50);
		
		SupplyItem newSupplyItem = supply.getSupply("cylinder");
		
		assertEquals("addSupply should add the new supplyitem to its arraylist", newSupplyItem.getType(), "cylinder");
		assertEquals("addSupply should add the new supplyitem to its arraylist", newSupplyItem.getQuantity(), 50);
		
	}
	
	@Test
	public void testAddSupplyWithDietaryCode(){
		supply.addSupply("cylinder", 50, "GFML");
		
		SupplyItem newSupplyItem = supply.getSupply("cylinder");

		assertEquals("addSupply should add the new supplyitem to its arraylist", newSupplyItem.getType(), "cylinder");
		assertEquals("addSupply should add the new supplyitem to its arraylist", newSupplyItem.getQuantity(), 50);
		assertEquals("addSupply should add the new supplyitem to its arraylist", newSupplyItem.getDietaryCode(), "GFML");
	}
	
}
