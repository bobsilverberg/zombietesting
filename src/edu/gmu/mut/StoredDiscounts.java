package edu.gmu.mut;

import java.util.ArrayList;
import edu.gmu.mut.Discount;

/**
 * Class Purchase History represents a group of Purchases.
 */
public class StoredDiscounts {

	/** The purchase history. */
	private ArrayList discounts;

	/** Adds a purchase to the history */
	public void add(Discount p) {
		discounts.add(p);
	}
	
	public ArrayList getDiscounts() {
		return discounts;
	}

	public int getNumberOfDiscounts() {
		
		return discounts.size();
	}
	
	public StoredDiscounts(){
		this.discounts = new ArrayList();
	}

}
