package org.arunm.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.springframework.stereotype.Component;

@Component
public class PersistenceService {

	@PersistenceContext
	private EntityManager entityManager;
	
	public void getPersistenceService(){
		System.out.println("Inside getPersistenceService");
		final EntityManagerFactory entityManagerFactory = entityManager
				.getEntityManagerFactory();
		final HibernateEntityManagerFactory entityManagerFactoryImpl = (HibernateEntityManagerFactory) entityManagerFactory;
		final SessionFactory sessionFactory = entityManagerFactoryImpl
				.getSessionFactory();
		sessionFactory.getCurrentSession();
		System.out.println("Inside sessionFactory");
	}
}
