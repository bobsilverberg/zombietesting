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
		sd.add(new JazzOrReggaeTimedDiscount());
		sd.add(new OneDay10PctTimedDiscount());
		sd.add(new OneDay25PctOverrideTimedDiscount());
		sd.add(new OneDayRockABillyTimedDiscount());
		return sd;
	}

} //end class
