package org.arunm.util;

import org.arunm.domain.Empresa;
import org.arunm.domain.Proveedor;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
    	
    	Configuration configuration = new Configuration();
    	configuration.configure("hibernate.cfg.xml");
    	configuration.addAnnotatedClass(Proveedor.class).
    	addAnnotatedClass(Empresa.class);
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