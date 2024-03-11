
package edu.ucalgary.oop;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class SupplyTest {
	private supply Supply;
	private ArrayList<SupplyItem> supplyItems;
	
	/*
	3 getters
	1 setter 
	2 adders
	1 remove	
	*/
	
	
	@Test
	public void testSetSupplies(){
		ArrayList<SupplyItem> supplyItems = new ArrayList<SupplyItem>;
		ArrayList<SupplyItem> newSupplyItems = new ArrayList<SupplyItem>;
		supplyItems.add(new SupplyItem("cube", 100));
		supplyItems.add(new SupplyItem("triangle", 200));
		supplyItems.add(new SupplyItem("circle", 400));
		
		supply = new Supply();
		supply.setSupplies(supplyItems);
		
		newSupplyItems = supply.getSupplies();
		
		for (int i = 0; i < 3; i++){
			assertEquals("Supplyitems do not match", newSupplyItems[i], supplyItems[i]);
		}		
	}
	
	@Test
	public void testRemoveSupplies(){
		ArrayList<SupplyItem> supplyItems = new ArrayList<SupplyItem>;
		ArrayList<SupplyItem> newSupplyItems = new ArrayList<SupplyItem>;
		supplyItems.add(new SupplyItem("cube", 100));
		supplyItems.add(new SupplyItem("triangle", 200));
		supplyItems.add(new SupplyItem("circle", 400));
		
		supply = new Supply();
		supply.setSupplies(supplyItems);
		
		supply.removeSupply("cube", 100);
		supply.removeSupply("triangle", 150);
		
		newSupplyItems = supply.getSupplies();
		
		assertEquals("first item should be triangle with 50 items", newSupplyItems[0],getType(), "triangle");
		assertEquals("first item should be triangle with 50 items", newSupplyItems[0],getQuantity(), 50);
		assertEquals("second item should be circle with 400 items", newSupplyItems[1],getType(), "circle");
		assertEquals("second item should be circle with 400 items", newSupplyItems[1],getQuantity(), 400);
		assertequals("Length of array should be 2", newSupplyItems.size(), 2);

		
	}
	
	@Test
	public void testRemoveSuppliesInvalidAmount(){
		ArrayList<SupplyItem> supplyItems = new ArrayList<SupplyItem>;
		ArrayList<SupplyItem> newSupplyItems = new ArrayList<SupplyItem>;
		supplyItems.add(new SupplyItem("cube", 100));
		supplyItems.add(new SupplyItem("triangle", 200));
		supplyItems.add(new SupplyItem("circle", 400));
		
		supply = new Supply();
		supply.setSupplies(supplyItems);
		
		boolean validRemoval = supply.remove("cube", 100);
		boolean validRemovel2 = supply.remove("triangle", 1);
		boolean invalidRemoval = supply.remove("circle", 800);
		
		assertTrue("the removal from cube is valid", 
		
	}
	
	
	
}