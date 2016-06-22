package com.finalyearproject.spring.web.test.tests;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.finalyearproject.spring.web.dao.ForumDao;
import com.finalyearproject.spring.web.dao.UserDao;
import com.finalyearproject.spring.web.entity.Forum;
import com.finalyearproject.spring.web.entity.User;

@ActiveProfiles("dev")
@ContextConfiguration(locations = {
		"classpath:com/finalyearproject/spring/web/config/dao-context.xml",
		"classpath:com/finalyearproject/spring/web/config/security-context.xml",
		"classpath:com/finalyearproject/spring/web/test/config/datasource.xml" })
@RunWith(SpringJUnit4ClassRunner.class)

public class ForumDaoTests {
	
	@Autowired
	private ForumDao forumDao;
	
	@Autowired
	private UserDao userDao;

	@Autowired
	private DataSource dataSource;
	

	
	@Test
	public void testCreateUser() {
		User user = new User();
		user.setUsername("jenny@gmail.com");
		user.setFirstName("Jenny");
		user.setLastName("Miley");
		user.setPassword("hellothere");
		user.setEnabled(true);
		user.setAuthority("ROLE_USER");
		
	//	assertTrue("Yep", userDao.create(user));
		Forum forum = new Forum();
		
		forum.setUser(user);
		forum.setForumTitle("Testing title");
		forum.setForumContent("Testing content");
		
		//assertTrue("Forum creation should return true", forumDao.create(forum));
		
		List<Forum> forums = forumDao.getForum();
		
		assertEquals("Should be one forum in database.", 1, forums.size());
		
		assertEquals("Retrieved offer should match created offer.", forum, forums.get(0));
		
		// Get the offer with ID filled in.
		forum = forums.get(0);
		
		forum.setForumContent("Updated forum content");
		//assertTrue("Forum update should return true", forumDao.update(forum));
		
		Forum updated = forumDao.getForum(forum.getId());
		
		assertEquals("Updated forum should match retrieved updated forum", forum, updated);
		
		// Test get by ID ///////
				Forum forum2 = new Forum();

				forum2.setUser(user);
				forum2.setForumTitle("Testing thissss");
				forum2.setForumContent("Forum test content");
				
				//assertTrue("Forum creation should return true", forumDao.create(forum2));
				
				List<Forum> userForum = forumDao.getForum(user.getUsername());
				assertEquals("Should be two forums for user.", 2, userForum.size());
				
				List<Forum> secondList = forumDao.getForum();
				
				for(Forum current: secondList) {
					Forum retrieved = forumDao.getForum(current.getId());
					
					assertEquals("Forum by ID should match offer from list.", current, retrieved);
				}
				
				// Test deletion
				forumDao.delete(forum.getId());

				List<Forum> finalList = forumDao.getForum();

				assertEquals("Forum lists should contain one offer.", 1, finalList.size());
			}

	}
	

