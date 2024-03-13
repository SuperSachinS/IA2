
package edu.ucalgary.oop;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class FamilyRelationTest {
	private ArrayList<DisasterVictims> relativesToSet;
	private DisasterVictim victim;
	private FamilyRelation familyRelation;
	private ArrayList<String> relation;
	
	@Before
	public void setUp(){
		relativestoSet = new ArrayList<>();
		victim = new DisasterVictim("John", "2024-01-15");
		familyRelation = new FamilyRelation(victim);
		relation = new ArrayList<>();
		
		
		relativesToSet.add(new DisasterVictim("Freda", "2024-01-16");
		relativesToSet.add(new DisasterVictim("Fredrick", "2024-01-17");
		
		relation.add("SPOUSE");
		relation.add("CHILD");
		
		familyRelation.setRelatives(relativesToSet);
		familyRelation.setRelations(relation);
	}
	
	@Test
	public void testAddRelative(){
		DisasterVictim newPerson = new DisasterVictim("Jim", "2024-01-18");
		String newRelation = "SIBLING";
		
		familyRelation.addRelative(newPerson, newRelation);
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}