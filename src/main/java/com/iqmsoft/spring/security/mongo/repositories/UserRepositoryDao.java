package com.iqmsoft.spring.security.mongo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.iqmsoft.spring.security.mongo.domain.User;


public interface UserRepositoryDao extends CrudRepository<User, String> {
	
	
	public User findByUsername(String username);

}
