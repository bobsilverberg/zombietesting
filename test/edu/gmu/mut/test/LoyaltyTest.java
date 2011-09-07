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
	public void newCustomerShouldGet10PctDiscount() {
		Account acct = AccountFixture.getNewAccount();
		BigDecimal discount = Loyalty.getDiscount(acct, new GregorianCalendar(2011,Calendar.SEPTEMBER,1), new GregorianCalendar(2011,Calendar.SEPTEMBER,30));
		assertEquals("Discount", new BigDecimal(10), discount);
	}
	
}
