package edu.gmu.mut.test;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Test;

import edu.gmu.mut.Purchase;
import edu.gmu.mut.PurchaseHistory;
import edu.gmu.mut.test.PurchaseHistoryFixture;


public class PurchaseHistoryTest {
	
	@Test
	public void purchaseHistoryCanBeCreated() {
		PurchaseHistory ph = PurchaseHistoryFixture.getEmptyPurchaseHistory();
		assertEquals("Number of purchases", 0, ph.getNumberOfPurchases());
	}
	
	@Test
	public void canAddAPurchaseToPurchaseHistory() {
		PurchaseHistory ph = PurchaseHistoryFixture.generateRandomPurchaseHistory(2);
		assertEquals("Number of purchases", 2, ph.getNumberOfPurchases());
	}
	
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
	
}
