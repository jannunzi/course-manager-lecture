package com.jga.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jga.models.User;
import com.jga.repositories.UserRepository;

@RestController
public class UserService {
	@Autowired
	UserRepository userRepository;

	@DeleteMapping("/api/user/{userId}")
	public void deleteUser
			(@PathVariable("userId") int id) {
		userRepository.delete(id);
	}
	
	@PutMapping("/api/user/{userId}")
	public User updateUser(
			@PathVariable("userId") int id,
			@RequestBody User newUser) {
		User user = userRepository.findOne(id);
		user.set(newUser);
		return userRepository.save(user);
	}
	
	@GetMapping("/api/user")
	public List<User> findAllUsers(
			@RequestParam(name="username", required=false)
				String username,
			@RequestParam(name="password", required=false)
				String password) {
		if(username != null && password != null) {
			return (List<User>) userRepository.findUserByCredentials(username, password);
		}
		else if(username != null) {
			return (List<User>) userRepository.findUserByUsername(username);
		}
		return (List<User>) userRepository.findAll();
	}
	
	@GetMapping("/api/user/{userId}")
	public User findUserById(
			@PathVariable("userId") int uid) {
		return userRepository.findOne(uid);
	}
	
	@PostMapping("/api/user")
	public User createUser(
			@RequestBody User user) {
		return userRepository.save(user);
	}
}
