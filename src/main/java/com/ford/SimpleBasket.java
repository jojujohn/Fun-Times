package com.ford;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SimpleBasket implements Basket {
	
	@Override
	public String toString() {
		return "SimpleBasket [items=" + items + ", dateOfPurchase=" + dateOfPurchase + "]";
	}
	// Will store the items
	private HashMap<String,Item > items=new HashMap<String,Item>();

	// date of purchase
	private LocalDate dateOfPurchase;
	
	// list of promotions to be applied
	private List<Promotion> promotions=new ArrayList<Promotion>();

	@Override
	/**
	 * Setting the promotions
	 */
	public void addPromotions(List<Promotion> myPromotions) {
		// TODO Auto-generated method stub
		this.promotions=myPromotions;
		
	}

	@Override
	/**
	 *  Calculate the price
	 */
	public double calculatePrice() {
		double cost=0.0;
		for(Item item:items.values()) {
			//System.out.println(cost+item.getProduct().getCost());
			cost+=item.getQty()*item.getProduct().getCost();
			//System.out.println(cost+":"+item.getProduct().getCost()+":"+item.getQty());
		}
		// loop through the promotions and apply the discount
		for (Promotion proms : promotions) {
			cost-=proms.calculateDiscount(items, dateOfPurchase);
		}
		// round off to 2 decimals
		return Math.round(cost * 100D) / 100D;
	}

	@Override
	/**
	 * Add each item
	 */
	public void addItem(Product product, int qty) {
		this.items.put(product.getProductName(),new Item(product,qty));
		
	}

	public LocalDate getDateOfPurchase() {
		return dateOfPurchase;
	}

	public void setDateOfPurchase(LocalDate dateOfPurchase) {
		this.dateOfPurchase = dateOfPurchase;
	}

}
