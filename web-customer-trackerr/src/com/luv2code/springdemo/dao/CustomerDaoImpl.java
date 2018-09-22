package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.entity.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDAO {

	// need to inject session factory 
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		
		// get the current hibernate session 
		Session currentSession = sessionFactory.getCurrentSession();
			
		// create a query ... sort by last name
		Query<Customer> theQuery = 
		     currentSession.createQuery("from Customer order by lastName",
		    		                    Customer.class);
		
		// execute query and get result list 
		List<Customer> customers = theQuery.getResultList();
		
		// return the results 		
		return customers;
	}


	@Override
	public void saveCustomer(Customer theCustomer) {
		
		// get the current hibernate session 
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save/update the customer ... finally LOL
		currentSession.saveOrUpdate(theCustomer);
		
		
	}


	@Override
	public Customer getCustomer(int theId) {
		
		// get the current hibernate session 
		Session currentSession = sessionFactory.getCurrentSession();
		
		// now retrieve or read from database using the primary key 
		Customer theCustomer = currentSession.get(Customer.class, theId);
		
		return theCustomer;
	}


	@Override
	public void deleteCustomer(int theId) {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete the id with primary key
		Query theQuery = 
		  currentSession.createQuery("delete from Customer where id=:customerId");
		
		theQuery.setParameter("customerId", theId);
		
		theQuery.executeUpdate();
		
		
	}
	
	

}