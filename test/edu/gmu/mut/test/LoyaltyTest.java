package edu.gmu.mut.test;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Test;

import edu.gmu.mut.Account;
import edu.gmu.mut.Loyalty;


public class LoyaltyTest {
	
	@Test
	public void customerWhoSpentOver100InPreviousYearShouldGet5PctDiscount() {
		Account acct = AccountFixture.get75DollarsInPastYearSpenderAccount();
		BigDecimal discount = Loyalty.getDiscount(acct, new GregorianCalendar(2011,Calendar.SEPTEMBER,1), new GregorianCalendar(2011,Calendar.SEPTEMBER,30));
		assertEquals("Discount", new BigDecimal(5), discount);
	}
	
	@Test
	public void newCustomerNoPurchasesShouldGet10PctDiscount() {
		Account acct = AccountFixture.getNewAccount();
		BigDecimal discount = Loyalty.getDiscount(acct, new GregorianCalendar(2011,Calendar.SEPTEMBER,1), new GregorianCalendar(2011,Calendar.SEPTEMBER,30));
		assertEquals("Discount", new BigDecimal(10), discount);
	}
	
	@Test
	public void newCustomerWithSmallPurchasesShouldGet5PctDiscount() {
		Account acct = AccountFixture.getNewAccountWithSmallPurchase();
		BigDecimal discount = Loyalty.getDiscount(acct, new GregorianCalendar(2011,Calendar.SEPTEMBER,1), new GregorianCalendar(2011,Calendar.SEPTEMBER,30));
		assertEquals("Discount", new BigDecimal(5), discount);
	}
	
	@Test
	public void oldCustomerWithNoPurchasesRecentVisitorShouldGet10PctDiscount() {
		Account acct = AccountFixture.getOldAccountNoPurchasesRecentVisitor();
		BigDecimal discount = Loyalty.getDiscount(acct, new GregorianCalendar(2011,Calendar.SEPTEMBER,1), new GregorianCalendar(2011,Calendar.SEPTEMBER,30));
		assertEquals("Discount", new BigDecimal(10), discount);
	}
	
	@Test
	public void oldCustomerWithSmallPurchasesRecentVisitorShouldGet5PctDiscount() {
		Account acct = AccountFixture.getOldAccountSmallPurchaseRecentVisitor();
		BigDecimal discount = Loyalty.getDiscount(acct, new GregorianCalendar(2011,Calendar.SEPTEMBER,1), new GregorianCalendar(2011,Calendar.SEPTEMBER,30));
		assertEquals("Discount", new BigDecimal(5), discount);
	}
	
	@Test
	public void customerWhoSpentOver100InPastYearShouldGet20PctDiscount() {
		Account acct = AccountFixture.getOver100DollarInPastYearSpenderAccount();
		BigDecimal discount = Loyalty.getDiscount(acct, new GregorianCalendar(2011,Calendar.SEPTEMBER,1), new GregorianCalendar(2011,Calendar.SEPTEMBER,30));
		assertEquals("Discount", new BigDecimal(20), discount);
	}
	
	@Test
	public void customerWhoSpentBetween50And100InPastYearShouldGet15PctDiscount() {
		Account acct = AccountFixture.get75DollarsInPastYearSpenderAccount();
		BigDecimal discount = Loyalty.getDiscount(acct, new GregorianCalendar(2011,Calendar.SEPTEMBER,1), new GregorianCalendar(2011,Calendar.SEPTEMBER,30));
		assertEquals("Discount", new BigDecimal(15), discount);
	}
	
	
}
