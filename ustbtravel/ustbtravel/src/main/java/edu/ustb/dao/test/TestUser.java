package edu.ustb.dao.test;

import org.junit.Test;

import edu.ustb.dao.UserDao;
import edu.ustb.dao.impl.UserDaoImpl;
import edu.ustb.domain.User;

public class TestUser {
	
	UserDao userDao=new UserDaoImpl();
	
	@Test
	public void testFindUser(){
		User user=userDao.findByUserName("admin123");
		System.out.println(user);
	}
	
	@Test
	public void testUserRegister(){
		User user=new User();
		user.setUsername("tom1234");
		user.setPassword("tom1234");
		user.setEmail("tomcat@163.com");
		userDao.save(user);
	}
}
