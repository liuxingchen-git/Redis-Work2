package com.liuxingchen.redis.test.controller;

import org.springframework.stereotype.Controller;

import com.liuxingchen.redis.test.domain.User;

public class UserController {
	
	User user = new User();
	
	//id
	public void AddAll() {
		
		for (int i = 1; i <= 100000; i++) {
			i = user.getId();
			System.out.println(i);
		}
	}

}
