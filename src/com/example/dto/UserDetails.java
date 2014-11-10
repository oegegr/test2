package com.example.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity 
public class UserDetails {
	@Id
	@GeneratedValue 
	private int userId;
	@Column (name = "USER_NAME")
	private String userName;
	@Temporal (TemporalType.DATE)
	private Date joinedDate;
	@Lob
	private String description;
	@ElementCollection
	@JoinTable (name = "USER_ADDRESS",
			joinColumns = @JoinColumn (name = "USER_ID"))
	@GenericGenerator (name = "hilo-gen", strategy = "hilo")
	@CollectionId(columns = { @Column (name = "ADDRESS_ID")}, generator = "hilo-gen", type = @Type (type = "long"))
	private Collection<Address> listOfAddress = new ArrayList<Address>();
	
	public UserDetails() {
		
	}
	
	public UserDetails(String aUserName, String aDescription) {
		this.userName = aUserName;
		this.joinedDate = new Date();
		this.description = aDescription;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getJoinedDate() {
		return joinedDate;
	}
	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public Collection<Address> getListOfAddress() {
		return listOfAddress;
	}

	public void setListOfAddress(Collection<Address> listOfAddress) {
		this.listOfAddress = listOfAddress;
	}

}
