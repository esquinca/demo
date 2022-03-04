/**
 * 
 */
package com.example.java8training;

import java.time.LocalDate;

/**
 * @author kuzhali.r
 *
 */
public class User {
	
	private int userId;
	private String userName;
	private LocalDate dateOfBirth;
	private String gender;
	private String education;
	
	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}
	/**
	 * @return the education
	 */
	public String getEducation() {
		return education;
	}
	/**
	 * @param education the education to set
	 */
	public void setEducation(String education) {
		this.education = education;
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the dateOfBirth
	 */
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @param userId
	 * @param userName
	 * @param dateOfBirth
	 * @param gender
	 * @param education
	 */
	public User(int userId, String userName, LocalDate dateOfBirth, String gender, String education) {
		this.userId = userId;
		this.userName = userName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.education = education;
	}
	/**
	 * 
	 */
	public User() {
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", dateOfBirth=" + dateOfBirth + ", gender="
				+ gender + ", education=" + education + "]";
	}

	
}
