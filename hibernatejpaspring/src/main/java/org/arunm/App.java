package org.arunm;

import org.arunm.config.PersistenceJPAConfig;
import org.arunm.service.PersistenceService;
import org.arunm.service.PersistenceServiceFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       System.out.println("Inside App");
    	AnnotationConfigApplicationContext annotationContext= new AnnotationConfigApplicationContext(PersistenceJPAConfig.class);
        PersistenceService persistenceService = annotationContext.getBean(PersistenceService.class);
        
        PersistenceServiceFactory persistenceServiceFactory = annotationContext.getBean(PersistenceServiceFactory.class);
        persistenceServiceFactory.getPersistenceServiceFactory();
    }
}
