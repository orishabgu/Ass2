package bgu.spl.mics.application.passiveObjects;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Passive data-object representing a customer of the store.
 * You must not alter any of the given public methods of this class.
 * <p>
 * You may add fields and methods to this class as you see fit (including public methods).
 */
public class Customer {

	private final String name;
	private final int id;
	private final String adress;
	private int distance;
	private AtomicInteger creditCard;//////AtomicInteger
	private int availableAmountInCreditCard;
	private List<OrderReceipt> receipts;

	public Customer(String _name,int _id,String _adress,int _distance,int _creditCard,int _availableAmountInCreditCard,List<OrderReceipt> _receipts){
		this.name=_name;
		this.id=_id;
		this.adress=_adress;
		this.distance = _distance;
		this.creditCard.getAndSet(_creditCard);
		this.availableAmountInCreditCard = _availableAmountInCreditCard;
		this.receipts = _receipts;
	}
	/**
     * Retrieves the name of the customer.
     */
	public String getName() {
		return name;
	}

	/**
     * Retrieves the ID of the customer  . 
     */
	public int getId() {
		return id;
	}
	
	/**
     * Retrieves the address of the customer.  
     */
	public String getAddress() {
		return adress;
	}
	
	/**
     * Retrieves the distance of the customer from the store.  
     */
	public int getDistance() {
		return distance;
	}

	
	/**
     * Retrieves a list of receipts for the purchases this customer has made.
     * <p>
     * @return A list of receipts.
     */
	public List<OrderReceipt> getCustomerReceiptList() {
		return receipts;
	}
	
	/**
     * Retrieves the amount of money left on this customers credit card.
     * <p>
     * @return Amount of money left.   
     */
	public int getAvailableCreditAmount() {
		return availableAmountInCreditCard;
	}
	
	/**
     * Retrieves this customers credit card serial number.    
     */
	public int getCreditNumber() {
		int credit= creditCard.getAndAdd(0);
		return credit;
	}

	public void setCreditCard(int newCrdit){
		creditCard.getAndSet(newCrdit);
	}
	
}
