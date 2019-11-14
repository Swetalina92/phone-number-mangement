package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.impl.PhoneDaoImpl;
import com.example.demo.exception.CustomExceptions;
import com.example.demo.model.Customer;
import com.example.demo.service.IPhoneService;

@Service
public class PhoneServiceImpl implements IPhoneService {

	private PhoneDaoImpl phoneDao;
	
	@Autowired
	public PhoneServiceImpl(PhoneDaoImpl daoImpl) {
		this.phoneDao = daoImpl;
	}
	
	/**
	 * @param None
	 * @return the list of all customers and their associated phone numbers and activation status.
	 * @throws CustomExceptions
	 */
	@Override
	public List<Customer> getAllPhoneNumbers() throws CustomExceptions {
		try {
			return phoneDao.getAllPhoneNumbers();			
		} catch (Exception e) {
			throw new CustomExceptions(e.getMessage());
		}
	}

	/**
	 * 
	 * @param Customer Object
	 * @return the list of phone numbers and their activation status associated with the given customer name.
	 * @throws CustomExceptions
	 */	
	@Override
	public Customer getPhoneNumbersByName(String customerName) throws CustomExceptions {
		try {
			return phoneDao.getPhoneNumbersByName(customerName);
			
		} catch (Exception e) {
			throw new CustomExceptions(e.getMessage());
		}
	}
	
	/**
	 * @param Phone Number
	 * @return the new activation status of the given phone number after updating the phone status.
	 * @throws CustomExceptions
	 */
	@Override
	public String activeOrDeactivatePhoneNumber(String PhoneNumber) throws CustomExceptions {
		try {
			return phoneDao.updatePhoneNumberStatus(PhoneNumber);
		} catch (Exception e) {
			throw new CustomExceptions(e.getMessage());
		}

	}

}
