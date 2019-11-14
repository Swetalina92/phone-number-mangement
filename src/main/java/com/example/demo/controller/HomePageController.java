package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.exception.CustomExceptions;
import com.example.demo.model.Customer;
import com.example.demo.service.impl.PhoneServiceImpl;

@Controller
public class HomePageController {

	@Autowired
	private PhoneServiceImpl phoneService;

	/**
	 * @param None
	 * @return the home page.
	 * @throws CustomExceptions
	 */
	@RequestMapping("/")
	public String loadHomePage() {
		return "home";
	}

	/**
	 * @param None
	 * @return the next page asking for the customer name to fetch the related
	 *         details.
	 * @throws CustomExceptions
	 */
	@RequestMapping("/getnumberdetailsbyname")
	public String getCustomerDetails() throws CustomExceptions {
		try {
			return "getnumberdetailsbyname";
		} catch (Exception e) {
			throw new CustomExceptions(e.getMessage());
		}
	}

	/**
	 * @param None
	 * @return the next page asking for the number to be updated.
	 * @throws CustomExceptions
	 */
	@RequestMapping("/updatenumberstate")
	public String updateStatus() throws CustomExceptions {
		try {
			return "updatenumberstate";
		} catch (Exception e) {
			throw new CustomExceptions(e.getMessage());
		}
	}

	/**
	 * @param None
	 * @return the list of all customers and their associated phone numbers and
	 *         activation status.
	 * @throws CustomExceptions
	 */
	@RequestMapping("/getallnumbers")
	public ModelAndView loadAllNumbers() throws CustomExceptions {
		try {
			ModelAndView mv = new ModelAndView();
			List<Customer> list = phoneService.getAllPhoneNumbers();
			mv.addObject("phonelist", list);
			mv.setViewName("allcustomerphonenumbers");
			return mv;
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
	@RequestMapping("/getnumbersbyname")
	public ModelAndView getNumbersByName(@ModelAttribute Customer cust) throws CustomExceptions {
		try {
			ModelAndView mv = new ModelAndView();
			Customer customerDetails = phoneService.getPhoneNumbersByName(cust.getCustomerName());
			if (customerDetails == null) {
				mv.addObject("error", "An error has occurred: Data not found!");
				mv.setViewName("getnumberdetailsbyname");
				return mv;
			}
			mv.addObject("customerdeatils", customerDetails);
			mv.setViewName("searchedcustomerdetails");
			return mv;
		} catch (Exception e) {
			throw new CustomExceptions(e.getMessage());
		}
	}

	/**
	 * @param Phone Number
	 * @return the new activation status of the given phone number after updating
	 *         the phone status.
	 * @throws CustomExceptions
	 */
	@RequestMapping("/updatenumber")
	public ModelAndView getNumbersByName(@RequestParam("phonenumber") String phonenumber) throws CustomExceptions {
		try {
			String newStatus = null;
			String phoneNumberState = null;
			phoneNumberState = phoneService.activeOrDeactivatePhoneNumber(phonenumber);
			ModelAndView mv = new ModelAndView();
			if (phoneNumberState == null) {
				mv.addObject("error", "An error has occurred: Data not found!");
				mv.setViewName("updatenumberstate");
				return mv;
			} else {
				if (phoneNumberState.equalsIgnoreCase("Yes")) {
					newStatus = "activated";
				} else {
					newStatus = "deactivated";
				}
				mv.addObject("phonenumber", phonenumber);
				mv.addObject("status", newStatus);
				mv.setViewName("success");
				return mv;
			}
		} catch (Exception e) {
			throw new CustomExceptions(e.getMessage());
		}
	}

}
