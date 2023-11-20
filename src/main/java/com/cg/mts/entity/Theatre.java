package com.cg.mts.entity;

import java.util.List;
import java.util.Objects;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity

@Table(name = "theatre")
public class Theatre {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int theatreId;
	private String theatreName;
	private String theatreCity;
	private String managerName;
	private String managerContact;
	@OneToMany(mappedBy = "theatre",cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Screen> screen;
	@JsonIgnore
	@OneToMany(mappedBy = "theatre",cascade = CascadeType.ALL)
	private List<Show> show;
	public Theatre() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Theatre(String theatreName, String theatreCity, String managerName, String managerContact,
			List<Screen> screen, List<Show> show) {
		super();
		this.theatreName = theatreName;
		this.theatreCity = theatreCity;
		this.managerName = managerName;
		this.managerContact = managerContact;
		this.screen = screen;
		this.show = show;

	
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


	public List<Screen> getScreen() {
		return screen;
	}


	public void setScreen(List<Screen> screen) {
		this.screen = screen;
	}


	public List<Show> getShow() {
		return show;
	}


	public void setShow(List<Show> show) {
		this.show = show;
	}
	@Override
	public int hashCode() {
		return Objects.hash(managerContact, managerName, screen, show, theatreCity, theatreId, theatreName);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Theatre other = (Theatre) obj;
		return Objects.equals(managerContact, other.managerContact) && Objects.equals(managerName, other.managerName)
				&& Objects.equals(screen, other.screen) && Objects.equals(show, other.show)
				&& Objects.equals(theatreCity, other.theatreCity) && theatreId == other.theatreId
				&& Objects.equals(theatreName, other.theatreName);

	
	


	
	}
}
