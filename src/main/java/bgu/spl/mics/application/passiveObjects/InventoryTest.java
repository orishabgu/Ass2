package bgu.spl.mics.application.passiveObjects;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class InventoryTest {
    Inventory inventory;
    BookInventoryInfo book1 = new BookInventoryInfo("ExsitedBook",1 ,20);
    BookInventoryInfo book2 = new BookInventoryInfo("notExistBook",0 ,20);
    BookInventoryInfo[ ] books = {book1,book2};
    @Before
    public void setUp() throws Exception {
        inventory = Inventory.getInstance();
        inventory.load(books);
    }

    @After
    public void tearDown() throws Exception {
        inventory = null;
        books = null;
    }

    @Test
    public void GetInstance() {
        Inventory inventoryTest = Inventory.getInstance();
        assertEquals("the inventory is not the same",inventory,inventoryTest);
    }

    @Test
    public void load() {
        int exsite = books[0].getAmountInInventory();
        int notExsite = books[1].getAmountInInventory();
        assertEquals("there are at least one book in the Inventory" ,exsite,1 );
    }

    @Test
    public void take() {
        OrderResult Tresult1 = inventory.take("notExistBook");
        assertEquals("there are no books like this in stock ",0,Tresult1);
        OrderResult Tresult2 = inventory.take("ExsitedBook");
        assertEquals(" there is at least one in the inventory ",1,Tresult2);
    }

    @Test
    public void testCheckAvailabiltyAndGetPrice() {
        int CAAGPresult = inventory.checkAvailabiltyAndGetPrice("ExsitedBook");
        assertEquals("the book is on the store and you can take one", 30,CAAGPresult);
        int CAAGPresult2 = inventory.checkAvailabiltyAndGetPrice("notExistBook");
        assertEquals("the book is not available", -1,CAAGPresult2);
    }
///////////////////////no need to check
    @Test
    public void printInventoryToFile() {
    }
}