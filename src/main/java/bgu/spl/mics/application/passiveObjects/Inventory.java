package bgu.spl.mics.application.passiveObjects;
import java.util.*;
import java.io.*;


/**
 * Passive data-object representing the store inventory.
 * It holds a collection of {@link BookInventoryInfo} for all the
 * books in the store.
 * <p>
 * This class must be implemented safely as a thread-safe singleton.
 * You must not alter any of the given public methods of this class.
 * <p>
 * You can add ONLY private fields and methods to this class as you see fit.
 */
public class Inventory {


	private static Inventory inventory;
	private static boolean inited = false;
	private static BookInventoryInfo[ ] booksInStock;

	private  Inventory(){}

	/**
     * Retrieves the single instance of this class.
     */
	public static Inventory getInstance() {
		if (!inited){
			inventory = new Inventory();
			inited = true;
		}
		return inventory;
	}
	
	/**
     * Initializes the store inventory. This method adds all the items given to the store
     * inventory.
     * <p>
     * @param inventory 	Data structure containing all data necessary for initialization
     * 						of the inventory.
     */
	public void load (BookInventoryInfo[ ] inventory ) {
		BookInventoryInfo[ ] newStock = new BookInventoryInfo[booksInStock.length+inventory.length];
		int i;
		for(i =0;i<booksInStock.length;i++){
			newStock[i]=booksInStock[i];
		}
		for(int j =0;j<inventory.length;j++){
			newStock[i]=inventory[j];
			i++;
		}
		booksInStock=newStock;
	}
	
	/**
     * Attempts to take one book from the store.
     * <p>
     * @param book 		Name of the book to take from the store
     * @return 	an {@link Enum} with options NOT_IN_STOCK and SUCCESSFULLY_TAKEN.
     * 			The first should not change the state of the inventory while the 
     * 			second should reduce by one the number of books of the desired type.
     */
	public OrderResult take (String book) {
		for(int i=0;i<booksInStock.length;i++){
			if(booksInStock[i].getBookTitle()==book && booksInStock[i].getAmountInInventory()>0) {
				booksInStock[i].setAmountInInventory(booksInStock[i].getAmountInInventory() - 1);
				return OrderResult.SUCCESSFULLY_TAKEN;
			}
		}
		return OrderResult.NOT_IN_STOCK;
	}
	
	
	
	/**
     * Checks if a certain book is available in the inventory.
     * <p>
     * @param book 		Name of the book.
     * @return the price of the book if it is available, -1 otherwise.
     */
	public int checkAvailabiltyAndGetPrice(String book) {
		for(int i=0;i<booksInStock.length;i++){
			if(booksInStock[i].getBookTitle()==book && booksInStock[i].getAmountInInventory()>0){
				return booksInStock[i].getPrice();
			}
		}
		return -1;
	}
	
	/**
     * 
     * <p>
     * Prints to a file name @filename a serialized object HashMap<String,Integer> which is a Map of all the books in the inventory. The keys of the Map (type {@link String})
     * should be the titles of the books while the values (type {@link Integer}) should be
     * their respective available amount in the inventory. 
     * This method is called by the main method in order to generate the output.
	 * https://beginnersbook.com/2013/12/how-to-serialize-hashmap-in-java/
     */
	public void printInventoryToFile(String filename){
		HashMap<String ,Integer> hashmap = new HashMap<>();
		////init hasmap
		for(int i=0;i<booksInStock.length;i++){
			hashmap.put(booksInStock[i].getBookTitle(),booksInStock[i].getAmountInInventory());
		}
		try
		{
			FileOutputStream fos = new FileOutputStream(filename);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(hashmap);
			oos.close();
			fos.close();
			System.out.printf("Serialized HashMap data is saved in "+filename);
		}catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
		//TODO: Implement this//check
	}
}
