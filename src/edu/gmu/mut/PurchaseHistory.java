package edu.gmu.mut;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import edu.gmu.mut.Purchase;

/**
 * Class Purchase History represents a group of Purchases.
 */
public class PurchaseHistory {

	/** The purchase history. */
	private ArrayList<Purchase> purchases;

	/** Adds a purchase to the history */
	public void add(Purchase p) {
		purchases.add(p);
	}
	
	/**
	 * Gets the purchases.
	 *
	 * @return the purchases
	 */
	public ArrayList getPurchases() {
		return purchases;
	}

	/**
	 * Gets the number of all purchases.
	 *
	 * @return the number of all purchases
	 */
	public int getNumberOfPurchases() {
		
		return purchases.size();
	}
	
	/**
	 * Gets the total amount of all purchases.
	 *
	 * @return the total amount of all purchases
	 */
	public BigDecimal getTotalAmount() {
		
		BigDecimal total = new BigDecimal(0);
		for (int i = 0; i < purchases.size(); i++) {
			total = total.add(purchases.get(i).getPrice());
		}
		return total;
	}
	
	
	/**
	 * Instantiates a new account.
	 */
	public PurchaseHistory(){
		this.purchases = new ArrayList<Purchase>();
	}
	
}
