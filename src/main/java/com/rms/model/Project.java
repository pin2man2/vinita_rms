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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rms.util.DateHandler;

@Entity
@Table(name = "PROJECT")
public class Project implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PROJECT_ID")
	private Long UserId;
	@Column(name = "PROJECT_NAME")
	private String projectName;
	@JsonDeserialize(using = DateHandler.class)
	@Column(name = "START_DATE")
	private Date startDate;
	@JsonDeserialize(using = DateHandler.class)
	@Column(name = "END_DATE")
	private Date endDate;
	@Column(name = "TECHNOLOGIES")
	private String technologies;
	
	@ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	 @JoinTable(
		        name = "User_Project", 
		        joinColumns = { @JoinColumn(name = "project_id") }, 
		        inverseJoinColumns = { @JoinColumn(name = "user_id") })
	@JsonIgnore
    private Set<User> userList ;

	public Project() {
		
	}
	
	public Set<User> getUserList() {
		return userList;
	}

	public void setUserList(Set<User> userList) {
		this.userList = userList;
	}


	
	
	public Long getUserId() {
		return UserId;
	}
	public void setUserId(Long userId) {
		UserId = userId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getTechnologies() {
		return technologies;
	}
	public void setTechnologies(String technologies) {
		this.technologies = technologies;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "Project [UserId=" + UserId + ", projectName=" + projectName + ", startDate=" + startDate + ", endDate="
				+ endDate + ", technologies=" + technologies + ", userList=" + userList + "]";
	}
	
	

}
