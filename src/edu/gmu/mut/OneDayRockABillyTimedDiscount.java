package edu.gmu.mut;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.math.BigDecimal;

/**
 * Class Discount represents a timed discount.
 */

public class OneDayRockABillyTimedDiscount extends AbstractDiscount {
	
	public OneDayRockABillyTimedDiscount() {
		super();
		this.startDate = new GregorianCalendar(2011,Calendar.JANUARY,14);
		this.endDate = new GregorianCalendar(2011,Calendar.JANUARY,16);
	}
	
	public BigDecimal getDiscount(Account acct) {
		BigDecimal discount = new BigDecimal(0);
		String[] genres = {"Rock-A-Billy"};
		if (acct.getTotalAmountForGenres(genres).compareTo(new BigDecimal(0)) == 1) {
			discount = new BigDecimal(10);
		}
		return discount;
	}

}
