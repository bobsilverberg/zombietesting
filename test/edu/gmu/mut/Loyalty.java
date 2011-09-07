package edu.gmu.mut;

import java.math.BigDecimal;
import java.util.Calendar;

import edu.gmu.mut.Account;
import edu.gmu.mut.Purchase;

public class Loyalty {
	
	public static BigDecimal getDiscount(Account acct, Calendar startDate, Calendar endDate) {
		return new BigDecimal(10);
		
	}

}
