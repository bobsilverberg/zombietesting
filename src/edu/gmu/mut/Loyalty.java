package edu.gmu.mut;

import java.math.BigDecimal;
import java.util.Calendar;

import edu.gmu.mut.Account;
import edu.gmu.mut.Purchase;

public class Loyalty {
	
	public static BigDecimal getDiscount(Account acct, Calendar startDate, Calendar endDate) {
		Calendar thirtyDaysAgo = Calendar.getInstance();
		Calendar oneWeekAgo = Calendar.getInstance();
		Calendar today = Calendar.getInstance();
		Calendar oneYearAgo = Calendar.getInstance();
		thirtyDaysAgo.add(Calendar.DATE, -30);
		oneWeekAgo.add(Calendar.DATE, -7);
		oneYearAgo.add(Calendar.YEAR, -1);
		
		if (isNewAccountWithNoPurchases(acct)) {
			return new BigDecimal(10);
			
		}
		if (isOldAccountWithNoPurchasesAndRecentVisit(acct)) {
			return new BigDecimal(10);
			
		}
		if (acct.compareTotalPurchaseAmount(oneYearAgo, today, new BigDecimal(100)) == 1) {
			return new BigDecimal(20);
		}
		if (acct.compareTotalPurchaseAmount(oneYearAgo, today, new BigDecimal(50)) == 1 && acct.compareTotalPurchaseAmount(oneYearAgo, today, new BigDecimal(100)) == -1) {
			return new BigDecimal(15);
		}
		if (acct.compareTotalPurchaseAmount(oneYearAgo, today, new BigDecimal(25)) == 1 && acct.compareTotalPurchaseAmount(oneYearAgo, today, new BigDecimal(50)) == -1) {
			return new BigDecimal(10);
		}
		return new BigDecimal(5);
		
	}

	private static boolean isNewAccountWithNoPurchases(Account acct) {
		return isNewAccount(acct) && !acct.hasPurchases();
	}
	
	private static boolean isOldAccountWithNoPurchasesAndRecentVisit(Account acct) {
		return !isNewAccount(acct) && !acct.hasPurchases() && isRecentVisitor(acct);
	}

	private static boolean isNewAccount(Account acct) {
		return acct.isNewAccount(30);
	}

	private static boolean isRecentVisitor(Account acct) {
		return acct.isRecentVisitor(7);
	}
	
}
