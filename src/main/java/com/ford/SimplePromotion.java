/**
 * 
 */
package com.ford;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

/**
 * @author jopr2
 *
 */
public class SimplePromotion  implements Promotion{
	
	private String mainProductName;
	
	private LocalDate fromDate;
	
	private LocalDate endDate;
	
	private double discount;
	
	private int minQTy;
	
	private int maxQty;
	
	
	
	
	@Override
	public String toString() {
		return "SimplePromotion [mainProductName=" + mainProductName + ", fromDate=" + fromDate + ", endDate=" + endDate
				+ ", discount=" + discount + ", minQTy=" + minQTy + ", maxQty=" + maxQty + ", dependent=" + dependent
				+ "]";
	}

	private List<SimplePromotion> dependent=new ArrayList<SimplePromotion>();
	
	
	
	
	public void addDependent(SimplePromotion sp) {
		this.dependent.add(sp);
	}

	public String getMainProductName() {
		return mainProductName;
	}

	public void setMainProductName(String mainProductName) {
		this.mainProductName = mainProductName;
	}

	public LocalDate getFromDate() {
		return fromDate;
	}

	public void setFromDate(LocalDate fromDate) {
		this.fromDate = fromDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public int getMinQTy() {
		return minQTy;
	}

	public void setMinQTy(int minQTy) {
		this.minQTy = minQTy;
	}

	public int getMaxQty() {
		return maxQty;
	}

	public void setMaxQty(int maxQty) {
		this.maxQty = maxQty;
	}

	@Override
	/**
	 *  Apply discount for the main product name and the apply on the child nodes
	 */
	public double calculateDiscount(Map<String, Item> itmMap,LocalDate purchaseDate) {
	
		double disnt=0;
		
		
		Predicate<LocalDate> isWithinRange = (pDate) -> pDate.isAfter(this.fromDate.minusDays(1)) && 
											 pDate.isBefore(this.endDate.plusDays(1));
		Predicate<String> isPresent = (name) -> itmMap.containsKey(name);
		
		
		
		Predicate<Item> aboveMin = (item) -> item.getQty()>=minQTy;
		
		if(isWithinRange.test(purchaseDate) && isPresent.test(mainProductName) && 
				aboveMin.test(itmMap.get(mainProductName))) {
			//System.out.println("inside calculateDiscount");
			Item itm=itmMap.get(mainProductName);
			disnt+=itm.getQty()*itm.getProduct().getCost()*discount;
			disnt+=nestedDiscount(dependent,itmMap);
			
		}
		
		return disnt;

		
		
		
	}
	/**
	 * Find dscount on the nested items
	 * @param nestedDependent
	 * @param itmMap
	 * @return
	 */
	private double nestedDiscount(List<SimplePromotion> nestedDependent, Map<String, Item> itmMap) {
		double disnt=0;
		//System.out.println("inside  nestedDiscount calculateDiscount");
		Predicate<String> isPresent = (name) -> itmMap.containsKey(name);
		Predicate<Item> aboveMin = (item) -> item.getQty()>=1;
		for (SimplePromotion simplePromotion : nestedDependent) {
			if(isPresent.test(simplePromotion.getMainProductName()) && 
					aboveMin.test(itmMap.get(simplePromotion.getMainProductName()))) {
				
				Item itm=itmMap.get(simplePromotion.getMainProductName());
				// Need to consider the promotion max qty
				disnt+=simplePromotion.getMaxQty()*itm.getProduct().getCost()*simplePromotion.getDiscount();
				
			}
		}
		
		return disnt;
	}
	
	
	

}
