/**
 * 
 */
package com.example.java8training;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * @author kuzhali.r
 *
 */
public class Employee {
	private String userName;
	private String gender;
	private String education;
	private LocalDateTime createdDate;
	private Optional<User> user;
	
	
	
	/**
	 * @return the createdDate
	 */
	public LocalDateTime getCreatedDate() {
		return createdDate;
	}
	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}
	/**
	 * @return the user
	 */
	public Optional<User> getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(Optional<User> user) {
		this.user = user;
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
	 * @param userName
	 * @param gender
	 * @param education
	 */
	public Employee(String userName, String gender, String education) {
		super();
		this.userName = userName;
		this.gender = gender;
		this.education = education;
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Employee [userName=" + userName + ", gender=" + gender + ", education=" + education + "]";
	}
	Employee() {
		
	}
}
