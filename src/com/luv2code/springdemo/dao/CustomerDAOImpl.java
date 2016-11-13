package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.entity.Customer;

//add repository to help spring componentscan to find this repository
//and also to handle error translation for us
@Repository
public class CustomerDAOImpl implements CustomerDAO {

	// need to inject session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<Customer> getCustomers() {

		// get the current session
		Session session = sessionFactory.getCurrentSession();

		// create query
		Query<Customer> theQuery = session.createQuery("from Customer",
				Customer.class);

		// execute query and the result
		List<Customer> customers = theQuery.getResultList();

		// return the result
		return customers;
	}

}
