/**
 * 
 */
package com.ford;

/**
 * @author jopr2
 *
 */
public class Item {
	
	private Product product;
	@Override
	public String toString() {
		return "Item [product=" + product + ", qty=" + qty + "]";
	}
	int qty;
	public Item(Product product,int qty) {
		this.product=product;
		this.qty=qty;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	

}
