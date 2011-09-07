package edu.gmu.mut.test;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Test;

import edu.gmu.mut.Purchase;


public class PurchaseTest {
	
	@Test
	public void purchaseCanBeCreated() {
		Purchase testPurchase = new Purchase("jazz", new BigDecimal( 1.99), new GregorianCalendar(2011,Calendar.SEPTEMBER,1));
		assertEquals("Genre", "jazz", testPurchase.getGenre());
	}
	
}
