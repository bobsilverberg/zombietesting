package edu.gmu.mut;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;

import edu.gmu.mut.Account;
import edu.gmu.mut.Purchase;
import edu.gmu.mut.StoredDiscounts;

public class Loyalty {
	
	private int VIPPurchaseCount;
	private int VIPAgeInDays;
	private ArrayList discounts;
	private BigDecimal loyaltyDiscount;
	private BigDecimal timedDiscount;

	/**
	 * Instantiates a new loyalty object.
	 */
	public Loyalty(int VIPPurchaseCount, int VIPAgeInDays, StoredDiscounts sd){
		this.VIPPurchaseCount = VIPPurchaseCount;
		this.VIPAgeInDays = VIPAgeInDays;
		this.discounts = sd.getDiscounts();
	}
	
	public BigDecimal getDiscount(Account acct, Calendar today) {

		BigDecimal discount = new BigDecimal(0);
		
		loyaltyDiscount = getLoyaltyDiscount(acct);
		timedDiscount = getTimedDiscount(acct, today);
		
		discount = loyaltyDiscount.add(timedDiscount);
		
		if (acct.isVIP(VIPPurchaseCount, VIPAgeInDays)) {
			discount = discount.add(new BigDecimal(5));
		}
		return discount;
	}

	private BigDecimal getTimedDiscount(Account acct, Calendar today) {

		BigDecimal thisDiscount = new BigDecimal(0);
		
		for (int i = 0; i < discounts.size(); i++) {
			Discount d = (Discount) discounts.get(i);
			if (d.getStartDate().before(today) && d.getEndDate().after(today)) {
				thisDiscount = d.getDiscount(acct);
				if (! thisDiscount.equals(new BigDecimal(0))) {
					if (! d.isAdditionalDiscount()) {
						loyaltyDiscount = new BigDecimal(0);
					}
				}
				return thisDiscount;
			}
		}
		return thisDiscount;
	}

	private BigDecimal getLoyaltyDiscount(Account acct) {
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
