package com.jcg.hibernate.maven;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_table")
public class User {

	@Id
	@Column(name = "user_id")
	private int userid;

	@Column(name = "user_name")
	private String username;

	@Column(name = "created_by")
	private String createdBy;

	@Column(name = "created_date")
	private Date createdDate;
	
	public User () {
		
	}
	
	
	public User (int id) {
		this.setUserid(id);
		
	}
	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("userId->" + getUserid());
		sb.append("userName->" + getUsername());
		sb.append("createdBy->" + getCreatedBy());
		sb.append("createDate->" + getCreatedDate() );
		return sb.toString();
	}
}