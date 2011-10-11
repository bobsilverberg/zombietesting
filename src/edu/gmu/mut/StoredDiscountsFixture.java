package edu.gmu.mut;

import java.util.Calendar;
import java.util.GregorianCalendar;

import edu.gmu.mut.StoredDiscounts;

public class StoredDiscountsFixture {

	
	public static StoredDiscounts getEmptyStoredDiscounts(){
		StoredDiscounts sd = new StoredDiscounts();		
		return sd;
	}

	public static StoredDiscounts getIteration2Discounts(){
		StoredDiscounts sd = new StoredDiscounts();
		sd.add(new It2Discount1());
		sd.add(new It2Discount2());
		sd.add(new It2Discount3());
		sd.add(new It2Discount4());
		return sd;
	}

	/*
	public static PurchaseHistory getPurchasesTotalling100OverPastYear() {
		PurchaseHistory purchases = new PurchaseHistory();
		Calendar pd1 = Calendar.getInstance();
		pd1.add(Calendar.DATE, -1);
		Purchase p1 = new Purchase("jazz", new BigDecimal(25), pd1);
		purchases.add(p1);
		Calendar pd2 = Calendar.getInstance();
		pd2.add(Calendar.MONTH, -6);
		Purchase p2 = new Purchase("jazz", new BigDecimal(25), pd2);
		purchases.add(p2);
		Calendar pd3 = Calendar.getInstance();
		pd3.add(Calendar.MONTH, -10);
		Purchase p3 = new Purchase("jazz", new BigDecimal(50), pd3);
		purchases.add(p3);
		Calendar pd4 = Calendar.getInstance();
		pd4.add(Calendar.MONTH, -14);
		Purchase p4 = new Purchase("jazz", new BigDecimal(50), pd4);
		purchases.add(p4);
		return purchases;
	}
	*/
	
} //end class
