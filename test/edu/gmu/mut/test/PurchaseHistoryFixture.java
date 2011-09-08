package edu.gmu.mut.test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

import edu.gmu.mut.PurchaseHistory;
import edu.gmu.mut.Purchase;

public class PurchaseHistoryFixture {

	
	static String[] genres = { "Reggae", 
								"Jazz", 
								"Blues", 
								"Rock", 
								"Classical", 
								"Punk", 
								"Country", 
								"Indie",
								"Rap",
								"Eclectic",
								"Latin",
								"Polka" };
	
	static BigDecimal[] prices = {  new BigDecimal( .99),
									new BigDecimal( 1.99),
									new BigDecimal( 2.99),
									new BigDecimal( 3.99),
									new BigDecimal( 4.99),
									new BigDecimal( 5.99),
									new BigDecimal( 6.99),
									new BigDecimal( 7.99),
									new BigDecimal( 9.99)
								};
	
	static GregorianCalendar[] purchaseDates = {
		new GregorianCalendar(2010, Calendar.JANUARY, 5),
		new GregorianCalendar(2010, Calendar.JANUARY, 6),
		new GregorianCalendar(2010, Calendar.FEBRUARY, 5),
		new GregorianCalendar(2010, Calendar.FEBRUARY, 6),
		new GregorianCalendar(2010, Calendar.MARCH, 5),
		new GregorianCalendar(2010, Calendar.MARCH, 6),
		new GregorianCalendar(2010, Calendar.APRIL, 5),
		new GregorianCalendar(2010, Calendar.APRIL, 6),
		new GregorianCalendar(2010, Calendar.MAY, 5),
		new GregorianCalendar(2010, Calendar.MAY, 6),
		new GregorianCalendar(2010, Calendar.JUNE, 5),
		new GregorianCalendar(2010, Calendar.JUNE, 6),
		new GregorianCalendar(2010, Calendar.JULY, 5),
		new GregorianCalendar(2010, Calendar.JULY, 6),
		new GregorianCalendar(2010, Calendar.AUGUST, 5),
		new GregorianCalendar(2010, Calendar.AUGUST, 6),
		new GregorianCalendar(2010, Calendar.SEPTEMBER, 5),
		new GregorianCalendar(2010, Calendar.SEPTEMBER, 6),
		new GregorianCalendar(2010, Calendar.OCTOBER, 5),
		new GregorianCalendar(2010, Calendar.OCTOBER, 6),
		new GregorianCalendar(2010, Calendar.NOVEMBER, 5),
		new GregorianCalendar(2010, Calendar.NOVEMBER, 6),
		new GregorianCalendar(2010, Calendar.DECEMBER, 5),
		new GregorianCalendar(2010, Calendar.DECEMBER, 6),
		new GregorianCalendar(2011, Calendar.JANUARY, 5),
		new GregorianCalendar(2011, Calendar.JANUARY, 6),
		new GregorianCalendar(2011, Calendar.FEBRUARY, 5),
		new GregorianCalendar(2011, Calendar.FEBRUARY, 6),
		new GregorianCalendar(2011, Calendar.MARCH, 5),
		new GregorianCalendar(2011, Calendar.MARCH, 6),
		new GregorianCalendar(2011, Calendar.APRIL, 5),
		new GregorianCalendar(2011, Calendar.APRIL, 6),
		new GregorianCalendar(2011, Calendar.MAY, 5),
		new GregorianCalendar(2011, Calendar.MAY, 6),
		new GregorianCalendar(2011, Calendar.JUNE, 5),
		new GregorianCalendar(2011, Calendar.JUNE, 6),
		new GregorianCalendar(2011, Calendar.JULY, 5),
		new GregorianCalendar(2011, Calendar.JULY, 6),
		new GregorianCalendar(2011, Calendar.AUGUST, 5),
		new GregorianCalendar(2011, Calendar.AUGUST, 6)
		
	};
	
	
	
	/**
	 * 
	 * Given a int representing a number of purchases, this generates a psuedo-random set 
	 * of purchases for an account.  Change the fixture class static members for more
	 * variation.  Note, that being random, this may not cover desired inputs for your tests.
	 * 
	 * @param numberOfPurchases An int representing the desired number of purchases to generate.
	 * 
	 * */
	public static PurchaseHistory generateRandomPurchaseHistory(int numberOfPurchases) {
		PurchaseHistory purchases = new PurchaseHistory();		
		Random rand = new Random();
		for(int i = 0; i < numberOfPurchases; i++){
			String genre = genres[ rand.nextInt(genres.length-1) ];
			BigDecimal price = prices[ rand.nextInt(prices.length-1) ];
			Calendar purchaseDate = purchaseDates[ rand.nextInt( purchaseDates.length-1) ];
			Purchase p = new Purchase(  genre, price, purchaseDate);
			purchases.add(p);
		}
		
		return purchases;
	}
	
	public static PurchaseHistory getEmptyPurchaseHistory(){
		PurchaseHistory purchases = new PurchaseHistory();		
		return purchases;
	}
	
	public static PurchaseHistory getPurchasesTotalling100(){
		PurchaseHistory purchases = new PurchaseHistory();		
		Purchase p1 = new Purchase("jazz", new BigDecimal(25), Calendar.getInstance());
		purchases.add(p1);
		Purchase p2 = new Purchase("jazz", new BigDecimal(25), Calendar.getInstance());
		purchases.add(p2);
		Purchase p3 = new Purchase("jazz", new BigDecimal(50), Calendar.getInstance());
		purchases.add(p3);
		return purchases;
	}

	public static PurchaseHistory getPurchasesTotalling100OverPastYear() {
		PurchaseHistory purchases = new PurchaseHistory();
		Calendar pd1 = Calendar.getInstance();
		pd1.add(Calendar.DATE, -1);
		Purchase p1 = new Purchase("jazz", new BigDecimal(25), pd1);
		purchases.add(p1);
		Calendar pd2 = Calendar.getInstance();
		pd2.add(Calendar.MONTH, -6);
		Purchase p2 = new Purchase("jazz", new BigDecimal(25), pd2);
		purchases.add(p2);
		Calendar pd3 = Calendar.getInstance();
		pd3.add(Calendar.MONTH, -10);
		Purchase p3 = new Purchase("jazz", new BigDecimal(50), pd3);
		purchases.add(p3);
		Calendar pd4 = Calendar.getInstance();
		pd4.add(Calendar.MONTH, -14);
		Purchase p4 = new Purchase("jazz", new BigDecimal(50), pd4);
		purchases.add(p4);
		return purchases;
	}
	
} //end class
