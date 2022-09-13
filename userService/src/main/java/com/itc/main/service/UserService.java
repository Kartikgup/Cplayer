package com.itc.main.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itc.main.entity.User;
import com.itc.main.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public User save(User user) {
		return this.userRepository.save(user);
	}
	
	public User findById(int userId) {
		Optional<User> op=this.userRepository.findById(userId);
		if(op.isPresent()) {
			return op.get();
		}else {
			return null;
		}
	}

}
