package com.finalyearproject.spring.web.test.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.finalyearproject.spring.web.dao.UserDao;
import com.finalyearproject.spring.web.entity.User;

@ActiveProfiles("dev")
@ContextConfiguration(locations = { "classpath:com/finalyearproject/spring/web/config/dao-context.xml",
		"classpath:com/finalyearproject/spring/web/config/security-context.xml",
		"classpath:com/finalyearproject/spring/web/test/config/datasource.xml" })

@RunWith(SpringJUnit4ClassRunner.class)
public class UserDaoTests {

	private UserDao userDao;

	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Test
	public void testUser() {
		User user = new User(true, "ROLE_USER", "male", "hellothere", "jesse@gmail.com", "jesse", "mccormick", "08/04/1994",
				null, null);

		userDao.saveOrUpdate(user);
		
		

		// assertTrue("User creation should return true", userDao.create(user));

		// List <User> users = userDao.getAllUsers();
		//
		// assertEquals("Number of users should be 1", 0, users.size());

		// assertTrue("User should exist.", userDao.exists(user.getUsername()));
		//
		// assertEquals("Created user should be identical to retrieve user.",
		// user, users.get(0));

		// forum
	}

}