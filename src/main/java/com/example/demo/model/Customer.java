package com.example.demo.model;

import java.util.HashMap;

public class Customer {

	/**
	 * phoneList: [string, string] - Phone Number, Status
	 */
	private HashMap<String, String> phoneList;
	private String customerName;
	private String customerId;

	/**
	 * Used for creating a Customer object with customer id, customer name and list of phone numbers with their activation status.
	 */
	public Customer(HashMap<String, String> phoneList, String customerName, String customerId) {
		this.phoneList = phoneList;
		this.customerName = customerName;
		this.customerId = customerId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public HashMap<String, String> getPhoneList() {
		return phoneList;
	}

	public void setPhoneList(HashMap<String, String> phoneList) {
		this.phoneList = phoneList;
	}

}
