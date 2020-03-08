package com.spring.demoblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.demoblog.entity.User;
import com.spring.demoblog.repository.UserRepository;

@Service
public class UserService  {


	@Autowired
	private UserRepository userRepository;

	public UserService( UserRepository userRepository) {

		this.userRepository = userRepository;
	}

	public User save(User user) {
		return userRepository.save(user);
	}
	
	public User findUserById(Long id) {
		return userRepository.findById(id).get();
	}
	/*
	public org.springframework.security.core.userdetails.User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}*/

}
