package com.finalyearproject.spring.web.entity;

import java.util.List;

import com.fullcontact.api.libs.fullcontact4j.http.person.model.Organization;
import com.fullcontact.api.libs.fullcontact4j.http.person.model.Photo;
import com.fullcontact.api.libs.fullcontact4j.http.person.model.SocialProfile;
import com.pipl.api.data.containers.Relationship;

public class Catfish {

	private String firstName;
	private String lastName;
	private String age;
	private String gender;
	private String location;
	private String facebook;
	private String phone;
	private Object metadataDate;
	private double metadataLat;
	private double metadataLong;

	// reverse image search
	private List<String> reverseImagePics;
	private List<String> reverseImageWebsites;

	public Catfish() {

	}

	public Catfish(String firstName, String lastName, String age, String gender, String location, String facebook,
			String phone, Object metadataDate, double metadataLat, double metadataLong, List<String> reverseImagePics,
			List<String> reverseImageWebsites) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.location = location;
		this.facebook = facebook;
		this.phone = phone;
		this.metadataDate = metadataDate;
		this.metadataLat = metadataLat;
		this.metadataLong = metadataLong;
		this.reverseImagePics = reverseImagePics;
		this.reverseImageWebsites = reverseImageWebsites;
	}

	public List<String> getReverseImagePics() {
		return reverseImagePics;
	}

	public void setReverseImagePics(List<String> reverseImagePics) {
		this.reverseImagePics = reverseImagePics;
	}

	public List<String> getReverseImageWebsites() {
		return reverseImageWebsites;
	}

	public void setReverseImageWebsites(List<String> reverseImageWebsites) {
		this.reverseImageWebsites = reverseImageWebsites;
	}

	public Object getMetadataDate() {
		return metadataDate;
	}

	public void setMetadataDate(Object metadataDate) {
		this.metadataDate = metadataDate;
	}

	public double getMetadataLat() {
		return metadataLat;
	}

	public void setMetadataLat(double metadataLat) {
		this.metadataLat = metadataLat;
	}

	public double getMetadataLong() {
		return metadataLong;
	}

	public void setMetadataLong(double metadataLong) {
		this.metadataLong = metadataLong;
	}

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}