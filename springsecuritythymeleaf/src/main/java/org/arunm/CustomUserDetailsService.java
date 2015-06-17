package org.arunm;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException {
		Optional<User> optUser = userRepository.findByUsername(userName);

		if (optUser.isPresent()) {
			return optUser.get();
		}

		throw new UsernameNotFoundException("No user");
	}

}
