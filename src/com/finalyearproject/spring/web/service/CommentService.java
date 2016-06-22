package com.finalyearproject.spring.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalyearproject.spring.web.dao.CommentDao;
import com.finalyearproject.spring.web.entity.Comment;

@Service("commentService")
public class CommentService {

	private CommentDao commentDao;
	
	@Autowired
	public void setCommentDao(CommentDao commentDao) {
		this.commentDao = commentDao;
	}


	public Comment getComment(int id) {
		return commentDao.getComment(id);
		
	}


	public void update(Comment commentObj) {
		commentDao.update(commentObj);
		
	}
	
	public void merge(Comment commentObj) {
		commentDao.merge(commentObj);
	}
	
	public void delete(Comment commentObj){
		commentDao.delete(commentObj);
	}
	

}
