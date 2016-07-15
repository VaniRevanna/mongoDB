package com.mf.mongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Entity 
 * @author vrevanna
 *
 */
@Document(collection = "Users")
public class User {
	
	@Id
	private String id;
		
	private String userId;

	private String firstName;
	private String lastName;
	private String title;
	private String email;
	private String telephoneNumber;
	private String manager;
	private String image;
	private String workforceID;
	private String postalAddress;
	
	
	/**
	 * public constructor to create User with Available param's
	 * @param id
	 * @param userId
	 * @param firstName
	 * @param lastName
	 * @param title
	 * @param email
	 * @param telephoneNumber
	 * @param manager
	 * @param image
	 * @param workforceID
	 * @param postalAddress
	 */
	public User(String id, String userId, String firstName, String lastName,
			String title, String email, String telephoneNumber, String manager,
			String image, String workforceID, String postalAddress) {
		super();
		this.id = id;
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.title = title;
		this.email = email;
		this.telephoneNumber = telephoneNumber;
		this.manager = manager;
		this.image = image;
		this.workforceID = workforceID;
		this.postalAddress = postalAddress;
	}
	
	
	public String getId() {
		return id;
	}
	public String getUserId() {
		return userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getTitle() {
		return title;
	}
	public String getEmail() {
		return email;
	}
	public String getTelephoneNumber() {
		return telephoneNumber;
	}
	public String getManager() {
		return manager;
	}
	public String getImage() {
		return image;
	}
	public String getWorkforceID() {
		return workforceID;
	}
	public String getPostalAddress() {
		return postalAddress;
	}
}
