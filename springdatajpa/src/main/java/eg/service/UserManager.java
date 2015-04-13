package eg.service;

import java.util.List;

import eg.domain.User;

public interface UserManager {

	public void insertUser(User user);
	public User getUserById(int userId);
	public User getUser(String username);
	public List<User> getUsers();
	public User mergeUser(User user);
}
