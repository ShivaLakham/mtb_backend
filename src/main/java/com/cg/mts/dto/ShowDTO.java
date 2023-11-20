package com.cg.mts.dto;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;



import java.time.LocalDate;

public class ShowDTO {
    private int showId;
    @FutureOrPresent(message = "Show start time must be in the present or future")
    private LocalDateTime showStartTime;
    @FutureOrPresent(message = "Show end time must be in the present or future")
    private LocalDateTime showEndTime;
    @Size(max = 20, message = "Show name must be at most 255 characters")
    private String showName;
    private MovieDTO movie;
    private ScreenDTO screen;
    private TheatreDTO theatre;
    @JsonIgnore
    private BookingDTO booking;
    @FutureOrPresent(message = "Show date must be in the present or future")
    private LocalDate showDate;
    
    
    
	
    
    
	public ShowDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ShowDTO(int showId, LocalDateTime showStartTime, LocalDateTime showEndTime, String showName, MovieDTO movie,
		ScreenDTO screen, TheatreDTO theatre, BookingDTO booking, LocalDate showDate) {
	super();
	this.showId = showId;
	this.showStartTime = showStartTime;
	this.showEndTime = showEndTime;
	this.showName = showName;
	this.movie = movie;
	this.screen = screen;
	this.theatre = theatre;
	this.booking = booking;
	this.showDate = showDate;
}
	public int getShowId() {
		return showId;
	}
	public void setShowId(int showId) {
		this.showId = showId;
	}
	public LocalDateTime getShowStartTime() {
		return showStartTime;
	}
	public void setShowStartTime(LocalDateTime showStartTime) {
		this.showStartTime = showStartTime;
	}
	public LocalDateTime getShowEndTime() {
		return showEndTime;
	}
	public void setShowEndTime(LocalDateTime showEndTime) {
		this.showEndTime = showEndTime;
	}
	public String getShowName() {
		return showName;
	}
	public void setShowName(String showName) {
		this.showName = showName;
	}
	public MovieDTO getMovie() {
		return movie;
	}
	public void setMovie(MovieDTO movie) {
		this.movie = movie;
	}
	public ScreenDTO getScreen() {
		return screen;
	}
	public void setScreen(ScreenDTO screen) {
		this.screen = screen;
	}
	public TheatreDTO getTheatre() {
		return theatre;
	}
	public void setTheatre(TheatreDTO theatre) {
		this.theatre = theatre;
	}
	public BookingDTO getBooking() {
		return booking;
	}
	public void setBooking(BookingDTO booking) {
		this.booking = booking;
	}
	public LocalDate getShowDate() {
		return showDate;
	}
	public void setShowDate(LocalDate showDate) {
		this.showDate = showDate;
	}
	@Override
	public int hashCode() {
		return Objects.hash(booking, movie, screen, showDate, showEndTime, showId, showName, showStartTime, theatre);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ShowDTO other = (ShowDTO) obj;
		return Objects.equals(booking, other.booking) && Objects.equals(movie, other.movie)
				&& Objects.equals(screen, other.screen) && Objects.equals(showDate, other.showDate)
				&& Objects.equals(showEndTime, other.showEndTime) && showId == other.showId
				&& Objects.equals(showName, other.showName) && Objects.equals(showStartTime, other.showStartTime)
				&& Objects.equals(theatre, other.theatre);
	}
    
    
   
}