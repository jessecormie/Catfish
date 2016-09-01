package com.finalyearproject.spring.web.entity;

import java.util.List;

import com.fullcontact.api.libs.fullcontact4j.http.person.model.Organization;
import com.fullcontact.api.libs.fullcontact4j.http.person.model.Photo;
import com.fullcontact.api.libs.fullcontact4j.http.person.model.SocialProfile;

public class FullContactPerson {

	private String firstName;
	private String lastName;
	private String age;
	private String gender;
	private String location;
	private String children;
	private String facebook;
	private String phone;
	private String maritalStatus;
	private List<Organization> fcJob;
	private List<Photo> fcPhotos;
	private List<SocialProfile> fcSocialProfiles;
	private double likely;

	public FullContactPerson() {
		super();
	}

	public FullContactPerson(String firstName, String lastName, String age, String gender, String location,
			String children, String facebook, String phone, String maritalStatus, List<Organization> fcJob,
			List<Photo> fcPhotos, List<SocialProfile> fcSocialProfiles, double likely) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.location = location;
		this.children = children;
		this.facebook = facebook;
		this.phone = phone;
		this.maritalStatus = maritalStatus;
		this.fcJob = fcJob;
		this.fcPhotos = fcPhotos;
		this.fcSocialProfiles = fcSocialProfiles;
		this.likely = likely;
	}

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
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

	public String getChildren() {
		return children;
	}

	public void setChildren(String children) {
		this.children = children;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public List<Organization> getFcJob() {
		return fcJob;
	}

	public void setFcJob(List<Organization> fcJob) {
		this.fcJob = fcJob;
	}

	public List<Photo> getFcPhotos() {
		return fcPhotos;
	}

	public void setFcPhotos(List<Photo> fcPhotos) {
		this.fcPhotos = fcPhotos;
	}

	public List<SocialProfile> getFcSocialProfiles() {
		return fcSocialProfiles;
	}

	public void setFcSocialProfiles(List<SocialProfile> fcSocialProfiles) {
		this.fcSocialProfiles = fcSocialProfiles;
	}

	public double getLikely() {
		return likely;
	}

	public void setLikely(double likely) {
		this.likely = likely;
	}

}