package edu.ucalgary.oop;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;

/**
 * Tests for the FamilyRelation class.
 */
public class FamilyRelationTest {
    private ArrayList<DisasterVictim> relativesToSet;
    private DisasterVictim victim;
    private FamilyRelation familyRelation;
    private ArrayList<String> relation;

    /**
     * Set up initial data for testing.
     */
    @Before
    public void setUp() {
        relativesToSet = new ArrayList<>();
        victim = new DisasterVictim("John", "2024-01-15");
        familyRelation = new FamilyRelation(victim);
        relation = new ArrayList<>();

        relativesToSet.add(new DisasterVictim("Freda", "2024-01-16"));
        relativesToSet.add(new DisasterVictim("Fredrick", "2024-01-17"));

        relation.add("SPOUSE");
        relation.add("CHILD");

        familyRelation.setRelatives(relativesToSet);
        familyRelation.setRelations(relation);
    }

    /**
     * Test for setting relatives.
     */
    @Test
    public void testSetRelative() {
        ArrayList<DisasterVictim> testedRelatives = familyRelation.getRelatives();
        assertEquals("The set relatives function should properly fill the relatives attribute", testedRelatives.get(0), relativesToSet.get(0));
        assertEquals("The set relatives function should properly fill the relatives attribute", testedRelatives.get(1), relativesToSet.get(1));
    }

    /**
     * Test for setting relations.
     */
    @Test
    public void testSetRelation() {
        ArrayList<String> testedRelations = familyRelation.getRelations();
        assertEquals("the setRelations function should properly fill the relations attribute", testedRelations.get(0), relation.get(0));
        assertEquals("the setRelations function should properly fill the relations attribute", testedRelations.get(1), relation.get(1));
    }

    /**
     * Test for adding a relative.
     */
    @Test
    public void testAddRelative() {
        DisasterVictim newPerson = new DisasterVictim("Jim", "2024-01-18");
        String newRelation = "SIBLING";

        familyRelation.addRelative(newPerson, newRelation);

        ArrayList<DisasterVictim> testedRelatives = familyRelation.getRelatives();
        ArrayList<String> testedRelations = familyRelation.getRelations();

        assertEquals("existing relatives should not be overwritten", testedRelatives.get(0), relativesToSet.get(0));
        assertEquals("existing relations should not be overwritten", testedRelations.get(0), relation.get(0));
        assertEquals("existing relatives should not be overwritten", testedRelatives.get(1), relativesToSet.get(1));
        assertEquals("existing relations should not be overwritten", testedRelations.get(1), relation.get(1));
        assertEquals("new relatives should be added to the array", testedRelatives.get(2), newPerson);
        assertEquals("new relations should be added to the array", testedRelations.get(2), newRelation);
    }

    /**
     * Test for removing a relative.
     */
    @Test
    public void testRemoveRelative() {
        DisasterVictim victimToRemove = relativesToSet.get(0);
        String relationToRemove = relation.get(0);
        familyRelation.removeRelative(victimToRemove);

        ArrayList<DisasterVictim> testedRelatives = familyRelation.getRelatives();
        ArrayList<String> testedRelations = familyRelation.getRelations();

        boolean correct = true;

        for (int i = 0; i < testedRelatives.size(); i++) {
            if (testedRelatives.get(i) == victimToRemove) {
                correct = false;
                break;
            }
            if (testedRelations.get(i) == relationToRemove) {
                correct = false;
                break;
            }
        }
        assertTrue("RemoveRelative should remove the relative and its corresponding relation", correct);
    }

    /**
     * Test for getting the person.
     */
    @Test
    public void testGetPerson() {
        assertEquals("Get person should return the person field", familyRelation.getPerson(), victim);
    }
}
