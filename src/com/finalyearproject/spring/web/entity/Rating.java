package com.finalyearproject.spring.web.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
public class Rating {

	@Id
	@GeneratedValue
	private int id;
	
	@ManyToMany(cascade= CascadeType.ALL,fetch = FetchType.EAGER)
	private List<User> userRatings;

	public Rating() {
		super();
	}

	public Rating(List<User> userRatings) {
		super();
		this.userRatings = userRatings;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<User> getUserRatings() {
		return userRatings;
	}

	public void setUserRatings(List<User> userRatings) {
		this.userRatings = userRatings;
	}

	@Override
	public String toString() {
		return "Rating [id=" + id + ", userRatings=" + userRatings + "]";
	}

	
}