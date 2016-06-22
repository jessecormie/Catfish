package com.finalyearproject.spring.web.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.finalyearproject.spring.web.dao.FormValidationGroup;
import com.finalyearproject.spring.web.dao.PersistenceValidationGroup;


@Entity
@Table(name="forum")
public class Forum implements Comparable<Forum> { 

	@Id
	@GeneratedValue
	private int id;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Rating rating;
	
	@Size(min=5, max=50, groups={PersistenceValidationGroup.class, FormValidationGroup.class})
	private String forumTitle;//Persistent instance variables must be declared private, protected, or package-private
//	@Size(min=10, max=200, groups={PersistenceValidationGroup.class, FormValidationGroup.class})
	private String forumContent;
	private String date;
	@ManyToOne
	private User user;
	
	private int count;
	
	@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Comment> comments;

	public Forum(){
		this.user = new User();
	}

	public Forum(String forumTitle, String forumContent, String date, User user,
			List<Comment> comments, Rating rating) {
		super();
		this.forumTitle = forumTitle;
		this.forumContent = forumContent;
		this.date = date;
		this.user = user;
		this.comments = comments;
		this.rating = rating;
	}


	public Rating getRating() {
		return rating;
	}

	public void setRating(Rating rating) {
		this.rating = rating;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<Comment> getComments() {
		return comments;
	}



	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getForumTitle() {
		return forumTitle;
	}

	public void setForumTitle(String forumTitle) {
		this.forumTitle = forumTitle;
	}

	public String getForumContent() {
		return forumContent;
	}

	public void setForumContent(String forumContent) {
		this.forumContent = forumContent;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Forum [id=" + id + ", forumTitle=" + forumTitle + ", forumContent=" + forumContent + ", date=" + date
				+ ", reply=" +", user=" + user + ", comments="
				+ comments + "]";
	}

	@Override
	public int compareTo(Forum compareCount) {
		int compareQuantity = (compareCount).getCount();
		return  compareQuantity - this.count;
	}
	
}