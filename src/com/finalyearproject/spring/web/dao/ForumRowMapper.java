package com.finalyearproject.spring.web.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.finalyearproject.spring.web.entity.Forum;
import com.finalyearproject.spring.web.entity.User;

public class ForumRowMapper implements RowMapper<Forum>{

	@Override
	public Forum mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setAuthority(rs.getString("authority"));
		user.setEnabled(true);
		user.setFirstName(rs.getString("firstName"));
		user.setLastName(rs.getString("lastName"));
		user.setUsername(rs.getString("username"));

		Forum forum = new Forum();
		forum.setId(rs.getInt("id"));
		forum.setForumTitle(rs.getString("forumTitle"));
		forum.setForumContent(rs.getString("forumContent"));
		forum.setUser(user);
		
		return forum;
	}

}
