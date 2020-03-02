package com.liuxingchen.redis.test.service.impl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.liuxingchen.redis.test.domain.User;
import com.liuxingchen.redis.test.service.UserService;
import com.liuxingchen.util.StringUtil;

//@ContextConfiguration("classpath:spring-beans.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceImplTest {

	@Autowired
	private UserService service;
	
	
	@Test
	public void addAll() {
//		List<User> list = new ArrayList<User>();
		for (int i = 1; i <= 100000; i++) {
			String rc = StringUtil.randomChineseString(3);
			System.out.println(rc);
		}
		
	}

}
