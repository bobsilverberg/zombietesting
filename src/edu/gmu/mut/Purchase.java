package edu.gmu.mut;

import java.util.Calendar;
import java.math.BigDecimal;

/**
 * Class Purchase represents an immutable customer purchase.
 */
public class Purchase {

	/** The genre. */
	private String genre;
	
	/** The price. */
	private BigDecimal price;
	
	/** The date of the purchase. */
	private Calendar dateOfPurchase;
	
	/**
	 * Gets the genre.
	 *
	 * @return the genre
	 */
	public String getGenre() {
		return genre;
	}

	/**
	 * Gets the price.
	 *
	 * @return the price
	 */
	public BigDecimal getPrice() {
		return price;
	}

	/**
	 * Gets the date purchased.
	 *
	 * @return the date purchased
	 */
	public Calendar getDateOfPurchase() {
		return dateOfPurchase;
	}
	
	/**
	 * Instantiates a new purchase.
	 */
	public Purchase(String genre, BigDecimal price, Calendar dateOfPurchase){
		this.genre = genre;
		this.price = price;
		this.dateOfPurchase = dateOfPurchase;
	}
	
	public String toString(){
		return  this.genre  + ", " + this.price + ", " + this.dateOfPurchase; 
		
	}

}
