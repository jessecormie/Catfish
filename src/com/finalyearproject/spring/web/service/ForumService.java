package com.finalyearproject.spring.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import com.finalyearproject.spring.web.dao.ForumDao;
import com.finalyearproject.spring.web.entity.Forum;

@Service("forumService")
public class ForumService {

	private ForumDao forumDao;

	@Autowired
	public void setForumDao(ForumDao forumDao) {
		this.forumDao = forumDao;
	}

	public List<Forum> getCurrent() {
		return forumDao.getForum();
	}

	@Secured({ "ROLE_USER", "ROLE_ADMIN" })
	public void create(Forum forum) {
		forumDao.saveOrUpdate(forum);
	}

	public Forum getForum(String username) {
		if (username == null) {
			return null;
		}
		List<Forum> forum = forumDao.getForum(username);

		if (forum.size() == 0) {
			return null;
		}
		return forum.get(0);
	}

	// can use if you want to edit the most recent forum
	public void saveOrUpdate(Forum forum) {
		forumDao.saveOrUpdate(forum);
	}

	public Forum getOneForum(int id) {
		// TODO Auto-generated method stub
		return forumDao.getForum(id);
	}
	
	public void removeComment(int commentId){
		forumDao.removeComment(commentId);
	}

}
