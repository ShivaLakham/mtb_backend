package com.cg.mts.entity;

import java.util.List;
import java.util.Objects;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;




@Entity

public class Screen {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int screenId;
	@JsonIgnore
	@ManyToOne
	private Theatre theatre;
	@OneToMany(mappedBy = "screen",cascade = CascadeType.ALL)
	private List<Show> show;
	private String screenName;
	@Column(name = "rowss")
	private int rows;
	@Column(name = "columnss")
	private int columns;

	public Screen() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Screen(int screenId, Theatre theatre, List<Show> show, String screenName, int rows, int columns) {
		super();
		this.screenId = screenId;
		this.theatre = theatre;
		this.show = show;
		this.screenName = screenName;
		this.rows = rows;
		this.columns = columns;
	}

	

	public int getScreenId() {
		return screenId;
	}

	public void setScreenId(int screenId) {
		this.screenId = screenId;
	}

	public Theatre getTheatre() {
		return theatre;
	}

	public void setTheatre(Theatre theatre) {
		this.theatre = theatre;
	}

	public List<Show> getShow() {
		return show;
	}

	public void setShow(List<Show> show) {
		this.show = show;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getColumns() {
		return columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}

	@Override
	public int hashCode() {
		return Objects.hash(columns, rows, screenId, screenName, show, theatre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Screen other = (Screen) obj;
		return columns == other.columns && rows == other.rows && screenId == other.screenId
				&& Objects.equals(screenName, other.screenName) && Objects.equals(show, other.show)
				&& Objects.equals(theatre, other.theatre);
	}

	
	
	}


