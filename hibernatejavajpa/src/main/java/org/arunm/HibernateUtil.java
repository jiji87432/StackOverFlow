package org.arunm;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import eg.domain.Customer;
import eg.domain.Deals;

public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
    	
    	Configuration configuration = new Configuration();
    	configuration.configure("hibernate.cfg.xml");
    	configuration.addAnnotatedClass(Customer.class);
    	configuration.addAnnotatedClass(Deals.class);
    	System.out.println("Hibernate Configuration loaded");
     
    	//apply configuration property settings to StandardServiceRegistryBuilder
    	ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
    	System.out.println("Hibernate serviceRegistry created");
     
    	SessionFactory sessionFactory = configuration
                        .buildSessionFactory(serviceRegistry);
    	return sessionFactory;
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}