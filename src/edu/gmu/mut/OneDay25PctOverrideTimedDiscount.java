package edu.gmu.mut;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.math.BigDecimal;

/**
 * Class Discount represents a timed discount.
 */

public class OneDay25PctOverrideTimedDiscount extends AbstractDiscount {
	
	public OneDay25PctOverrideTimedDiscount() {
		super();
		this.startDate = new GregorianCalendar(2011,Calendar.SEPTEMBER,30);
		this.endDate = new GregorianCalendar(2011,Calendar.OCTOBER,2);
	}
	
	public BigDecimal getDiscount(Account acct) {
		return new BigDecimal(25);
	}

	public boolean isAdditionalDiscount() {
		return false;
	}

}
