package com.app.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

@Entity
@Table(name = "product")
public class Product extends BaseEntity {
	@Column(length = 20,name = "name")
	@NotEmpty(message = "name cannot be empty")
	String name;
	@Column(name = "image_url")
	@NotEmpty(message = "cannot be empty")
	String imageUrl;
	@Enumerated(value = EnumType.STRING)
	Category category;
	int quantity;
	@Positive
	double rate;
	String description;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	public Product() {
		super();
	}
	
	public Product(String name,
			String imageUrl, Category category, int quantity,
			double rate, String description) {
		super();
		this.name = name;
		this.imageUrl = imageUrl;
		this.category = category;
		this.quantity = quantity;
		this.rate = rate;
		this.description = description;
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", imageUrl=" + imageUrl + ", category=" + category + ", quantity=" + quantity
				+ ", rate=" + rate + ", description=" + description + ", user=" + user + "]";
	}
	
	
	
}
