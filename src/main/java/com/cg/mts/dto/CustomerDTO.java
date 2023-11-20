package com.cg.mts.dto;


import java.util.Objects;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

public class CustomerDTO {
    private int customerId;
    @Size(min = 3, max = 50, message = "Customer name must be between 3 and 50 characters")
    private String customerName;
    @NotBlank(message = "Address is required")
    private String address;
    @Pattern(regexp = "\\d{10}", message = "Mobile number must be a 10-digit number")
    private String mobileNumber;
    @Email(message = "Invalid email address")
    private String email;
    @NotBlank(message = "Password is required")
    private String password;
    
    public CustomerDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    public CustomerDTO(int customerId,
			 String customerName,
			String address,
			 String mobileNumber,
			String email,
			 String password) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.address = address;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.password = password;
    }
    
    
    
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
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
	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(address, customerId, customerName, email, mobileNumber, password);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerDTO other = (CustomerDTO) obj;
		return Objects.equals(address, other.address) && customerId == other.customerId
				&& Objects.equals(customerName, other.customerName) && Objects.equals(email, other.email)
				&& Objects.equals(mobileNumber, other.mobileNumber) && Objects.equals(password, other.password);
	}
   
}