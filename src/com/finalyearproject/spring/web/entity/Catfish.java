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
	private String homePhone;
	private String mobilePhone;
	private String facebook;
	private Object metadataDate;
	private double metadataLat;
	private double metadataLong;

	// fc
	private String children;
	private String maritalStatus;
	private List<Organization> fcJob;
	private List<Photo> fcPhotos;
	private List<SocialProfile> fcSocialProfiles;
	private double likely;

	// pipl
	private String piplJob;
	private String piplImage;
	private String piplUrl;
	private String phone;
	private Relationship piplRelations;

	// reverse image search
	private List<String> reverseImagePics;
	private List<String> reverseImageWebsites;

	public Catfish() {

	}
	
	

	public Catfish(String firstName, String lastName, String age, String gender, String location, String homePhone,
			String mobilePhone, String facebook, Object metadataDate, double metadataLat, double metadataLong,
			String children, String maritalStatus, List<Organization> fcJob, List<Photo> fcPhotos,
			List<SocialProfile> fcSocialProfiles, double likely, String piplJob, String piplImage, String piplUrl,
			String phone, Relationship piplRelations, List<String> reverseImagePics,
			List<String> reverseImageWebsites) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.location = location;
		this.homePhone = homePhone;
		this.mobilePhone = mobilePhone;
		this.facebook = facebook;
		this.metadataDate = metadataDate;
		this.metadataLat = metadataLat;
		this.metadataLong = metadataLong;
		this.children = children;
		this.maritalStatus = maritalStatus;
		this.fcJob = fcJob;
		this.fcPhotos = fcPhotos;
		this.fcSocialProfiles = fcSocialProfiles;
		this.likely = likely;
		this.piplJob = piplJob;
		this.piplImage = piplImage;
		this.piplUrl = piplUrl;
		this.phone = phone;
		this.piplRelations = piplRelations;
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

	public String getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public Relationship getPiplRelations() {
		return piplRelations;
	}

	public void setPiplRelations(Relationship piplRelations) {
		this.piplRelations = piplRelations;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}