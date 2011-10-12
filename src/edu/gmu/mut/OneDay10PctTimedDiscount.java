package edu.gmu.mut;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.math.BigDecimal;

/**
 * Class Discount represents a timed discount.
 */

public class OneDay10PctTimedDiscount extends AbstractDiscount {
	
	public OneDay10PctTimedDiscount() {
		super();
		this.startDate = new GregorianCalendar(2011,Calendar.SEPTEMBER,22);
		this.endDate = new GregorianCalendar(2011,Calendar.SEPTEMBER,24);
	}
	
	public BigDecimal getDiscount(Account acct) {
		return new BigDecimal(10);
	}

}
