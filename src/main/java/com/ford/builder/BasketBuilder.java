/**
 * 
 */
package com.ford.builder;

import java.time.LocalDate;

import com.ford.Basket;
import com.ford.Product;
import com.ford.SimpleBasket;

/**
 * @author jopr2
 *
 */
public class BasketBuilder {
	private final static String  QTYDELIMITER=":";
	private final static String  ITMDELIMITER=",";
	
	/**
	 * Build the basket 
	 * aka facade
	 * @param itemData
	 * @return
	 */
	public static Basket buildBasket(String itemData) {
		StockItems stItem=StockItems.getInstance();
		String [] itemToken=itemData.split(ITMDELIMITER);
		int dtDiff=Integer.valueOf(itemToken[itemToken.length-1].trim());
		
		SimpleBasket sb=new SimpleBasket();
		sb.setDateOfPurchase(dtDiff!=0?LocalDate.now().plusDays(dtDiff):LocalDate.now());
		for(int i=0;i<itemToken.length-1;i++) {
			String[] itm=itemToken[i].split(QTYDELIMITER);
			Product prod=stItem.getItem(itm[0]);
			sb.addItem(prod,Integer.valueOf(itm[1]).intValue());
						
		}
		PromotionCache pCache=PromotionCache.getInstance();
		sb.addPromotions(pCache.getPromotions());
		return sb;
	}

}
