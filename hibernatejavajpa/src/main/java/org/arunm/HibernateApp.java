package org.arunm;

import org.hibernate.Session;
import org.hibernate.Transaction;

import eg.domain.Customer;
import eg.domain.Deals;

public class HibernateApp {

	public static void main(String[] args) {
	
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		Customer customer = new Customer();
		customer.setName("ArunM");
		
		Deals deals = (Deals)session.load(Deals.class, new Long(1));
		customer.getDeals().add(deals);
		
		session.save(customer);
		tx.commit();
		
	}

}
