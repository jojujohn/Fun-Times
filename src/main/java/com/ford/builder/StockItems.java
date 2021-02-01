/**
 * 
 */
package com.ford.builder;

import java.util.HashMap;

import com.ford.Product;

/**
 * @author jopr2
 *
 */
public class StockItems implements Cloneable {
	// singleton class
	private static StockItems stItems=new StockItems();
	
	// lookup method
	public  static StockItems getInstance() {
		return stItems;
	}
	/**
	 * should have used concurrent hashmap
	 */
	private HashMap <String, Product> products=new HashMap <String, Product>();
	
	protected void addItems(Product prod) {
		this.products.put(prod.getProductName(),prod);
	}
	
	/** 
	 * stop clonning the cache
	 */
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
		
	}
	/**
	 * checking if prod exists
	 * @param prod
	 * @return
	 */
	public boolean checkItemExists(Product prod) {
		return this.products.containsKey(prod.getProductName());
	}
	
	/** 
	 * should make the product mutuable
	 * @param prodName
	 * @return
	 */
	public Product getItem(String prodName) {
		return this.products.get(prodName);
	}

	@Override
	public String toString() {
		return "StockItems [products=" + products.values() + "]";
	}
	
	

}
