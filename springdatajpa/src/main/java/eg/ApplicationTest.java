package eg;

import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import org.slf4j.Logger;
import eg.domain.User;
import eg.service.impl.UserManagerJPAImpl;

public class ApplicationTest {

	private static final Logger LOG = LoggerFactory.getLogger(ApplicationTest.class);
	
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext annotationConfigApplicationContext = new 
				AnnotationConfigApplicationContext(ApplicationContext.class);
		
		LOG.info("Application initialized " + annotationConfigApplicationContext);
		UserManagerJPAImpl userManager =
	                (UserManagerJPAImpl) annotationConfigApplicationContext.getBean(UserManagerJPAImpl.class);
		 User user = new User();
	        user.setUserName("johndoe");
	        user.setName("John Doe");
	        
	        userManager.insertUser(user);
	        
	        
	        System.out.println("User inserted!");

	        user = userManager.getUser("johndoe");

	        System.out.println("\nUser fetched by username!"
	                + "\nId: " + user.getId()
	                + "\nUsername: " + user.getUserName()
	                + "\nName: " + user.getName());

	        user.setName("After change");
	        userManager.mergeUser(user);

	}
}
