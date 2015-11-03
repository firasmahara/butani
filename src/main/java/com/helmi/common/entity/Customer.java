package com.helmi.common.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity (name="customer")
public class Customer implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4456664198528190572L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CUSTOMER_ID")
	private Long customerId;
	

	@Column(name = "CUSTOMER_NAME")
	private String customerName;
	
	
	@Column(name = "CUSTOMER_CONTACT")
	private String customerContact;
	
	

	public Customer() {
	}

	public Customer(Long customerId, String customerName) {
		this.customerId = customerId;
		this.customerName = customerName;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerContact() {
		return customerContact;
	}

	public void setCustomerContact(String customerContact) {
		this.customerContact = customerContact;
	}
	
	

}
