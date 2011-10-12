package edu.gmu.mut;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Test;



public class LoyaltyTest {

	private Loyalty loyalty;
	private StoredDiscounts sd;
	
	@Before
    public void setUp() {
		sd = new StoredDiscounts();
		sd.add(new JazzOrReggaeTimedDiscount());
		sd.add(new OneDay10PctTimedDiscount());
		sd.add(new OneDay25PctOverrideTimedDiscount());
		sd.add(new OneDayRockABillyTimedDiscount());
		this.loyalty = new Loyalty(25,365,sd);
    }
	
	@Test
	public void newCustomerNoPurchasesShouldGet10PctDiscount() {
		Account acct = AccountFixture.getNewAccount();
		BigDecimal discount = loyalty.getDiscount(acct, Calendar.getInstance());
		assertEquals("Discount", new BigDecimal(10), discount);
	}
	
	@Test
	public void newCustomerWithSmallPurchasesShouldGet5PctDiscount() {
		Account acct = AccountFixture.getNewAccountWithSmallPurchase();
		BigDecimal discount = loyalty.getDiscount(acct, Calendar.getInstance());
		assertEquals("Discount", new BigDecimal(5), discount);
	}
	
	@Test
	public void oldCustomerWithNoPurchasesRecentVisitorShouldGet10PctDiscount() {
		Account acct = AccountFixture.getOldAccountNoPurchasesRecentVisitor();
		BigDecimal discount = loyalty.getDiscount(acct, Calendar.getInstance());
		assertEquals("Discount", new BigDecimal(10), discount);
	}
	
	@Test
	public void oldCustomerWithNoPurchasesNotRecentVisitorShouldGet5PctDiscount() {
		Account acct = AccountFixture.getOldAccountNoPurchasesNotRecentVisitor();
		BigDecimal discount = loyalty.getDiscount(acct, Calendar.getInstance());
		assertEquals("Discount", new BigDecimal(5), discount);
	}
	
	@Test
	public void oldCustomerWithSmallPurchasesRecentVisitorShouldGet5PctDiscount() {
		Account acct = AccountFixture.getOldAccountSmallPurchaseRecentVisitor();
		BigDecimal discount = loyalty.getDiscount(acct, Calendar.getInstance());
		assertEquals("Discount", new BigDecimal(5), discount);
	}
	
	@Test
	public void customerWhoSpentOver100InPastYearShouldGet20PctDiscount() {
		Account acct = AccountFixture.getOver100DollarInPastYearSpenderAccount();
		BigDecimal discount = loyalty.getDiscount(acct, Calendar.getInstance());
		assertEquals("Discount", new BigDecimal(20), discount);
	}
	
	@Test
	public void customerWhoSpentOver100InPreviousYearShouldGet5PctDiscount() {
		Account acct = AccountFixture.getOver100DollarInPreviousYearSpenderAccount();
		BigDecimal discount = loyalty.getDiscount(acct, Calendar.getInstance());
		assertEquals("Discount", new BigDecimal(5), discount);
	}
	
	@Test
	public void customerWhoSpentBetween50And100InPastYearShouldGet15PctDiscount() {
		Account acct = AccountFixture.get75DollarsInPastYearSpenderAccount();
		BigDecimal discount = loyalty.getDiscount(acct, Calendar.getInstance());
		assertEquals("Discount", new BigDecimal(15), discount);
	}
	
	@Test
	public void customerWhoSpentBetween50And100InPreviousYearShouldGet5PctDiscount() {
		Account acct = AccountFixture.get75DollarsInPreviousYearSpenderAccount();
		BigDecimal discount = loyalty.getDiscount(acct, Calendar.getInstance());
		assertEquals("Discount", new BigDecimal(5), discount);
	}
	
	@Test
	public void customerWhoSpentBetween25And50InPastYearShouldGet10PctDiscount() {
		Account acct = AccountFixture.get30DollarsInPastYearSpenderAccount();
		BigDecimal discount = loyalty.getDiscount(acct, Calendar.getInstance());
		assertEquals("Discount", new BigDecimal(10), discount);
	}
	
	@Test
	public void customerWhoSpentBetween25And50InPreviousYearShouldGet5PctDiscount() {
		Account acct = AccountFixture.get30DollarsInPreviousYearSpenderAccount();
		BigDecimal discount = loyalty.getDiscount(acct, Calendar.getInstance());
		assertEquals("Discount", new BigDecimal(5), discount);
	}
	
