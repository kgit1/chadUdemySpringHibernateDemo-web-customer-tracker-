package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.query.criteria.internal.expression.SearchedCaseExpression;
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
	// now method called from service layer,
	// so transactional works from there
	// @Transactional
	public List<Customer> getCustomers() {

		// get the current session
		Session session = sessionFactory.getCurrentSession();

		// create query
		// Query<Customer> theQuery = session.createQuery("from Customer",
		// Customer.class);
		Query<Customer> theQuery = session
				.createQuery("from Customer order by lastName", Customer.class);

		// execute query and the result
		List<Customer> customers = theQuery.getResultList();

		// return the result
		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// save the customer
		// curentSession.save(theCustomer);

		// save or update customer
		currentSession.saveOrUpdate(theCustomer);
	}

	@Override
	public Customer getCustomer(int theId) {
		// get the current session
		Session session = sessionFactory.getCurrentSession();

		// retrieve/read data from database using the primaryKey
		Customer theCustomer = session.get(Customer.class, theId);

		return theCustomer;
	}

	@Override
	public Customer deleteCustomer(int theId) {
		// get the current session
		Session session = sessionFactory.getCurrentSession();

		// delete customer
		Query theQuery = session
				.createQuery("delete from Customer where id=:customerId");
		theQuery.setParameter("customerId", theId);
		theQuery.executeUpdate();
		return null;
	}
}
