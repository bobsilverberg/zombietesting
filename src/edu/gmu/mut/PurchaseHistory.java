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
	private ArrayList purchases;

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
	 * Gets the total amount of all purchases over a date range.
	 *
	 * @return the total amount of all purchases over a date range
	 */
	public BigDecimal getTotalAmount(Calendar startDate, Calendar endDate) {
		
		BigDecimal total = new BigDecimal(0);

		for (int i = 0; i < purchases.size(); i++) {
			Purchase p = (Purchase) purchases.get(i);
			if (startDate.before(p.getDateOfPurchase()) && endDate.after(p.getDateOfPurchase())) {
				total = total.add(p.getPrice());
			}
		}
		return total;
	}
	
	public int getPurchaseCount() {
		return purchases.size();
	}
	
	public int getPurchaseCount(Calendar startDate, Calendar endDate) {
		int count = 0;
		
		for (int i = 0; i < purchases.size(); i++) {
			Purchase p = (Purchase) purchases.get(i);
			if (startDate.before(p.getDateOfPurchase()) && endDate.after(p.getDateOfPurchase())) {
				count ++;
			}
		}
		return count;
	}
	
	
	/**
	 * Instantiates a new purchase history.
	 */
	public PurchaseHistory(){
		this.purchases = new ArrayList();
	}

	public BigDecimal getTotalAmountForGenres(String[] genres) {
		
		BigDecimal total = new BigDecimal(0);
		
		for (int i = 0; i < purchases.size(); i++) {
			Purchase p = (Purchase) purchases.get(i);
			for (int j =0; j < genres.length; j++) {
				if (p.getGenre() == genres[j]) {
					total = total.add(p.getPrice());
				}
			}
		}
		return total;
	}

}

