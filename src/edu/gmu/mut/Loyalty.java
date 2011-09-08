package edu.gmu.mut;

import java.math.BigDecimal;
import java.util.Calendar;

import edu.gmu.mut.Account;
import edu.gmu.mut.Purchase;

public class Loyalty {
	
	public static BigDecimal getDiscount(Account acct, Calendar startDate, Calendar endDate) {
		Calendar thirtyDaysAgo = Calendar.getInstance();
		Calendar oneWeekAgo = Calendar.getInstance();
		thirtyDaysAgo.add(Calendar.DATE, -30);
		oneWeekAgo.add(Calendar.DATE, -7);
		
		if (acct.getDateRegistered().after(thirtyDaysAgo) && acct.getPurchaseHistory().getNumberOfPurchases() == 0) {
			return new BigDecimal(10);
			
		}
		if (acct.getDateRegistered().before(thirtyDaysAgo) && acct.getLastVisitDate().after(oneWeekAgo) && acct.getPurchaseHistory().getNumberOfPurchases() == 0) {
			return new BigDecimal(10);
			
		}
		if (acct.getPurchaseHistory().getTotalAmount().compareTo(new BigDecimal(100)) == 1) {
			return new BigDecimal(20);
		}
		if (acct.getPurchaseHistory().getTotalAmount().compareTo(new BigDecimal(100)) == 1) {
			return new BigDecimal(20);
		}
		return new BigDecimal(5);
		
	}

}
