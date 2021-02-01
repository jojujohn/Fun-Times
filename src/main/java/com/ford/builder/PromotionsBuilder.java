/**
 * 
 */
package com.ford.builder;

import java.time.LocalDate;

import com.ford.SimplePromotion;

/**
 * @author jopr2
 *
 */
public class PromotionsBuilder {
	
	/**
	 *  dumb method which needs to be fine tune to load the promotions
	 *   from DSL file such as drools
	 *   stateless
	 */
	
	public static void loadPromotions() {
		PromotionCache pCache=PromotionCache.getInstance();
		SimplePromotion sp1= new SimplePromotion();
		sp1.setDiscount(0.1);
		sp1.setMinQTy(1);
	//	sp1.setMinQTy(1);
		sp1.setFromDate(LocalDate.now().plusDays(3));
		sp1.setEndDate(LocalDate.now().plusDays(60));
		sp1.setMainProductName("apples");
		pCache.addPromotion(sp1);
		SimplePromotion sp2= new SimplePromotion();
		sp2.setDiscount(0);
		sp2.setMinQTy(2);
	//	sp1.setMinQTy(1);
		sp2.setFromDate(LocalDate.now().minusDays(1));
		sp2.setEndDate(LocalDate.now().plusDays(7));
		sp2.setMainProductName("soup");
		SimplePromotion sp3= new SimplePromotion();
		sp3.setDiscount(0.5);
		sp3.setMinQTy(1);
		sp3.setMaxQty(1);
	//	sp1.setMinQTy(1);
		//sp3.setFromDate(LocalDate.now().minusDays(1));
		//sp3.setEndDate(LocalDate.now().plusDays(7));
		sp3.setMainProductName("bread");
		sp2.addDependent(sp3);
		pCache.addPromotion(sp2);
	}

	

}
