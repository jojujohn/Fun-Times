/**
 * 
 */
package com.ford;

import com.ford.builder.BasketBuilder;
import com.ford.builder.PromotionsBuilder;
import com.ford.builder.StockItemBuilder;

/**
 * @author jopr2
 *
 */
public class MyTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] stList=new String[]{"soup:tin:0.65","bread:loaf:0.80",
                "milk:bottle:1.30", "apples:single:0.10"};

		StockItemBuilder.buildStockItem(stList);
		PromotionsBuilder.loadPromotions();	
		
		System.out.println();
		
		Basket sb=BasketBuilder.buildBasket(args[0] );
		System.out.println("cost is:"+sb.calculatePrice());
		

	}

}
