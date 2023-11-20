package com.cg.mts.dto;

import java.util.Objects;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
public class UserDTO {
    private int userId;
    
    
    @NotBlank(message = "Username is required")
    @Size(min = 3, max = 50, message = "Username must be between 3 and 50 characters")
    private String username;
    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "Password must be at least 6 characters")
    private String password;
    @NotBlank(message = "Role is required")
    @Pattern(regexp = "^(admin|customer)$", message = "Role must be ADMIN or CUSTOMER")
    private String role;
    
    private CustomerDTO customer;
    
    public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

    
    
	public UserDTO(int userId,String username,String password,String role,
			CustomerDTO customer) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.role = role;
		this.customer = customer;
	}



	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public CustomerDTO getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerDTO customer) {
		this.customer = customer;
	}

	

	


	@Override
	public int hashCode() {
		return Objects.hash(customer, password, role, userId, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDTO other = (UserDTO) obj;
		return Objects.equals(customer, other.customer) && Objects.equals(password, other.password)
				&& Objects.equals(role, other.role) && userId == other.userId
				&& Objects.equals(username, other.username);
	}
	
}