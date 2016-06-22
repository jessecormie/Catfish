package com.finalyearproject.spring.web.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import com.finalyearproject.spring.web.dao.FormValidationGroup;
import com.finalyearproject.spring.web.dao.PersistenceValidationGroup;
import com.finalyearproject.spring.web.validation.ValidEmail;

@Entity
@Table(name = "User")
public class User {

	private boolean enabled = false;
	private String authority;
	private String gender;

	@NotBlank
	@Pattern(regexp = "^\\S+$", groups = { PersistenceValidationGroup.class, FormValidationGroup.class })
	@Size(min = 8, max = 15, groups = { FormValidationGroup.class })
	private String password;

	@NotBlank
	@ValidEmail(groups = { PersistenceValidationGroup.class, FormValidationGroup.class })
	@Id
	@Column(name = "username")
	private String username;

	@NotBlank
	@Size(min = 3, max = 60, groups = { FormValidationGroup.class })
	private String firstName;
	@NotBlank
	@Size(min = 3, max = 60, groups = { FormValidationGroup.class })
	private String lastName;

	@NotBlank(groups = { PersistenceValidationGroup.class, FormValidationGroup.class })
	@Pattern(regexp = "^([0]?[1-9]|[1|2][0-9]|[3][0|1])[./-]([0]?[1-9]|[1][0-2])[./-]([0-9]{4}|[0-9]{2})$")
	private String dateOfBirth;

	private String about;
	
	private String encodedImage;
	
	
	//private Integer imageId;
	//private MultipartFile image;
	@Lob
	@Column(name="image", columnDefinition="mediumblob")
	private byte[] image;

	public User() {

	}


	public User(boolean enabled, String authority, String gender, String password, String username, String firstName,
			String lastName, String dateOfBirth, String encodedImage, byte[] image) {
		super();
		this.enabled = enabled;
		this.authority = authority;
		this.gender = gender;
		this.password = password;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.encodedImage = encodedImage;
		this.image = image;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((authority == null) ? 0 : authority.hashCode());
		result = prime * result + (enabled ? 1231 : 1237);
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (authority == null) {
			if (other.authority != null)
				return false;
		} else if (!authority.equals(other.authority))
			return false;
		if (enabled != other.enabled)
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	

	public String getAbout() {
		return about;
	}


	public void setAbout(String about) {
		this.about = about;
	}


	public String getEncodedImage() {
		return encodedImage;
	}


	public void setEncodedImage(String encodedImage) {
		this.encodedImage = encodedImage;
	}


	public byte[] getImage() {
		return image;
	}


	public void setImage(byte[] image) {
		this.image = image;
	}


	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	

	@Override
	public String toString() {
		return "User [enabled=" + enabled + ", authority=" + authority + ", gender=" + gender + ", password=" + password
				+ ", username=" + username + ", firstName=" + firstName + ", lastName=" + lastName + ", dateOfBirth="
				+ dateOfBirth + ", image=" + image + "]";
	}

	

	

}
