package edu.gmu.mut;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.math.BigDecimal;

/**
 * Class Discount represents a timed discount.
 */

public class TestDiscount extends AbstractDiscount {
	
	public TestDiscount() {
		super();
		this.startDate = new GregorianCalendar(2011,Calendar.SEPTEMBER,1);
	}
	
	public BigDecimal getDiscount(Account acct) {
		BigDecimal discount = new BigDecimal(0);
		return discount;
	}

}
