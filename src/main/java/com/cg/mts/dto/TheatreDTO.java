package com.cg.mts.dto;

import java.util.List;
import java.util.Objects;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


public class TheatreDTO {
    private int theatreId;
    @Size(max = 50, message = "Theatre name must be at most 50 characters")
    private String theatreName;
    @Size(max = 20, message = "Theatre city must be at most 20 characters")
    private String theatreCity;
    @Size(max = 30, message = "Manager name must be at most 30 characters")
    private String managerName;
    @Pattern(regexp = "\\d{10}", message = "Manager contact must be a 10-digit number")
    private String managerContact;
    private List<ScreenDTO> screens;
    private List<ShowDTO> shows;
	public TheatreDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TheatreDTO(int theatreId,String theatreName,String theatreCity,String managerName, String managerContact,
			List<ScreenDTO> screens, List<ShowDTO> shows) {
		super();
		this.theatreId = theatreId;
		this.theatreName = theatreName;
		this.theatreCity = theatreCity;
		this.managerName = managerName;
		this.managerContact = managerContact;
		this.screens = screens;
		this.shows = shows;
	}
	public int getTheatreId() {
		return theatreId;
	}
	public void setTheatreId(int theatreId) {
		this.theatreId = theatreId;
	}
	public String getTheatreName() {
		return theatreName;
	}
	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}
	public String getTheatreCity() {
		return theatreCity;
	}
	public void setTheatreCity(String theatreCity) {
		this.theatreCity = theatreCity;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public String getManagerContact() {
		return managerContact;
	}
	public void setManagerContact(String managerContact) {
		this.managerContact = managerContact;
	}
	public List<ScreenDTO> getScreens() {
		return screens;
	}
	public void setScreens(List<ScreenDTO> screens) {
		this.screens = screens;
	}
	public List<ShowDTO> getShows() {
		return shows;
	}
	public void setShows(List<ShowDTO> shows) {
		this.shows = shows;
	}
	@Override
	public int hashCode() {
		return Objects.hash(managerContact, managerName, screens, shows, theatreCity, theatreId, theatreName);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TheatreDTO other = (TheatreDTO) obj;
		return Objects.equals(managerContact, other.managerContact) && Objects.equals(managerName, other.managerName)
				&& Objects.equals(screens, other.screens) && Objects.equals(shows, other.shows)
				&& Objects.equals(theatreCity, other.theatreCity) && theatreId == other.theatreId
				&& Objects.equals(theatreName, other.theatreName);
	}
    
    
    
}