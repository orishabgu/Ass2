package bgu.spl.mics.application.passiveObjects;

/**
 * Passive data-object representing a receipt that should 
 * be sent to a customer after the completion of a BookOrderEvent.
 * You must not alter any of the given public methods of this class.
 * <p>
 * You may add fields and methods to this class as you see fit (including public methods).
 */
public class OrderReceipt {

	private int orderId;
	private String seller;
	private Customer customer;
	private String bookTitle;
	private int bookPrice;
	private int issuedTick;
	private int orderTick;
	private int proccessTick;
	public OrderReceipt(int _orderId, String _seller,Customer _customer, int _bookPrice,String _bookTitle , int _issuedTick,int _orderTick ,int _proccessTick){
		orderId=_orderId;
		seller=_seller;
		customer=_customer;
		bookTitle= _bookTitle;
		bookPrice = _bookPrice;
		issuedTick=_issuedTick;
		orderTick=_orderTick;
		proccessTick=_proccessTick;
	}
	/**
     * Retrieves the orderId of this receipt.
     */
	public int getOrderId() {
		return orderId;
	}
	
	/**
     * Retrieves the name of the selling service which handled the order.
     */
	public String getSeller() {
		return seller;
	}
	
	/**
     * Retrieves the ID of the customer to which this receipt is issued to.
     * <p>
     * @return the ID of the customer
     */
	public int getCustomerId() {
		return customer.getId();
	}
	
	/**
     * Retrieves the name of the book which was bought.
     */
	public String getBookTitle() {
		return bookTitle;
	}
	
	/**
     * Retrieves the price the customer paid for the book.
     */
	public int getPrice() {
		return bookPrice;
	}
	
	/**
     * Retrieves the tick in which this receipt was issued.
     */
	public int getIssuedTick() {
		return issuedTick;
	}
	
	/**
     * Retrieves the tick in which the customer sent the purchase request.
     */
	public int getOrderTick() {
		return orderTick;
	}
	
	/**
     * Retrieves the tick in which the treating selling service started 
     * processing the order.
     */
	public int getProcessTick() {
		return proccessTick;
	}
}
