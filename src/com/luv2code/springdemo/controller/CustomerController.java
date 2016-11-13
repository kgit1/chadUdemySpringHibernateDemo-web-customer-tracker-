package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;

//add controller annotation to help sring find controller
@Controller
//add requestMapping on class to group our links
@RequestMapping("/customer")
public class CustomerController {
	
	//autoinject dao to work with it
	@Autowired
	CustomerDAO customerDAO;

	//add requestMapping to give link for our method
	@RequestMapping("/list")
	//add model in method to hold and translate data
	public String listCustomers(Model theModel) {

		// get customers from the dao
		List<Customer> theCustomers = customerDAO.getCustomers();

		// add customers to the model
		theModel.addAttribute("customers", theCustomers);
		customerDAO.getCustomers();
		return "list-customers";
	}
}
