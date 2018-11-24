package bgu.spl.mics.application.passiveObjects;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class InventoryTest {
    Inventory inventory;
    @Before
    public void setUp() throws Exception {
        inventory = Inventory.getInstance();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testGetInstance() {
        Inventory inventoryTest = Inventory.getInstance();

        assertEquals("the inventory is not the same",inventory,inventoryTest);
    }

    @Test
    public void load() {
    }

    @Test
    public void take() {
    }

    @Test
    public void checkAvailabiltyAndGetPrice() {
    }

    @Test
    public void printInventoryToFile() {
    }
}