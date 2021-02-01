/**
 * 
 */
package com.ford;

import java.util.List;

/**
 * @author jopr2
 *
 */
public interface Basket {
	/**
	 * Construct the basket with items
	 * item data will be passed as comma separated and item qty delimited as #
	 * @param itemData
	 */
	public void addItem(Product product, int qty);
	
	/** 
	 * Apply/add the promotions
	 * @param myPromotions
	 */
	public void addPromotions(List<Promotion> myPromotions);
	
	/**
	 * determine the cost after applying the promotion
	 * @return
	 */
	public double calculatePrice();

}
