
package edu.ucalgary.oop;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class SupplyTest {
	private Supply supply;
	private ArrayList<SupplyItem> supplyItems;
	private ArrayList<SupplyItem> newSupplyItems;
	private ArrayList<String> dietaryCodes1;
	private ArrayList<String> dietaryCodes2;
	
	/*
	3 getters
	1 setter 
	2 adders
	1 remove	
	*/
	
	@Before
	public void setUp(){
		supplyItems = new ArrayList<SupplyItem>();
		newSupplyItems = new ArrayList<SupplyItem>();
		dietaryCodes1 = new ArrayList<String>();
		dietaryCodes2 = new ArrayList<String>();
		
		dietaryCodes1.add("AVML");
		dietaryCodes2.add("AVML");
		dietaryCodes2.add("DBML");
		
		supplyItems.add(new SupplyItem("cube", 100));
		supplyItems.add(new SupplyItem("triangle", 200, dietaryCodes1));
		supplyItems.add(new SupplyItem("circle", 400, dietaryCodes2));
		
		supply = new Supply();
		supply.setSupplies(supplyItems);
	}
	
	
	@Test
	public void testSetSupplies(){		
		newSupplyItems = supply.getSupplies();
		
		for (int i = 0; i < 3; i++){
			assertEquals("Supplyitems do not match", newSupplyItems.get(i), supplyItems.get(i);
		}		
	}
	
	@Test
	public void testRemoveSupplies(){
		supply.removeSupply("cube", 100);
		supply.removeSupply("triangle", 150);
		
		newSupplyItems = supply.getSupplies();
		
		assertEquals("first item should be triangle with 50 items", newSupplyItems.get(0).getType(), "triangle");
		assertEquals("first item should be triangle with 50 items", newSupplyItems.get(0).getQuantity(), 50);
		assertEquals("second item should be circle with 400 items", newSupplyItems.get(1).getType(), "circle");
		assertEquals("second item should be circle with 400 items", newSupplyItems.get(1).getQuantity(), 400);
		assertEquals("Length of array should be 2", newSupplyItems.size(), 2);

		
	}
	
	@Test
	public void testRemoveSuppliesInvalidAmount(){
		supply.setSupplies(supplyItems);
		
		boolean validRemoval = supply.remove("cube", 100);
		boolean validRemovel2 = supply.remove("triangle", 1);
		boolean invalidRemoval = supply.remove("circle", 800);
		
		assertTrue("the removal from cube is valid", validRemoval);
		assertTrue("the removal from triangle is valid", validRemovel2);
		assertFalse("the removal from circle is invalid", invalidRemoval);		
	}
	
	@Test
	public void testGetDietaryCode(){
		ArrayList<String> dietaryCodes = new ArrayList<>();
		dietaryCodes.add("AVML");
		dietaryCodes.add("DBML");
		newSupplyItems = supply.getDietaryFood(dietaryCodes);
		
		assertEquals("getDietaryFood should return the the supplyitems that meet the search field", newSupplyItems.get(0), supplyItems.get(2)); 
	}
	
	@Test
	public void testGetSupply(){
		newSupplyItems.add(supply.getSupply("cube"));
		
		assertEquals("getSupply should return the expected supplyitem", newSupplyItems.get(0), supplyItems.get(0));
	}
	
	
}