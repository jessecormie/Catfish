package com.finalyearproject.spring.web.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.finalyearproject.spring.web.entity.Comment;
import com.finalyearproject.spring.web.entity.Forum;

@Repository
@Transactional
@Component("CommentDao")
public class CommentDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Session session() {
		return sessionFactory.getCurrentSession();
	}
	public Comment getComment(int id) {
		Criteria crit = session().createCriteria(Comment.class);
		crit.add(Restrictions.idEq(id));
		return (Comment) crit.uniqueResult();
		
	}
	public void update(Comment commentObj) {
		session().update(commentObj);
		
	}
	
	public void merge(Comment commentObj) {
		session().merge(commentObj);
		
	}
	public void delete(Comment commentObj) {
		// TODO Auto-generated method stub
		session().delete(commentObj);
	}
	

}
