package com.finalyearproject.spring.web.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.finalyearproject.spring.web.entity.Forum;

@Repository
@Transactional
@Component("forumDao")
public class ForumDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Session session() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	public List<Forum> getForum() {
		Criteria crit = session().createCriteria(Forum.class);
		crit.createAlias("user", "u").add(Restrictions.eq("u.enabled", true));
		crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return crit.list();
	}

	@SuppressWarnings("unchecked")
	public List<Forum> getForum(String username) {
		Criteria crit = session().createCriteria(Forum.class);
		crit.createAlias("user", "u");
		crit.add(Restrictions.eq("u.enabled", true));
		crit.add(Restrictions.eq("u.username", username));
		return crit.list();
	}

	public void saveOrUpdate(Forum forum) {
		session().saveOrUpdate(forum);
	}

	public boolean delete(int id) {
		Query query = session().createQuery("delete from Forum where id=:id");// hql
		query.setLong("id", id);
		return query.executeUpdate() == 1;
	}

	public Forum getForum(int id) {
		Criteria crit = session().createCriteria(Forum.class);
		crit.createAlias("user", "u");
		crit.add(Restrictions.eq("u.enabled", true));
		crit.add(Restrictions.idEq(id));
		return (Forum) crit.uniqueResult();
	}

	public boolean removeComment(int comments_id) {
		System.out.println("Heya" + comments_id);
		Query query = session().createQuery("delete from forum_comment where comments_id=:comments_id");// hql
		query.setLong("comments_id", comments_id);
		return query.executeUpdate() == 1;

	}
}