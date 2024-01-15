package com.app.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "orders")
public class Order extends BaseEntity {

	@Column(name = "total_amount")
	private String totalAmount;
	@Column(name = "full_name")	
	private String fullName;
	private String contact;
	private String pincode;
	private String state;
	private String city;
	private String line1;
	private String line2;
	@Column(name="payment_id")
	private String paymentId;
	@Column(name="order_id")
	private String orderId;
	private String status;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	public Order() {
	}

	
	/**
	 * @param totalAmount
	 * @param fullName
	 * @param contact
	 * @param pincode
	 * @param state
	 * @param city
	 * @param line1
	 * @param line2
	 * @param paymentId
	 * @param orderId
	 * @param user
	 */
	public Order(String totalAmount, String fullName, String contact, String pincode, String state, String city,
			String line1, String line2, String paymentId, String orderId, User user) {
		super();
		this.totalAmount = totalAmount;
		this.fullName = fullName;
		this.contact = contact;
		this.pincode = pincode;
		this.state = state;
		this.city = city;
		this.line1 = line1;
		this.line2 = line2;
		this.paymentId = paymentId;
		this.orderId = orderId;
		this.user = user;
	}


	public String getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getLine1() {
		return line1;
	}

	public void setLine1(String line1) {
		this.line1 = line1;
	}

	public String getLine2() {
		return line2;
	}

	public void setLine2(String line2) {
		this.line2 = line2;
	}

	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getPaymentId() {
		return paymentId;
	}


	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}


	public String getOrderId() {
		return orderId;
	}


	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	@Override
	public String toString() {
		return "Order [totalAmount=" + totalAmount + ", fullName=" + fullName + ", contact=" + contact + ", pincode="
				+ pincode + ", state=" + state + ", city=" + city + ", line1=" + line1 + ", line2=" + line2
				+ ", paymentId=" + paymentId + ", orderId=" + orderId + ", status=" + status + ", user=" + user + "]";
	}
	
	
}
