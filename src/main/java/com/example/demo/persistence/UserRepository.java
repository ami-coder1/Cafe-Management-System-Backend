package com.example.demo.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	public List<User> findByUserName(String userName);
	
	public User findByUserEmail(String userEmail);
	
	public User findByUserEmailAndUserPassword(String userEmail, String userPassword);
}
