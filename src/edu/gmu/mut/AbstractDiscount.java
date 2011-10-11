package edu.gmu.mut;

import java.util.Calendar;
import java.math.BigDecimal;

/**
 * Class Discount represents a timed discount.
 */

abstract class AbstractDiscount implements Discount {
	
	protected Calendar startDate;
	protected Calendar endDate;
	
	public AbstractDiscount() {
	}
	
	public Calendar getStartDate() {
		return startDate;
	}

	public Calendar getEndDate() {
		return endDate;
	}
	
	public abstract BigDecimal getDiscount(Account acct);

	public boolean isAdditionalDiscount() {
		return true;
	}

}
