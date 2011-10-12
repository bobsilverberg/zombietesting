package edu.gmu.mut;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Test;



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
	
	@Test
	public void getTotalAmountForGenresReturnsTotalOfAllPurchasesForSpecifiedGenres() {
		PurchaseHistory ph = PurchaseHistoryFixture.getPurchasesTotalling10OverTwoGenres();
		String[] genres = {"Jazz", "Reggae"}; 
		assertEquals("Total Amount Purchased", new BigDecimal(10), ph.getTotalAmountForGenres(genres));
	}

}

