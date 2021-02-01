package com.ford;
import java.time.LocalDate;
import java.util.*;
public interface Promotion 
{
	/**
	 * Determine the discount
	 * @param itmMap
	 * @param purchaseDate
	 * @return
	 */
	public double  calculateDiscount(Map<String,Item > itmMap,LocalDate purchaseDate) ;
	

}
