package edu.gmu.mut;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Test;


public class AccountTest {
	
	@Test
	public void hasPurchasesShouldReturnTrueIfAccountHasPurchases() {
		Account acct = AccountFixture.getNewAccountWithSmallPurchase();
		assertEquals("hasPurchases", true, acct.hasPurchases());
	}
	
	@Test
	public void hasPurchasesShouldReturnFalseIfAccountHasNoPurchases() {
		Account acct = AccountFixture.getNewAccount();
		assertEquals("hasPurchases", false, acct.hasPurchases());
	}
	
	@Test
	public void isNewAccountShouldReturnTrueIfAccountIsNew() {
		Account acct = AccountFixture.getNewAccount();
		assertEquals("isNewAccount", true, acct.isNewAccount(30));
	}
	
	@Test
	public void isNewAccountShouldReturnFalseIfAccountIsNotNew() {
		Account acct = AccountFixture.getNewAccount();
		assertEquals("isNewAccount", false, acct.isNewAccount(28));
	}
	
	@Test
	public void isRecentVisitorShouldReturnTrueIfCustomerVistedRecently() {
		Account acct = AccountFixture.getOldAccountNoPurchasesRecentVisitor();
		assertEquals("isRecentVisitor", true, acct.isRecentVisitor(2));
	}
	
	@Test
	public void isRecentVisitorShouldReturnFalseIfCustomerDidNotVistRecently() {
		Account acct = AccountFixture.getOldAccountNoPurchasesRecentVisitor();
		assertEquals("isRecentVisitor", false, acct.isRecentVisitor(0));
	}
	
	@Test
	public void isVIPShouldReturnTrueIfCustomerIsOverSpecifiedAgeAndHasEnoughPurchases() {
		Account acct = AccountFixture.getVIPAccount();
		assertEquals("isVIP", true, acct.isVIP(25,365));
	}
	
	@Test
	public void isVIPShouldReturnFalseIfCustomerIsOverSpecifiedAgeButDoesNotHaveEnoughPurchases() {
		Account acct = AccountFixture.getVIPAccount();
		assertEquals("isVIP", false, acct.isVIP(30,365));
	}
	
	@Test
	public void isVIPShouldReturnFalseIfCustomerIsLessThanSpecifiedAgedButDoesHaveEnoughPurchases() {
		Account acct = AccountFixture.getVIPAccount();
		assertEquals("isVIP", false, acct.isVIP(25,375));
	}
	
	
}
