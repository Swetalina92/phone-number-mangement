package com.example.demo.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.dao.IPhoneDao;
import com.example.demo.exception.CustomExceptions;
import com.example.demo.model.Customer;

@Repository
public class PhoneDaoImpl implements IPhoneDao {

	/**
	 * Creating static data structure that is created the project runs.
	 */
	static List<Customer> customerList = new ArrayList<Customer>();
	static {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("55515678", "No");
		map.put("55345678", "Yes");
		map.put("55567678", "No");
		HashMap<String, String> map1 = new HashMap<String, String>();
		map1.put("55515677", "No");
		map1.put("55345670", "Yes");
		map1.put("55567675", "No");
		HashMap<String, String> map2 = new HashMap<String, String>();
		map2.put("53515678", "Yes");
		HashMap<String, String> map3 = new HashMap<String, String>();
		map3.put("53515678", "No");
		map3.put("55345078", "Yes");
		HashMap<String, String> map4 = new HashMap<String, String>();
		map4.put("55515678", "N0");
		map4.put("55345672", "Yes");

		Customer c = new Customer(map, "John", "1");
		Customer c1 = new Customer(map1, "Jessica", "2");
		Customer c2 = new Customer(map2, "Will", "3");
		Customer c3 = new Customer(map3, "Bella", "4");
		Customer c4 = new Customer(map4, "Rob", "5");

		customerList.add(c);
		customerList.add(c1);
		customerList.add(c2);
		customerList.add(c3);
		customerList.add(c4);

	}

	/**
	 * @param None
	 * @return the list of all customers and their associated phone numbers and
	 *         activation status.
	 * @throws CustomExceptions
	 */
	@Override
	public List<Customer> getAllPhoneNumbers() throws CustomExceptions {
		try {
			return customerList;
		} catch (Exception e) {
			throw new CustomExceptions(e.getMessage());
		}
	}

	/**
	 * 
	 * @param Customer Object
	 * @return the list of phone numbers and their activation status associated with
	 *         the given customer name.
	 * @throws CustomExceptions
	 */
	@Override
	public Customer getPhoneNumbersByName(String customerName) throws CustomExceptions {
		try {
			return customerList.parallelStream().filter(c -> c.getCustomerName().equalsIgnoreCase(customerName))
					.findFirst().orElse(null);
		} catch (Exception e) {
			throw new CustomExceptions(e.getMessage());

		}
	}
	/**
	 * @param newstatus: It has been declared outside the method as it won't get scope inside Lambda expression.
	 */
	 String newstatus;
	/**
	 * @param Phone Number
	 * @return the new activation status of the given phone number after updating
	 *         the phone status.
	 * @throws CustomExceptions
	 */
	@Override
	public String updatePhoneNumberStatus(String PhoneNumber) throws CustomExceptions {
		
		try {
			customerList.forEach(cust -> {
				String status = cust.getPhoneList().get(PhoneNumber);
				if (status != null) {
					if (status.equals("No")) {
						cust.getPhoneList().put(PhoneNumber, "Yes");
						newstatus = "Yes";
					}
					if (status.equals("Yes")) {
						cust.getPhoneList().put(PhoneNumber, "No");
						newstatus = "No";
					}
				}
			});

			return newstatus;

		} catch (Exception e) {
			throw new CustomExceptions(e.getMessage());
		}
	}
}
