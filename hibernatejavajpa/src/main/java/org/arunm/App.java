package org.arunm;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import eg.config.ExampleApplicationContext;
import eg.config.service.PersistentContextService;
import eg.domain.Customer;
import eg.domain.Deals;



/**
 * Hello world!
 *
 */
public class App 
{
	public static void main(String[] args) {
		AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(ExampleApplicationContext.class);
		PersistentContextService contextService = annotationConfigApplicationContext.getBean(PersistentContextService.class);
		
		Customer customer = new Customer();
		customer.setName("NewCust2");
		
		Deals deals = new Deals();
		deals.setDealColName("Deal2");
		
		customer.getDeals().add(deals);
		
		contextService.insertCustomer(customer);
		
		
	}

}
