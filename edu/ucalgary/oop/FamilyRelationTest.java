
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
	public void testSetRelative(){
		ArrayList<DisasterVictim> testedRelatives = familyRelation.getRelatives();
		AssertEquals("The set relatives function should properly fill the relatives attribute", testedRelatives.get(0), relativesToSet.get(0));	
		AssertEquals("The set relatives function should properly fill the relatives attribute", testedRelatives.get(1), relativesToSet.get(1));
	}
	
	@Test public void testSetRelation(){
		ArrayList<String> testedRelations = familyRelation.getRelations();
		AssertEquals("the setRelations function should properly fill the relations attribute", testedRelations.get(0), relations.get(0));
		AssertEquals("the setRelations function should properly fill the relations attribute", testedRelations.get(1), relations.get(1));	
	}
	
	
	@Test
	public void testAddRelative(){
		DisasterVictim newPerson = new DisasterVictim("Jim", "2024-01-18");
		String newRelation = "SIBLING";
		
		familyRelation.addRelative(newPerson, newRelation);
		
		
		ArrayList<DisasterVictim> testedRelatives = familyRelation.getRelatives();
		ArrayList<String> testedRelations = familyRelation.getRelations();

		AssertEquals("existing relatives should not be overwritten", testedRelatives.get(0), relativesToSet.get(0));
		AssertEquals("existing relations should not be overwritten", testedRelations.get(0), relation.get(0));
		AssertEquals("existing relatives should not be overwritten", testedRelatives.get(1), relativesToSet.get(1));
		AssertEquals("existing relations should not be overwritten", testedRelations.get(1), relation.get(1));
		AssertEquals("new relatives should be added to the array", testedRelatives.get(2), newPerson);
		AssertEquals("new relations should be added to the array", testedRelations.get(2), newRelation));
	}
	
	@Test
	public void testRemoveRelative(){
		DisasterVictim victimToRemove = new relativesToSet.get(0);
		String relationToRemove = new relations.get(0);
		familyRelation.removeRelative(victimToRemove);
		
		ArrayList<DisasterVictim> testedRelatives = familyRelation.getRelatives();
		ArrayList<String> testedRelations = familyRelation.getRelations();
		
		boolean correct = true;
		
		for (int i = 0; i < testedRelatives.size(); i++){
			if (testedRelatives.get(i) == victimToRemove){
				correct = false;
				break;
			}
			if (testedRelations.get(i) == relationToReomve){
				correct = false;
				break;
			}
		}
		AssertTrue("RemoveRelative should remove the relative and its corresponding relation", correct);
	}
	
	
	@Test
	public void testGetPerson(){
		AssertEquals("Get person should return the person field", familyRelation.getPerson(), victim);
	}
}