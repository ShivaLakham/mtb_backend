package com.cg.mts.dto;

import java.util.Objects;

public class LoginDTO {
    private boolean loginStatus;
    private UserDTO user;
    

    public LoginDTO() {

    }

    public LoginDTO(boolean loginStatus, UserDTO user) {
        this.loginStatus = loginStatus;
        this.user = user;
    }

    public boolean isLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(boolean loginStatus) {
        this.loginStatus = loginStatus;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

  public String getRole() {
	  return user.getRole();
  }

@Override
public int hashCode() {
	return Objects.hash(loginStatus, user);
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	LoginDTO other = (LoginDTO) obj;
	return loginStatus == other.loginStatus && Objects.equals(user, other.user);
}
  
  
}