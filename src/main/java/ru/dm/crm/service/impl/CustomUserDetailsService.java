package ru.dm.crm.service.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.dm.crm.domain.UserDetail;
import ru.dm.crm.entity.User;
import ru.dm.crm.repository.UserRepository;
import ru.dm.crm.repository.UserRoleRepository;

import javax.annotation.Resource;

/**
 * Created by Denis on 31.03.18.
 */

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Resource
	public UserRepository userRepository;
	@Resource
	public UserRoleRepository userRoleRepository;
	
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		return this.getUser(username);
	}

	public UserDetail getUser(String email) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(email);

		if (user == null) {
			throw new UsernameNotFoundException(email + " not found");
		}

		UserDetail userDetail = new UserDetail(user, userRoleRepository.findByUserId(user.getId()).getAuthority());
		return userDetail;
	}

}

