package com.ford;

public class Product {
	@Override
	public String toString() {
		return "Product [productName=" + productName + ", unit=" + unit + ", cost=" + cost + ", category=" + category
				+ "]";
	}
	private String productName;
	private String unit;
	private double cost;
	private String category;
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}

	
}
