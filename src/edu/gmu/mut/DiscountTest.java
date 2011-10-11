package edu.gmu.mut;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Test;

public class DiscountTest {
	
	@Test
	public void discountCanBeCreated() {
		Discount testDiscount = new TestDiscount();
		assertEquals("StartDate", new GregorianCalendar(2011,Calendar.SEPTEMBER,1), testDiscount.getStartDate());
	}
	
}
