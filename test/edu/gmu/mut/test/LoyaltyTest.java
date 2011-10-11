package edu.gmu.mut.test;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Test;

import edu.gmu.mut.Account;
import edu.gmu.mut.Loyalty;


public class LoyaltyTest {

	private Loyalty loyalty;
	
	@Before
    public void setUp() {
		this.loyalty = new Loyalty(25,365);
    }
	
	@Test
	public void newCustomerNoPurchasesShouldGet10PctDiscount() {
		Account acct = AccountFixture.getNewAccount();
		BigDecimal discount = loyalty.getDiscount(acct, new GregorianCalendar(2011,Calendar.SEPTEMBER,1), new GregorianCalendar(2011,Calendar.SEPTEMBER,30));
		assertEquals("Discount", new BigDecimal(10), discount);
	}
	
	@Test
	public void newCustomerWithSmallPurchasesShouldGet5PctDiscount() {
		Account acct = AccountFixture.getNewAccountWithSmallPurchase();
		BigDecimal discount = loyalty.getDiscount(acct, new GregorianCalendar(2011,Calendar.SEPTEMBER,1), new GregorianCalendar(2011,Calendar.SEPTEMBER,30));
		assertEquals("Discount", new BigDecimal(5), discount);
	}
	
	@Test
	public void oldCustomerWithNoPurchasesRecentVisitorShouldGet10PctDiscount() {
		Account acct = AccountFixture.getOldAccountNoPurchasesRecentVisitor();
		BigDecimal discount = loyalty.getDiscount(acct, new GregorianCalendar(2011,Calendar.SEPTEMBER,1), new GregorianCalendar(2011,Calendar.SEPTEMBER,30));
		assertEquals("Discount", new BigDecimal(10), discount);
	}
	
	@Test
	public void oldCustomerWithNoPurchasesNotRecentVisitorShouldGet5PctDiscount() {
		Account acct = AccountFixture.getOldAccountNoPurchasesNotRecentVisitor();
		BigDecimal discount = loyalty.getDiscount(acct, new GregorianCalendar(2011,Calendar.SEPTEMBER,1), new GregorianCalendar(2011,Calendar.SEPTEMBER,30));
		assertEquals("Discount", new BigDecimal(5), discount);
	}
	
	@Test
	public void oldCustomerWithSmallPurchasesRecentVisitorShouldGet5PctDiscount() {
		Account acct = AccountFixture.getOldAccountSmallPurchaseRecentVisitor();
		BigDecimal discount = loyalty.getDiscount(acct, new GregorianCalendar(2011,Calendar.SEPTEMBER,1), new GregorianCalendar(2011,Calendar.SEPTEMBER,30));
		assertEquals("Discount", new BigDecimal(5), discount);
	}
	
	@Test
	public void customerWhoSpentOver100InPastYearShouldGet20PctDiscount() {
		Account acct = AccountFixture.getOver100DollarInPastYearSpenderAccount();
		BigDecimal discount = loyalty.getDiscount(acct, new GregorianCalendar(2011,Calendar.SEPTEMBER,1), new GregorianCalendar(2011,Calendar.SEPTEMBER,30));
		assertEquals("Discount", new BigDecimal(20), discount);
	}
	
	@Test
	public void customerWhoSpentOver100InPreviousYearShouldGet5PctDiscount() {
		Account acct = AccountFixture.getOver100DollarInPreviousYearSpenderAccount();
		BigDecimal discount = loyalty.getDiscount(acct, new GregorianCalendar(2011,Calendar.SEPTEMBER,1), new GregorianCalendar(2011,Calendar.SEPTEMBER,30));
		assertEquals("Discount", new BigDecimal(5), discount);
	}
	
	@Test
	public void customerWhoSpentBetween50And100InPastYearShouldGet15PctDiscount() {
		Account acct = AccountFixture.get75DollarsInPastYearSpenderAccount();
		BigDecimal discount = loyalty.getDiscount(acct, new GregorianCalendar(2011,Calendar.SEPTEMBER,1), new GregorianCalendar(2011,Calendar.SEPTEMBER,30));
		assertEquals("Discount", new BigDecimal(15), discount);
	}
	
	@Test
	public void customerWhoSpentBetween50And100InPreviousYearShouldGet5PctDiscount() {
		Account acct = AccountFixture.get75DollarsInPreviousYearSpenderAccount();
		BigDecimal discount = loyalty.getDiscount(acct, new GregorianCalendar(2011,Calendar.SEPTEMBER,1), new GregorianCalendar(2011,Calendar.SEPTEMBER,30));
		assertEquals("Discount", new BigDecimal(5), discount);
	}
	
	@Test
	public void customerWhoSpentBetween25And50InPastYearShouldGet10PctDiscount() {
		Account acct = AccountFixture.get30DollarsInPastYearSpenderAccount();
		BigDecimal discount = loyalty.getDiscount(acct, new GregorianCalendar(2011,Calendar.SEPTEMBER,1), new GregorianCalendar(2011,Calendar.SEPTEMBER,30));
		assertEquals("Discount", new BigDecimal(10), discount);
	}
	
	@Test
	public void customerWhoSpentBetween25And50InPreviousYearShouldGet5PctDiscount() {
		Account acct = AccountFixture.get30DollarsInPreviousYearSpenderAccount();
		BigDecimal discount = loyalty.getDiscount(acct, new GregorianCalendar(2011,Calendar.SEPTEMBER,1), new GregorianCalendar(2011,Calendar.SEPTEMBER,30));
		assertEquals("Discount", new BigDecimal(5), discount);
	}
	
	@Test
	public void VIPcustomerWhoSpentBetween25And50InPreviousYearShouldGet5PctDiscount() {
		Account acct = AccountFixture.get30DollarsInPreviousYearSpenderAccount();
		this.loyalty = new Loyalty(1,5);
		BigDecimal discount = loyalty.getDiscount(acct, new GregorianCalendar(2011,Calendar.SEPTEMBER,1), new GregorianCalendar(2011,Calendar.SEPTEMBER,30));
		assertEquals("Discount", new BigDecimal(5).multiply(new BigDecimal(1.05)), discount);
	}
	
	
}

