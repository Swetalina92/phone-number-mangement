package com.example.demo;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.example.demo.dao.impl.PhoneDaoImpl;
import com.example.demo.exception.CustomExceptions;
import com.example.demo.model.Customer;
import com.example.demo.service.impl.PhoneServiceImpl;

public class TestPhoneNumberManagement {

	private static Customer c;
	private static Customer c1;
	private static Customer c2;
	private static Customer c3;
	private static Customer c4;

	
	PhoneDaoImpl phoneDaoImpl = new PhoneDaoImpl();
	PhoneServiceImpl psi = new PhoneServiceImpl(phoneDaoImpl);
	
	static List<Customer> customerList = new ArrayList<Customer>();

	@Before
	public void setUpBeforeClass() throws Exception {

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

		c = new Customer(map, "John", "1");
		c1 = new Customer(map1, "Christina", "2");
		c2 = new Customer(map2, "Will", "3");
		c3 = new Customer(map3, "Bella", "4");
		c4 = new Customer(map4, "Rob", "5");

		customerList.add(c);
		customerList.add(c1);
		customerList.add(c2);
		customerList.add(c3);
		customerList.add(c4);

	}

	@Test
	public void testGetAllNumbers() throws CustomExceptions {

		assertEquals("John", psi.getAllPhoneNumbers().get(0).getCustomerName());

	}

	@Test
	public void testGetPhoneNumbersByName() throws CustomExceptions {

		assertEquals("John", psi.getPhoneNumbersByName("1").getCustomerName());

	}

	@Test
	public void testActivePhoneNumber() throws CustomExceptions {

		assertEquals("No", psi.activeOrDeactivatePhoneNumber("55345672"));

	}
	
	@Test
	public void testGetPhoneNumbersByNameException() throws CustomExceptions {

		assertNull(psi.activeOrDeactivatePhoneNumber("abcde"));

	}
	
	@Test
	public void testActivePhoneNumberException() throws CustomExceptions {

		
		assertNull(psi.activeOrDeactivatePhoneNumber("5534567876862"));

	}

}
