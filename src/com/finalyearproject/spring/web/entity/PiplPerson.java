package com.finalyearproject.spring.web.entity;

import com.pipl.api.data.containers.Relationship;

public class PiplPerson {

	private String firstName;
	private String lastName;
	private String age;
	private String gender;
	private String location;
	private String piplJob;
	private String piplImage;
	private String piplUrl;
	private Relationship piplRelations;
	private String phone;

	public PiplPerson() {
		super();
	}

	public PiplPerson(String firstName, String lastName, String age, String gender, String location, String piplJob,
			String piplImage, String piplUrl, Relationship piplRelations, String phone) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.location = location;
		this.piplJob = piplJob;
		this.piplImage = piplImage;
		this.piplUrl = piplUrl;
		this.piplRelations = piplRelations;
		this.phone = phone;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPiplJob() {
		return piplJob;
	}

	public void setPiplJob(String piplJob) {
		this.piplJob = piplJob;
	}

	public String getPiplImage() {
		return piplImage;
	}

	public void setPiplImage(String piplImage) {
		this.piplImage = piplImage;
	}

	public String getPiplUrl() {
		return piplUrl;
	}

	public void setPiplUrl(String piplUrl) {
		this.piplUrl = piplUrl;
	}

	public Relationship getPiplRelations() {
		return piplRelations;
	}

	public void setPiplRelations(Relationship piplRelations) {
		this.piplRelations = piplRelations;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
