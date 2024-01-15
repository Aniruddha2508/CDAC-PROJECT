package com.app.dto;

public class CartDTO {
	private int productId;
	private int quantity;
	/**
	 * 
	 */
	public CartDTO() {
		super();
	}
	/**
	 * @param productId
	 * @param quantity
	 */
	public CartDTO(int productId, int quantity) {
		super();
		this.productId = productId;
		this.quantity = quantity;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "CartDTO [productId=" + productId + ", quantity=" + quantity + "]";
	}

}
