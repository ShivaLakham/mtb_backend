package com.cg.mts.dto;


import java.util.List;
import java.util.Objects;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class ScreenDTO {
	
    private int screenId;
    @NotBlank(message = "Screen name is required")
    private String screenName;
    @Positive(message = "Number of rows must be a positive integer")
    private int rows;
    @Positive(message = "Number of columns must be a positive integer")
    private int columns;
    private TheatreDTO theatre;
    
    private List<ShowDTO> shows;

	public ScreenDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ScreenDTO(int screenId,  String screenName,
			 int rows,
			 int columns,
			 TheatreDTO theatre, List<ShowDTO> shows) {
		super();
		this.screenId = screenId;
		this.screenName = screenName;
		this.rows = rows;
		this.columns = columns;
		this.theatre = theatre;
		this.shows = shows;
	}

	public int getScreenId() {
		return screenId;
	}

	public void setScreenId(int screenId) {
		this.screenId = screenId;
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

	public TheatreDTO getTheatre() {
		return theatre;
	}

	public void setTheatre(TheatreDTO theatre) {
		this.theatre = theatre;
	}

	public List<ShowDTO> getShows() {
		return shows;
	}

	public void setShows(List<ShowDTO> shows) {
		this.shows = shows;
	}

	@Override
	public int hashCode() {
		return Objects.hash(columns, rows, screenId, screenName, shows, theatre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ScreenDTO other = (ScreenDTO) obj;
		return columns == other.columns && rows == other.rows && screenId == other.screenId
				&& Objects.equals(screenName, other.screenName) && Objects.equals(shows, other.shows)
				&& Objects.equals(theatre, other.theatre);
	}
    
    
    
   
}