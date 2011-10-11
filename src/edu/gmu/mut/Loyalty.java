package edu.gmu.mut;

import java.math.BigDecimal;
import java.util.Calendar;

import edu.gmu.mut.Account;
import edu.gmu.mut.Purchase;

public class Loyalty {
	
	private int VIPPurchaseCount;
	private int VIPAgeInDays;

	/**
	 * Instantiates a new loyalty object.
	 */
	public Loyalty(int VIPPurchaseCount, int VIPAgeInDays){
		this.VIPPurchaseCount = VIPPurchaseCount;
		this.VIPAgeInDays = VIPAgeInDays;
	}
	
	public BigDecimal getDiscount(Account acct, Calendar startDate, Calendar endDate) {
		BigDecimal discount = getDiscountIteration1(acct, startDate, endDate);
		if (acct.isVIP(VIPPurchaseCount, VIPAgeInDays)) {
			discount = discount.multiply(new BigDecimal(1.05));
		}
		return discount;
	}

	public BigDecimal getDiscountIteration1(Account acct, Calendar startDate, Calendar endDate) {
		Calendar today = Calendar.getInstance();
		Calendar oneYearAgo = Calendar.getInstance();
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

	private boolean isNewAccountWithNoPurchases(Account acct) {
		return isNewAccount(acct) && !acct.hasPurchases();
	}
	
	private boolean isOldAccountWithNoPurchasesAndRecentVisit(Account acct) {
		return !isNewAccount(acct) && !acct.hasPurchases() && isRecentVisitor(acct);
	}

	private boolean isNewAccount(Account acct) {
		return acct.isNewAccount(30);
	}

	private boolean isRecentVisitor(Account acct) {
		return acct.isRecentVisitor(7);
	}
	
}
