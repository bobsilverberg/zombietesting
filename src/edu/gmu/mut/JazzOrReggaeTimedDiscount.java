package edu.gmu.mut;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.math.BigDecimal;

/**
 * Class Discount represents a timed discount.
 */

public class JazzOrReggaeTimedDiscount extends AbstractDiscount {
	
	public JazzOrReggaeTimedDiscount() {
		super();
		this.startDate = new GregorianCalendar(2011,Calendar.SEPTEMBER,15);
		this.endDate = new GregorianCalendar(2011,Calendar.SEPTEMBER,21);
	}
	
	public BigDecimal getDiscount(Account acct) {
		BigDecimal discount = new BigDecimal(0);
		String[] genres = {"Jazz","Reggae"};
		if (acct.getTotalAmountForGenres(genres).compareTo(new BigDecimal(10)) >= 0) {
			discount = new BigDecimal(5);
		}
		return discount;
	}

}
