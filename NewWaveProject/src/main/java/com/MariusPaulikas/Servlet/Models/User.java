package com.MariusPaulikas.Servlet.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import org.springframework.lang.NonNull;

@Entity
@Table(name = "user")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NonNull
	@Size(min = 2, message = "The first name field must be at least 2 characters in length.")
	private String firstname;
	
	@NonNull
	@Size(min = 2, message = "The last name field must be at least 2 characters in length.")
	private String lastname;
	
	
	@NonNull
	@Email
	@Size(min = 2, message = "Email must be 2 characters in length and have a valid address.")
	private String email;
	
	
	@NonNull
	@Size(min = 3, message = "Your username must be at least 3 characters in length.")
	private String username;
	
	

	@NonNull
	@Size (min = 5, message = "Your password must be at least 5 characters in length.")
	private String password;
	
	@Transient
	private String confirmpassword;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmpassword() {
		return confirmpassword;
	}

	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}
	
	
	
	
	

}
