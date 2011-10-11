package edu.gmu.mut;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Test;

import edu.gmu.mut.StoredDiscounts;
import edu.gmu.mut.StoredDiscountsFixture;


public class StoredDiscountsTest {
	
	@Test
	public void storedDiscountsCanBeCreated() {
		StoredDiscounts sd = StoredDiscountsFixture.getEmptyStoredDiscounts();
	}

	@Test
	public void canAddADiscountToStoredDiscounts() {
		StoredDiscounts sd = StoredDiscountsFixture.getIteration2Discounts();
		assertEquals("Number of discounts", 4, sd.getNumberOfDiscounts());
	}
	
	/*
	@Test
	public void getTotalAmountWithStartAndEndDatesReturnsTotalOfAllPurchasesForThatTimeFrame() {
		PurchaseHistory ph = PurchaseHistoryFixture.getPurchasesTotalling100OverPastYear();
		Calendar startDate = Calendar.getInstance();
		Calendar endDate = Calendar.getInstance();
		startDate.add(Calendar.YEAR, -1);
		assertEquals("Total Amount Purchased", new BigDecimal(100), ph.getTotalAmount(startDate, endDate));
		startDate.add(Calendar.YEAR, -1);
		assertEquals("Total Amount Purchased", new BigDecimal(150), ph.getTotalAmount(startDate, endDate));
	}
	
	@Test
	public void getPurchaseCountReturnsCountOfAllPurchases() {
		PurchaseHistory ph = PurchaseHistoryFixture.getPurchasesTotalling100OverPastYear();
		assertEquals("Purchase Count", 4, ph.getPurchaseCount());
	}
	
	@Test
	public void getPurchaseCountReturnsCountOfPurchasesOverSpecifiedTimeFrame() {
		PurchaseHistory ph = PurchaseHistoryFixture.getPurchasesTotalling100OverPastYear();
		Calendar startDate = Calendar.getInstance();
		Calendar endDate = Calendar.getInstance();
		startDate.add(Calendar.YEAR, -1);
		assertEquals("Purchase Count", 3, ph.getPurchaseCount(startDate, endDate));
		startDate.add(Calendar.YEAR, -1);
		endDate.add(Calendar.YEAR, -1);
		assertEquals("Purchase Count", 1, ph.getPurchaseCount(startDate, endDate));
	}
	*/
	
}
