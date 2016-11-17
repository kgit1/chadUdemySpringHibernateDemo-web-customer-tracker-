package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

//add controller annotation to help sring find controller
@Controller
// add requestMapping on class to group our links
@RequestMapping("/customer")
public class CustomerController {

	// autoinject dao to work with it
	// but now we have Service layer so no longer use
	// the CustomerDAO directly
	// @Autowired
	// CustomerDAO customerDAO;

	// now with service layer
	// inject service
	@Autowired
	CustomerService customerService;

	// add requestMapping to give link for our method
	// @RequestMapping("/list") - work for all HTTP request methods

	// usual choise
	// GET method - good for debaging, bookmarks,email url
	// limitation on data lenght near 1000 signs
	// @RequestMapping(path-"/list". method=RequestMethod.GET)
	// same as
	// GetMapping("/list")

	// choise for paswords and files
	// POST method - bad for bookmarks, no limits on data length,
	// also can send binary data(like when u need to save file)
	// @RequestMapping(path-"/list". method=RequestMethod.POST)
	// same as
	// PostMapping("/list")

	@GetMapping("/list")
	// add model in method to hold and translate data
	public String listCustomers(Model theModel) {

		// get customers from the dao
		// List<Customer> theCustomers = customerDAO.getCustomers();
		List<Customer> theCustomers = customerService.getCustomers();

		// add customers to the model
		theModel.addAttribute("customers", theCustomers);
		return "list-customers";
	}
}
