package eg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import eg.domain.User;


public interface UserDAOJPA extends JpaRepository<User, Integer>,CommonDAO<User> {
	public User findByUserName(String userName);
}
