package com.cg.mts.entity;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicUpdate;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity

public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userid;
	//@NotBlank(message = "Username is required")
    //@Size(min = 3, max = 50, message = "Username must be between 3 and 50 characters")
	private String username;
	//@NotBlank(message = "Password is required")
    //@Size(min = 6, message = "Password must be at least 6 characters")
	private String password;
	//@NotBlank(message = "Role is required")
    //@Pattern(regexp = "^(ADMIN||CUSTOMER)$", message = "Role must be ADMIN or CUSTOMER")
	private String role;
	@OneToOne
	private Customer customer;
	
	public User() {

	}

	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public User(String username, String password, String role, Customer customer) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
		this.customer = customer;
		
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void setRole(String role) {
		this.role = role;
	}

	
	public String getRole() {
		return role;
	}
	@Override
	public int hashCode() {
		return Objects.hash(customer, password, role, userid, username);
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
		return Objects.equals(customer, other.customer) && Objects.equals(password, other.password)
				&& Objects.equals(role, other.role) && userid == other.userid
				&& Objects.equals(username, other.username);
	}

	
}
