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

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;



@Entity
@Table(name = "comment")
public class Comment implements Comparable<Comment> {

	@Id
	@GeneratedValue
	private int id;
	private String content;
	private String date;

	private int count;

	@OneToMany(cascade = {CascadeType.ALL, CascadeType.REMOVE}, fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	private List<Reply> replies;

	@OneToOne(cascade = {CascadeType.ALL, CascadeType.REMOVE}, fetch = FetchType.EAGER)
	private Rating rating;

	@ManyToOne
	private User user;

	public Comment() {
		super();
	}

	public Comment(String content, String date, int count, List<Reply> replies, Rating rating, User user) {
		super();
		this.content = content;
		this.date = date;
		this.count = count;
		this.replies = replies;
		this.rating = rating;
		this.user = user;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Rating getRating() {
		return rating;
	}

	public void setRating(Rating rating) {
		this.rating = rating;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public List<Reply> getReplies() {
		return replies;
	}

	public void setReplies(List<Reply> replies) {
		this.replies = replies;
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", content=" + content + ", date=" + date + ", count=" + count + ", replies="
				+ replies + ", rating=" + rating + ", user=" + user + "]";
	}

	@Override
	public int compareTo(Comment compareCount) {
		int compareQuantity = (compareCount).getCount();
		return  compareQuantity - this.count;
	}
	

}