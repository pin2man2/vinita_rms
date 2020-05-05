package com.rms.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "User")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_ID")
	private Long UserId;
	@Column(name = "EMP_ID")
	private String empId;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "MOBILE")
	private String mobile;

	@Column(name = "ADDRESS")
	private String address;

	@Column(name = "EMAIL")
	private String email;
	@Column(name = "GRADE")
	private String grade;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "ALTERNATE_MOBILE")
	private String alternateMobile;

	@Column(name = "IS_ACTIVE")
	private Integer isActive;
	
	@Column(name = "ROLLED_OFF")
	private boolean isRolledOff;

	@CreationTimestamp
	@Column(name = "CREATION_DATE")
	private Date creationDate;

	@UpdateTimestamp
	@Column(name = "UPDATION_DATE")
	private Date updationDate;

	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name = "USER_TYPE_IP_FK")
	private UserType userType;
	
	@ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JsonProperty(value="projectList")
	@JsonIgnore
	private Set<Project> projectList;

	public Set<Project> getProjectList() {
		return projectList;
	}


	public void setProjectList(Set<Project> projectList) {
		this.projectList = projectList;
	}


	public User() {

	}

	public boolean isRolledOff() {
		return isRolledOff;
	}


	public void setRolledOff(boolean isRolledOff) {
		this.isRolledOff = isRolledOff;
	}
	public Long getUserId() {
		return UserId;
	}

	public void setUserId(Long userId) {
		UserId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAlternateMobile() {
		return alternateMobile;
	}

	public void setAlternateMobile(String alternateMobile) {
		this.alternateMobile = alternateMobile;
	}

	public Integer getIsActive() {
		return isActive;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getUpdationDate() {
		return updationDate;
	}

	public void setUpdationDate(Date updationDate) {
		this.updationDate = updationDate;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}


	@Override
	public String toString() {
		return "User [UserId=" + UserId + ", empId=" + empId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", mobile=" + mobile + ", address=" + address + ", email=" + email + ", grade=" + grade
				+ ", password=" + password + ", alternateMobile=" + alternateMobile + ", isActive=" + isActive
				+ ", creationDate=" + creationDate + ", updationDate=" + updationDate + ", userType=" + userType
				+ ", projectList=" + projectList + "]";
	}
	
	
	

}
