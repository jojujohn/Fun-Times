/**
 * 
 */
package com.ford.builder;

import java.util.ArrayList;
import java.util.List;

import com.ford.Promotion;

/**
 * @author jopr2
 *
 */
public class PromotionCache {
	
	// singleton object
	
	private static final PromotionCache pCache=new PromotionCache();
	
	// the whole list of promotions
	
	private List<Promotion> promotions=new ArrayList<Promotion>();
	
	private PromotionCache() {
		
	}
	// add promotion 
	protected void addPromotion(Promotion p) {
		this.promotions.add(p);
	}
	
	// get the whole list of promos
	public List<Promotion> getPromotions() {
		return promotions;
	}
	public static PromotionCache getInstance() {
		return pCache;
		
	}

}