	@Test
	public void VIPcustomerWhoSpentBetween25And50InPreviousYearShouldGet10PctDiscount() {
		Account acct = AccountFixture.get30DollarsInPreviousYearSpenderAccount();
		this.loyalty = new Loyalty(1,5, sd);
		BigDecimal discount = loyalty.getDiscount(acct, Calendar.getInstance());
		assertEquals("Discount", new BigDecimal(10), discount);
	}
	
	@Test
	public void customerWhoQualifiesForTwoGenreTimedDiscountShouldGetTimedDiscountPlusLoyaltyDiscount() {
		Account acct = AccountFixture.getAccountWithPurchasesTotalling10OverTwoGenres();
		this.loyalty = new Loyalty(25,365, sd);
		BigDecimal discount = loyalty.getDiscount(acct, new GregorianCalendar(2011,Calendar.SEPTEMBER,16));
		assertEquals("Discount", new BigDecimal(10), discount);
	}
	
	@Test
	public void customerWhoQualifiesForTimedDiscountButIsOutsideDatesShouldGetOnlyLoyaltyDiscount() {
		Account acct = AccountFixture.getAccountWithPurchasesTotalling10OverTwoGenres();
		this.loyalty = new Loyalty(25,365, sd);
		BigDecimal discount = loyalty.getDiscount(acct, new GregorianCalendar(2011,Calendar.SEPTEMBER,25));
		assertEquals("Discount", new BigDecimal(5), discount);
	}
	
	@Test
	public void VIPcustomerWhoQualifiesForTimedDiscountShouldGetTimedDiscountPlusLoyaltyDiscountPlusVIPDiscount() {
		Account acct = AccountFixture.getAccountWithPurchasesTotalling10OverTwoGenres();
		this.loyalty = new Loyalty(1,1, sd);
		BigDecimal discount = loyalty.getDiscount(acct, new GregorianCalendar(2011,Calendar.SEPTEMBER,16));
		assertEquals("Discount", new BigDecimal(15), discount);
	}
	
	@Test
	public void customerWhoQualifiesForOneDay10PctTimedDiscountShouldGetTimedDiscountPlusLoyaltyDiscount() {
		Account acct = AccountFixture.getAccountWithPurchasesTotalling10OverTwoGenres();
		this.loyalty = new Loyalty(25,365, sd);
		BigDecimal discount = loyalty.getDiscount(acct, new GregorianCalendar(2011,Calendar.SEPTEMBER,23));
		assertEquals("Discount", new BigDecimal(15), discount);
	}
	
	@Test
	public void customerWhoQualifiesForOneDay10PctTimedDiscountButIsOutsideDateShouldGetOnlyLoyaltyDiscount() {
		Account acct = AccountFixture.getAccountWithPurchasesTotalling10OverTwoGenres();
		this.loyalty = new Loyalty(25,365, sd);
		BigDecimal discount = loyalty.getDiscount(acct, new GregorianCalendar(2011,Calendar.SEPTEMBER,25));
		assertEquals("Discount", new BigDecimal(5), discount);
	}
	
	@Test
	public void customerWhoQualifiesForOverrideTimedDiscountShouldGetOnlyTimedDiscount() {
		Account acct = AccountFixture.getAccountWithPurchasesTotalling10OverTwoGenres();
		this.loyalty = new Loyalty(25,365, sd);
		BigDecimal discount = loyalty.getDiscount(acct, new GregorianCalendar(2011,Calendar.OCTOBER,1));
		assertEquals("Discount", new BigDecimal(25), discount);
	}
	
	@Test
	public void VIPcustomerWhoQualifiesForOverrideTimedDiscountShouldGetTimedDiscountPlusVIPDiscount() {
		Account acct = AccountFixture.getAccountWithPurchasesTotalling10OverTwoGenres();
		this.loyalty = new Loyalty(1,1, sd);
		BigDecimal discount = loyalty.getDiscount(acct, new GregorianCalendar(2011,Calendar.OCTOBER,1));
		assertEquals("Discount", new BigDecimal(30), discount);
	}
	
	@Test
	public void customerWhoQualifiesForSingleGenreTimedDiscountShouldGetTimedDiscountPlusLoyaltyDiscount() {
		Account acct = AccountFixture.getAccountWithRockABillyPurchase();
		this.loyalty = new Loyalty(25,365, sd);
		BigDecimal discount = loyalty.getDiscount(acct, new GregorianCalendar(2011,Calendar.JANUARY,15));
		assertEquals("Discount", new BigDecimal(15), discount);
	}
}



