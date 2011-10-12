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
	
}
