package com.app.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;


@Entity
@Table(name = "cart")
public class Cart extends BaseEntity {

	@Column(name="product_id")
	int productId;
	@Column(length = 20,name = "name")
	@NotEmpty(message = "name cannot be empty")
	String name;
	@Column(name = "image_url")
	@NotEmpty(message = "cannot be empty")
	String imageUrl;
	int quantity;
	@Positive
	double rate;
	
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	
	public Cart() {
		super();
	}


	

	/**
	 * @param productId
	 * @param name
	 * @param imageUrl
	 * @param quantity
	 * @param rate
	 * @param user
	 */
	public Cart(int productId, @NotEmpty(message = "name cannot be empty") String name,
			@NotEmpty(message = "cannot be empty") String imageUrl, int quantity, @Positive double rate, User user) {
		super();
		this.productId = productId;
		this.name = name;
		this.imageUrl = imageUrl;
		this.quantity = quantity;
		this.rate = rate;
		this.user = user;
	}




	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}




	public int getProductId() {
		return productId;
	}




	public void setProductId(int productId) {
		this.productId = productId;
	}




	@Override
	public String toString() {
		return "Cart [productId=" + productId + ", name=" + name + ", imageUrl=" + imageUrl + ", quantity=" + quantity
				+ ", rate=" + rate + ", user=" + user + "]";
	}
	
	
}
