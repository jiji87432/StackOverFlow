package eg.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import eg.domain.User;
import eg.repository.UserDAOJPA;
import eg.service.UserManager;

@Component
public class UserManagerJPAImpl {

	 	@Autowired
	    private UserDAOJPA userDAO;


	    @Transactional
	    public void insertUser(User user) {
	        userDAO.save(user);
	    }

	    @Transactional
	    public User getUserById(int userId) {
	        return userDAO.findOne(userId);
	    }

	    @Transactional
	    public User getUser(String userName) {
	        return userDAO.findByUserName(userName);
	    }

	    @Transactional
	    public List<User> getUsers() {
	        return userDAO.findAll();
	    }

	    @Transactional
	    public User mergeUser(User user) {
	    	return userDAO.merge(user);
	    }
}
