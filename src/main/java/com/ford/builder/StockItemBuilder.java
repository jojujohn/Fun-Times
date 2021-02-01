/**
 * 
 */
package com.ford.builder;

import com.ford.Product;

/**
 * @author jopr2
 *
 */
public class StockItemBuilder {

	private final static String  PDELIMITER=":";
	
	/**
	 * Build the master inventory of stocks and loading them to 
	 * stock item cache
	 * @param itemData
	 * @return
	 */
	public static StockItems buildStockItem(String[] itemData) {
		StockItems stItem=StockItems.getInstance();
		
		for(String stl:itemData) {
			addProduct(stl,stItem);
		}
		return stItem;
		
	}
	
	/**
	 * helper method to load the product/item
	 * @param stl
	 * @param stItem2
	 */
	private static void addProduct(String stl, StockItems stItem2) {
		// TODO Auto-generated method stub
		String[] stToken=stl.split(PDELIMITER);
		Product p1=new Product();
		p1.setProductName(stToken[0].trim());
		p1.setUnit(stToken[1].trim());
		p1.setCost(Double.valueOf(stToken[2]));	
		stItem2.addItems(p1);
		
		
	}

}
