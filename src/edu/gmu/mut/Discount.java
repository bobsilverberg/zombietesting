package edu.gmu.mut;

import java.util.Calendar;
import java.math.BigDecimal;

interface Discount {

	public abstract Calendar getStartDate();

	public abstract Calendar getEndDate();

	public abstract BigDecimal getDiscount(Account acct);

	public abstract boolean isAdditionalDiscount();
	
}