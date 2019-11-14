package com.example.demo.service;

import java.util.List;

import com.example.demo.exception.CustomExceptions;
import com.example.demo.model.Customer;

public interface IPhoneService {
	
	/**
	 * Using inheritance. These methods are implemented in ServiceImplClass.
	 */
	public List<Customer> getAllPhoneNumbers() throws CustomExceptions;
	public Customer getPhoneNumbersByName(String customerName) throws CustomExceptions;
	public String activeOrDeactivatePhoneNumber(String PhoneNumber) throws CustomExceptions;

}
