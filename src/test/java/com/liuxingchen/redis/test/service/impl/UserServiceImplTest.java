package com.liuxingchen.redis.test.service.impl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.liuxingchen.redis.test.domain.User;
import com.liuxingchen.redis.test.service.UserService;
import com.liuxingchen.util.DateUtil;
import com.liuxingchen.util.StringUtil;

@ContextConfiguration("classpath:spring-beans.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceImplTest {

	@Resource
	private RedisTemplate redisTemplate;
	
	@Resource
	private UserService service;
	
	
	@Test
	public void test() {
		redisTemplate.opsForValue().set("a", "hello");
		String str = (String) redisTemplate.opsForValue().get("a");
		System.out.println(str);
	}
	
	
	@Test
	public void testInsert() {
		List<User> user = new ArrayList<User>();
		User u = new User();
		for (int i = 1; i <= 100000; i++) {
//			(1)ID使用1-10万的顺序号。（2分）
			u.setId(i);
//			(2)姓名使用3个随机汉字模拟，可以使用以前自己编写的工具方法。（4分）
			String g = StringUtil.generateChineseName();
			u.setName(g);
//			(3)性别在女和男两个值中随机。（4分）
			String sex1 = "男";
			String sex2 = "女";
			u.setSex(sex1);
			u.setSex(sex2);
//			(4)手机以13开头+9位随机数模拟。（4分）
//			Integer str = 13234348989;
//			boolean b = StringUtil.isPhoneNumber(str);
//			u.setTelephone(str);
//			(5)邮箱以3-20个随机字母 + @qq.com  | @163.com | @sian.com | @gmail.com | @sohu.com | @hotmail.com | @foxmail.com模拟。（4分）
			String src = "123322@qq.com";
			boolean b1 = StringUtil.isEMail(src);
			u.setEmail(src);
//			(6)生日要模拟18-70岁之间，即日期从1949年到2001年之间。（4分）
			Date d = DateUtil.randomDate(new Date(0), new Date());
			u.setBirthday(d);
			user.add(u);
		}
			System.out.println(user);
	}

}
