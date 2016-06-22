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
@Table(name = "reply")
public class Reply {

	@Id
	@GeneratedValue
	private int id;
	private String content;
	private String date;
	
	private int count;

	@OneToOne(cascade = {CascadeType.ALL, CascadeType.REMOVE}, fetch = FetchType.EAGER, orphanRemoval=true)
	private Rating rating;

	@ManyToOne
	private User user;

	public Reply() {
		super();
	}

	public Reply(String content, String date, Rating rating, User user) {
		super();
		this.content = content;
		this.date = date;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
