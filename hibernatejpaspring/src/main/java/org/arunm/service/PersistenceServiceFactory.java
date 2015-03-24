package org.arunm.service;

import javax.persistence.EntityManagerFactory;

import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersistenceServiceFactory {

	@Autowired
	private EntityManagerFactory entityManagerFactory;
	
	 @Autowired
	 private SessionFactory sessionFactory;
	 
	public void getPersistenceServiceFactory(){
		System.out.println("getPersistenceServiceFactory");
		final HibernateEntityManagerFactory emFactory = (HibernateEntityManagerFactory) entityManagerFactory;
       // final SessionFactory sessionFactory = emFactory.getSessionFactory(); 
        sessionFactory.getCurrentSession();
        System.out.println("getPersistenceServiceFactory sessionFactory");
	}
}
