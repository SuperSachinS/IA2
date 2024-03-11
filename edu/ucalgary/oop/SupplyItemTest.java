package edu.ucalgary.oop;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class SupplyItemTest {
	private SupplyItem expectedSupplyItem;
	
	/*
	tests:
	2 setter tests
	3 getter tests
	2 constructor tests
	2 adder tests
	1 remove test
	*/
	
	@Test
	public void testCreateSupplyItemConstructorNonDietary(){
		expectedSupplyItem = new SupplyItem("block", 100);
		String type = expectedSupplyItem.getType();
		int quantity = expectedSupplyItem.getQuantity();
		
		assertEquals("Type should be of type: block", type, "block");
		assertEquals("Amount should be of amount: 100", quantity, 100);		
	}
	
	@Test
	public void testCreateSupplyItemConstructorDietary(){
		ArrayList<String> dietaryCodes = new ArrayList<String>;
		dietaryCodes.add("AVML");
		dietaryCodes.add("DBML");
		expectedSupplyItem = new SupplyItem("cube", 101, dietaryCodes);
		
		String type = expectedSupplyItem.getType();
		int quantity = expectedSupplyItem.getQuantity();
		ArrayList<String> testedDietaryCodes = expectedSupplyItem.getDietaryCode();
		
		assertEquals("Type should be: cube", "cube", type);
		assertEquals("Amount should be 101", 101, quantity);
		assertEquals("Dietary codes should be: AVML and DBML", dietaryCodes, testedDietaryCodes);		
	}
	@Test 
	public void testSetQuantity(){
		expectedSupplyItem = new SupplyItem("block", 100);
		expectedSupplyItem.setQuantity(50);
		
		int quantity = expectedSupplyItem.getQuantity();
		assertEquals("Amount should be of amount: 50", quantity, 50);		
	}
	@Test
	public void testSetDietaryCodes(){
		ArrayList<String> dietaryCodes = new ArrayList<String>;
		dietaryCodes.add("AVML");
		dietaryCodes.add("DBML");
		expectedSupplyItem = new SupplyItem("cube", 101, dietaryCodes);
		
		ArrayList<String> newDietaryCodes = new ArrayList<String>;
		dietaryCodes.add("GFML");
		dietaryCodes.add("VJML");
		
		ArrayList<String> testedDietaryCodes = expectedSupplyItem.getDietaryCode();
		
		assertEquals("Dietary codes should be: GFML and VJML", newDietaryCodes, testedDietaryCodes);		
	}
	@Test
	public void testAddQuantity(){
		expectedSupplyItem = new SupplyItem("block", 100);
		expectedSupplyItem.addQuantity(50);
		
		int quantity = expectedSupplyItem.getQuantity();
		
		assertEquals("Amount should be 150", 150, quantity);
	}
	
	@Test
	public void testAddDietaryCode(){
		expectedSupplyItem = new SupplyItem("block", 100);
		
		expectedSupplyItem.addDietaryCode("GFML");
		String dietaryCodes = expectedSupplyItem.getDietaryCode();
		
		assertEquals("Dietary codee should be: GFML", dietaryCodes, "GFML");	
	}
	@Test
	public void testRemoveDietaryCode(){
		ArrayList<String> dietaryCodes = new ArrayList<String>;
		dietaryCodes.add("AVML");
		dietaryCodes.add("DBML");
		expectedSupplyItem = new SupplyItem("cube", 101, dietaryCodes);
		
		expectedSupplyItem.remove("AVML");
		

		ArrayList<String> testedDietaryCodes = expectedSupplyItem.getDietaryCode();
		assertEquals("Dietary code should be: DBML", "DBML", testedDietaryCodes);

	}
	
	
	
}