package hello.repository;

import hello.domain.User;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

@Transactional
public interface UserRepository extends CrudRepository<User, Integer> {

	public User findByLogin(String email);
}
