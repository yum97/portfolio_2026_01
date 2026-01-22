package com.example.demo.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.example.demo.entity.UserEntity;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {

	 private final UserRepository userRepository;

	    public UserService(UserRepository userRepository) {
	        this.userRepository = userRepository;
	    }

	    // 管理者照会
	    public UserEntity findAdminByEmail(String email) {
	        return userRepository.findByEmail(email)
	            .orElseThrow(() -> new RuntimeException("Admin not found"));
	    }

	    // 最後のログイン時間
	    public void updateLastLogin(UserEntity user) {
	        user.setLastLoginAt(LocalDateTime.now());
	        userRepository.save(user);
	    }
}
