package com.example.demo.dao;

import java.util.List;

import com.example.demo.exception.CustomExceptions;
import com.example.demo.model.Customer;

/**
 * TODO: Rename to IPhoneDAO
 * @author 61470
 *
 */
public interface IPhoneDao {

	public List<Customer> getAllPhoneNumbers() throws CustomExceptions;
	public Customer getPhoneNumbersByName(String customerName) throws CustomExceptions;
	public String updatePhoneNumberStatus(String PhoneNumber) throws CustomExceptions;
	
}
