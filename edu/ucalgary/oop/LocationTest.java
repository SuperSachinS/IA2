package edu.ucalgary.oop;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;

/**
 * Tests for the Location class.
 */
public class LocationTest {
    private Location location;
    private DisasterVictim victim;
    private Supply supply;
    private ArrayList<SupplyItem> supplyItems;

    /**
     * Set up initial data for testing.
     */
    @Before
    public void setUp() {
        // Initializing test objects before each test method
        location = new Location("Shelter A", "1234 Shelter Ave");
        victim = new DisasterVictim("John Doe", "2024-01-01");
        supply = new Supply("Water Bottle", 10);
        supplyItems = new ArrayList<>();

        supplyItems.add(new SupplyItem("cube", 100));
        supplyItems.add(new SupplyItem("triangle", 200));
        supplyItems.add(new SupplyItem("circle", 400));

        supply.setSupplies(supplyItems);
    }

    // Helper method to check if a supply is in the list
    private boolean containsSupply(ArrayList<Supply> supplies, Supply supplyToCheck) {
        return supplies.contains(supplyToCheck);
    }

    /**
     * Test for the constructor of the Location class.
     */
    @Test
    public void testConstructor() {
        assertNotNull("Constructor should create a non-null Location object", location);
        assertEquals("Constructor should set the name correctly", "Shelter A", location.getName());
        assertEquals("Constructor should set the address correctly", "1234 Shelter Ave", location.getAddress());
    }

    /**
     * Test for setting the name of the location.
     */
    @Test
    public void testSetName() {
        String newName = "Shelter B";
        location.setName(newName);
        assertEquals("setName should update the name of the location", newName, location.getName());
    }

    /**
     * Test for setting the address of the location.
     */
    @Test
    public void testSetAddress() {
        String newAddress = "4321 Shelter Blvd";
        location.setAddress(newAddress);
        assertEquals("setAddress should update the address of the location", newAddress, location.getAddress());
    }

    /**
     * Test for adding an occupant to the location.
     */
    @Test
    public void testAddOccupant() {
        location.addOccupant(victim);
        assertTrue("addOccupant should add a disaster victim to the occupants list", location.getOccupants().contains(victim));
    }

    /**
     * Test for removing an occupant from the location.
     */
    @Test
    public void testRemoveOccupant() {
        location.addOccupant(victim); // Ensure the victim is added first
        location.removeOccupant(victim);
        assertFalse("removeOccupant should remove the disaster victim from the occupants list", location.getOccupants().contains(victim));
    }

    /**
     * Test for setting and getting the occupants of the location.
     */
    @Test
    public void testSetAndGetOccupants() {
        ArrayList<DisasterVictim> newOccupants = new ArrayList<>();
        newOccupants.add(victim);
        location.setOccupants(newOccupants);
        assertTrue("setOccupants should replace the occupants list with the new list", location.getOccupants().containsAll(newOccupants));
    }

    /**
     * Test for setting and getting the supplies of the location.
     */
    @Test
    public void testSetAndGetSupplies() {
        Supply newSupplies = new Supply();
        newSupplies.add(new SupplyItem("cylinder", 50));
        location.setSupplies(newSupplies);
        assertEquals("setSupplies should replace the supplies list with the new list", newSupplies, location.getSupplies());
    }

    /**
     * Test for receiving supplies at the location.
     */
    @Test
    public void testReceiveSupplies() {
        SupplyItem newSupply = new SupplyItem("cylinder", 50);
        location.receiveSupplies(newSupply);

        ArrayList<Supply> testedSupplies = location.getSupplies();

        boolean correct = true;

        for (int i = 0; i < supplyItems.size(); i++) {
            if (supplyItems.get(i) != testedSupplies.get(i)) {
                correct = false;
                break;
            }
        }
        if (testedSupplies.get(3) != newSupply) {
            correct = false;
        }
        assertTrue("receiveSupplies should add the next supplyitem to the location's supply", correct);
    }

    /**
     * Test for sending supplies from the location to another location.
     */
    @Test
    public void testSendSupplies() {
        Location destinationLocation = new Location("Shelter B", "4321 home ST");
        SupplyItem supplyToSend = new SupplyItem("cube", 50);

        location.sendSupplies("cube", 50, destinationLocation);

        Supply receivedSupplies = destinationLocation.getSupplies();
        SupplyItem receivedSupply = receivedSupplies.getSupply("cube");
        Supply remainingSupplies = location.getSupplies();
        SupplyItem remainingSupply = remainingSupplies.getSupply("cube");

        assertEquals("destination Location should have their supply updated with the new supplyItem", receivedSupply, supplyToSend);
        assertEquals("supply amount should be correctly removed from the location that is sending the supplies", remainingSupply.getQuantity(), 50);
    }

    /**
     * Test for distributing supplies from the location to a disaster victim.
     */
    @Test
    public void testDistributeSupplies() {
        location.distributeSupplies("cube", 50, victim);
        Supply personalBelongings = victim.getPersonalBelongings();
        SupplyItem personalSupply = personalBelongings.getSupply("cube");
        assertEquals("disastervictim's supply type should match the location", personalSupply.getType(), "cube");
        assertEquals("disastervictim's supply the quantity should match the location", personalSupply.getQuantity(), 50);
    }
}
