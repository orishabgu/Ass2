package bgu.spl.mics.application.passiveObjects;

import java.awt.print.Book;

/**
 * Passive data-object representing a information about a certain book in the inventory.
 * You must not alter any of the given public methods of this class.
 * <p>
 * You may add fields and methods to this class as you see fit (including public methods).
 */
public class BookInventoryInfo {

	private String bookTitle;
	private int amount;
	private int price;
	public BookInventoryInfo(String _bookTitle,int _amount,int _price){
		bookTitle =_bookTitle;
		amount = _amount;
		price= _price;
	}
	/**
     * Retrieves the title of this book.
     * <p>
     * @return The title of this book.   
     */
	public String getBookTitle() {
		return bookTitle;
	}

	/**
     * Retrieves the amount of books of this type in the inventory.
     * <p>
     * @return amount of available books.      
     */
	public int getAmountInInventory() {
		return amount;
	}
	////my method - set for amount
	public void setAmountInInventory(int tochange) {
		amount=tochange;
	}

	/**
     * Retrieves the price for  book.
     * <p>
     * @return the price of the book.
     */
	public int getPrice() {
		return price;
	}
	
	

	
}
