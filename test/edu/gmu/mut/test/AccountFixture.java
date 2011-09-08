package edu.gmu.mut.test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

import edu.gmu.mut.Account;
import edu.gmu.mut.Purchase;
import edu.gmu.mut.PurchaseHistory;
import edu.gmu.mut.test.PurchaseHistoryFixture;

public class AccountFixture {

	
	/**
	 * 
	 * Given a int representing a number of purchases, this generates a psuedo-random set 
	 * of purchases for an account.  Change the fixture class static members for more
	 * variation.  Note, that being random, this may not cover desired inputs for your tests.
	 * 
	 * @param numberOfPurchases An int representing the desired number of purchases to generate.
	 * 
	 * */
	public static Account generateRandomAccount(int numberOfPurchases) {
		Calendar regDate;
		Calendar visitDate;
		PurchaseHistory purchases = PurchaseHistoryFixture.generateRandomPurchaseHistory(numberOfPurchases) ;		
		regDate = new GregorianCalendar(2009,Calendar.JANUARY,1);
		visitDate = new GregorianCalendar(2011,Calendar.AUGUST,1);
		return Account.newInstance("test", "test@if.io", regDate, visitDate, purchases );
	}
	
	
	public static Account getNewAccount(){
		Calendar regDate = Calendar.getInstance();
		regDate.add(Calendar.DATE, -29);
		Calendar visitDate = Calendar.getInstance();
		PurchaseHistory purchases = new PurchaseHistory();
		return Account.newInstance("new test", "new_test@if.io", regDate, visitDate, purchases );
	}

	public static Account getOldAccountNoPurchasesRecentVisitor(){
		Calendar regDate = Calendar.getInstance();
		regDate.add(Calendar.DATE, -31);
		Calendar visitDate = Calendar.getInstance();
		visitDate.add(Calendar.DATE, -1);
		PurchaseHistory purchases = new PurchaseHistory();
		return Account.newInstance("new test", "new_test@if.io", regDate, visitDate, purchases );
	}
	
	public static Account getAccountWithOnePurchase(BigDecimal amount, Calendar purchaseDate){
		Calendar regDate = Calendar.getInstance();
		regDate.add(Calendar.YEAR, -1);
		Calendar visitDate = Calendar.getInstance();
		visitDate.add(Calendar.DATE, -29);
		PurchaseHistory purchases = new PurchaseHistory();
		Purchase p = new Purchase("Blues", amount, purchaseDate);
		purchases.add(p);
		return Account.newInstance("100$_bill", "100$_test@if.io", regDate, visitDate, purchases );
	}
	
	public static Account getNewAccountWithSmallPurchase() {
		Calendar regDate = Calendar.getInstance();
		regDate.add(Calendar.DATE, -29);
		Calendar visitDate = Calendar.getInstance();
		PurchaseHistory purchases = new PurchaseHistory();
		Purchase p = new Purchase("Blues", new BigDecimal(1.00), visitDate);
		purchases.add(p);
		return Account.newInstance("new test", "new_test@if.io", regDate, visitDate, purchases );
	}
	
	public static Account getOldAccountNoPurchasesNotRecentVisitor() {
		Calendar regDate = Calendar.getInstance();
		regDate.add(Calendar.DATE, -31);
		Calendar visitDate = Calendar.getInstance();
		visitDate.add(Calendar.DATE, -8);
		PurchaseHistory purchases = new PurchaseHistory();
		return Account.newInstance("new test", "new_test@if.io", regDate, visitDate, purchases );
	}
	
	public static Account getOldAccountSmallPurchaseRecentVisitor(){
		Calendar regDate = Calendar.getInstance();
		regDate.add(Calendar.DATE, -31);
		Calendar visitDate = Calendar.getInstance();
		visitDate.add(Calendar.DATE, -1);
		PurchaseHistory purchases = new PurchaseHistory();
		Purchase p = new Purchase("Blues", new BigDecimal(1.00), visitDate);
		purchases.add(p);
		return Account.newInstance("new test", "new_test@if.io", regDate, visitDate, purchases );
	}
	
	public static Account getOver100DollarInPastYearSpenderAccount(){
		Calendar purchaseDate = Calendar.getInstance();
		purchaseDate.add(Calendar.DATE, -29);
		return getAccountWithOnePurchase(new BigDecimal(100.01), purchaseDate);
	}
	
	public static Account getOver100DollarInPreviousYearSpenderAccount(){
		Calendar purchaseDate = Calendar.getInstance();
		purchaseDate.add(Calendar.YEAR, -1);
		return getAccountWithOnePurchase(new BigDecimal(100.01), purchaseDate);
	}
	
	public static Account get75DollarsInPastYearSpenderAccount() {
		Calendar purchaseDate = Calendar.getInstance();
		purchaseDate.add(Calendar.DATE, -29);
		return getAccountWithOnePurchase(new BigDecimal(75), purchaseDate);
	}
	
	public static Account get75DollarsInPreviousYearSpenderAccount() {
		Calendar purchaseDate = Calendar.getInstance();
		purchaseDate.add(Calendar.YEAR, -1);
		return getAccountWithOnePurchase(new BigDecimal(75), purchaseDate);
	}
	
	public static Account get30DollarsInPastYearSpenderAccount() {
		Calendar purchaseDate = Calendar.getInstance();
		purchaseDate.add(Calendar.DATE, -29);
		return getAccountWithOnePurchase(new BigDecimal(30), purchaseDate);
	}
	
	public static Account get30DollarsInPreviousYearSpenderAccount() {
		Calendar purchaseDate = Calendar.getInstance();
		purchaseDate.add(Calendar.YEAR, -1);
		return getAccountWithOnePurchase(new BigDecimal(30), purchaseDate);
	}
	
	public static Account getBasicAccount(){
		Calendar regDate;
		Calendar visitDate;
		PurchaseHistory purchases = new PurchaseHistory();
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
