package eg.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import eg.domain.User;

@Repository(value="jpaBean")
public class UserDAOJPAImpl implements CommonDAO<User> {

	@PersistenceContext
    private EntityManager em;
	 
	 
	 
	public User merge(User user) {
		 return em.merge(user);
	}

}
