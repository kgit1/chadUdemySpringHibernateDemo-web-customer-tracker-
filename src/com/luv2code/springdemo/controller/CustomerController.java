package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

	// new code for ADD Customer button

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		Customer theCustomer = new Customer();
		theModel.addAttribute("customer", theCustomer);
		return "customer-form";
	}

	// new code for Save customer button
	// <form:form action="saveCustomer" modelAttribute="customer" method="POST">
	// so in mapping use name of action "saveCustomer"
	// in modelAttribute - modelAttribute

	@PostMapping("/saveCustomer")
	public String saveCustomer(
			@ModelAttribute("customer") Customer theCustomer) {
		// save the customer using our Service
		customerService.saveCustomer(theCustomer);
		return "redirect:/customer/list";
	}

	// new code for Update Customer button
	// <c:url var="updateLink" value="/customer/showFormForUpdate">
	// <c:param name="customerId" value="${tempCostumer.id}"/>
	// </c:url>
	// <!-- display the update link -->
	// <td><a href="${updateLink}">Update</a></td>

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId,
			Model theModel) {
		// get the customer from database
		Customer theCustomer = customerService.getCustomer(theId);

		// set customer as a model attribute to pre-populate the form
		theModel.addAttribute("customer", theCustomer);

		// send over to our form
		return "customer-form";
	}

	// new code for Delete Customer button
	// <!-- construct a "delete" link with customer id -->
	// <c:url var="delete" value="/customer/delete">
	// <c:param name="customerId" value="${tempCustomer.id}"/>
	// </c:url>
	// <a href="${delete}"
	// onclick="if(!(confirm('Are you sure you want to delete this customer?')))
	// return false"
	// >Delete</a>
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int theId){
		//delete customer
		customerService.deleteCustomer(theId);
		return "redirect:/customer/list";
	}

}
