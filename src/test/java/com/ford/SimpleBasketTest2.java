package com.ford;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.ford.builder.BasketBuilder;
import com.ford.builder.PromotionsBuilder;
import com.ford.builder.StockItemBuilder;

public class SimpleBasketTest2 {
	static {
		String[] stList=new String[]{"soup:tin:0.65","bread:loaf:0.80",
                "milk:bottle:1.30", "apples:single:0.10"};

		StockItemBuilder.buildStockItem(stList);
		PromotionsBuilder.loadPromotions();	
	}

	@Before
	public void setUp() throws Exception {
	
		
	}

	@Test
	public final void testCalculatePrice1() {
	//	System.out.println(StockItems.getInstance().toString());
	
		Basket sb=BasketBuilder.buildBasket("soup:3,bread:2,0" );
		//assertEquals
		assertEquals(3.15, sb.calculatePrice(),0);
	}
	
	@Test
	public final void testCalculatePrice2() {
		Basket sb=BasketBuilder.buildBasket("apples:6,milk:1,0" );
	//	System.out.println(" sb is"+sb);
		//assertEquals
		assertEquals(1.90, sb.calculatePrice(),0);
	}
	@Test
	public final void testCalculatePrice3() {
	
		Basket sb=BasketBuilder.buildBasket("apples:6,milk:1,5" );
	//	System.out.println(" sb is"+sb);
		//assertEquals
		assertEquals(1.84, sb.calculatePrice(),0);
	}
	
	@Test
	public final void testCalculatePrice4() {
		Basket sb=BasketBuilder.buildBasket("apples:3,soup:2,bread:1,5" );
		//System.out.println(" sb is"+sb);
		//assertEquals
		assertEquals(1.97, sb.calculatePrice(),0);
	}


}
