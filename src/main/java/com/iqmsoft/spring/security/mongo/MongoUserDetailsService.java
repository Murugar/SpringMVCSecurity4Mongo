package com.iqmsoft.spring.security.mongo;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.iqmsoft.spring.security.mongo.repositories.UserRepositoryDao;


@Component
public class MongoUserDetailsService implements UserDetailsService {
	private static final Logger LOGGER = Logger.getLogger(MongoUserDetailsService.class);

	@Resource
	private UserRepositoryDao userRepositoryDao;

	private org.springframework.security.core.userdetails.User userdetails;

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		boolean enabled = true;
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;
		
		com.iqmsoft.spring.security.mongo.domain.User user = getUserDetail(username);

		userdetails = new User(user.getUsername(),user.getPassword(),enabled,accountNonExpired,credentialsNonExpired,
				accountNonLocked,
				getAuthorities(user.getRole()));
		return userdetails;
	}

	public List<GrantedAuthority> getAuthorities(Integer role) {
		List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
		if (role.intValue() == 1) {
			authList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));

		} else if (role.intValue() == 2) {
			authList.add(new SimpleGrantedAuthority("ROLE_CAMPAIGN"));
		}
		LOGGER.debug(authList);
		return authList;
	}

	public com.iqmsoft.spring.security.mongo.domain.User getUserDetail(String username) {
		com.iqmsoft.spring.security.mongo.domain.User user = userRepositoryDao.findByUsername(username);
		return user;
	}
}