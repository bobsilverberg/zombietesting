package edu.gmu.mut.test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

import edu.gmu.mut.Account;
import edu.gmu.mut.Purchase;

public class AccountFixture {

	
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
	 * Given a int representing a number of purches, this generates a psuedo-random set 
	 * of purchases for an account.  Change the fixture class static members for more
	 * variation.  Note, that being random, this may not cover desired inputs for your tests.
	 * 
	 * @param numberOfPurchases An int representing the desired number of purchases to generate.
	 * 
	 * */
	public static Account generateRandomAccount(int numberOfPurchases) {
		Calendar regDate;
		Calendar visitDate;
		ArrayList<Purchase> purchases = new ArrayList<Purchase>() ;		
		Random rand = new Random();
		for(int i = 0; i < numberOfPurchases; i++){
			String genre = genres[ rand.nextInt(genres.length-1) ];
			BigDecimal price = prices[ rand.nextInt(prices.length-1) ];
			Calendar purchaseDate = purchaseDates[ rand.nextInt( purchaseDates.length-1) ];
			Purchase p = new Purchase(  genre, price, purchaseDate);
			purchases.add(p);
		}
		
		regDate = new GregorianCalendar(2009,Calendar.JANUARY,1);
		visitDate = new GregorianCalendar(2011,Calendar.AUGUST,1);
		return Account.newInstance("test", "test@if.io", regDate, visitDate, purchases );
	}
	
	
	
	
	public static Account get100DollarSpenderAccount(){
		Calendar regDate;
		Calendar visitDate;
		ArrayList<Purchase> purchases ;
		purchases = new ArrayList();
		Purchase p = new Purchase("Blues", new BigDecimal(100.00), new GregorianCalendar(2010,Calendar.NOVEMBER,24));
		purchases.add(p);
		regDate = new GregorianCalendar(2011,Calendar.MARCH,15);
		visitDate = new GregorianCalendar(2011,Calendar.MARCH,20);
		return Account.newInstance("100$_bill", "100$_test@if.io", regDate, visitDate, purchases );
	}
	
	public static Account getNewAccount(){
		Calendar regDate;
		Calendar visitDate;
		ArrayList<Purchase> purchases ;
		purchases = new ArrayList();
		regDate = new GregorianCalendar(2011,Calendar.MARCH,15);
		visitDate = new GregorianCalendar(2011,Calendar.MARCH,20);
		return Account.newInstance("new test", "new_test@if.io", regDate, visitDate, purchases );
	}

	
	
	public static Account getBasicAccount(){
		Calendar regDate;
		Calendar visitDate;
		ArrayList<Purchase> purchases ;
		purchases = new ArrayList();
		purchases.add( new Purchase("Reggae", new BigDecimal( .99), new GregorianCalendar(2011, Calendar.MARCH, 5)  ));
		purchases.add( new Purchase("Reggae", new BigDecimal( 1.99), new GregorianCalendar(2011, Calendar.MARCH, 5)  ));
		purchases.add( new Purchase("Jazz", new BigDecimal( 9.99), new GregorianCalendar(2011, Calendar.JANUARY, 5)  ));
		purchases.add( new Purchase("Jazz", new BigDecimal(4.99), new GregorianCalendar(2010, Calendar.FEBRUARY, 4)  ));
		purchases.add( new Purchase("Punk", new BigDecimal(1.99), new GregorianCalendar(2010, Calendar.MARCH, 4) ));
		purchases.add( new Purchase("Rock", new BigDecimal(2.99), new GregorianCalendar(2010, Calendar.APRIL, 5)  ));
		purchases.add( new Purchase("Rock", new BigDecimal(3.99), new GregorianCalendar(2010, Calendar.MAY, 4)  ));
		purchases.add( new Purchase("Blues", new BigDecimal(4.99), new GregorianCalendar(2010, Calendar.JUNE, 12)  ));
		purchases.add( new Purchase("Classical", new BigDecimal(12.99), new GregorianCalendar(2010, Calendar.JULY, 22)  ));
		purchases.add( new Purchase("Oldies", new BigDecimal(2.99), new GregorianCalendar(2010, Calendar.AUGUST, 4)  ));
		purchases.add( new Purchase("Rock", new BigDecimal(4.99), new GregorianCalendar(2010, Calendar.SEPTEMBER, 25)  ));
		purchases.add( new Purchase("Latin", new BigDecimal(4.99), new GregorianCalendar(2010, Calendar.OCTOBER, 1)  ));
		purchases.add( new Purchase("Eclectic", new BigDecimal(4.99), new GregorianCalendar(2010, Calendar.NOVEMBER, 28)  ));
		purchases.add( new Purchase("Eclectic", new BigDecimal(4.99), new GregorianCalendar(2010, Calendar.DECEMBER, 20)  ));
		
		regDate = new GregorianCalendar(2011,Calendar.JANUARY,1);
		visitDate = new GregorianCalendar(2011,Calendar.MARCH,1);
		return Account.newInstance("test", "test@if.io", regDate, visitDate, purchases );
	}

	
	
} //end class
