package com.cg.mts.entity;

import javax.persistence.*;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import java.time.*;
import java.util.Objects;

@Entity

@Table(name = "shhow")
@DynamicUpdate
public class Show {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int showId;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
	private LocalDateTime showStartTime;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
	private LocalDateTime showEndTime;
	private String showName;
	
	@OneToOne(mappedBy = "show")
	private Movie movie;
	@JsonIgnore
	@ManyToOne
	private Screen screen;
	@JsonIgnore
	@ManyToOne
	private Theatre theatre;
	@JsonIgnore
	@OneToOne
	private Booking booking;
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate showDate;
	public Show() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Show(LocalDateTime showStartTime, LocalDateTime showEndTime, String showName, Movie movie, Screen screen,
			Theatre theatre, Booking booking, LocalDate showDate) {
		super();
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


	public Movie getMovie() {
		return movie;
	}


	public void setMovie(Movie movie) {
		this.movie = movie;
	}


	public Screen getScreen() {
		return screen;
	}


	public void setScreen(Screen screen) {
		this.screen = screen;
	}


	public Theatre getTheatre() {
		return theatre;
	}


	public void setTheatre(Theatre theatre) {
		this.theatre = theatre;
	}


	public Booking getBooking() {
		return booking;
	}


	public void setBooking(Booking booking) {
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
		Show other = (Show) obj;
		return Objects.equals(booking, other.booking) && Objects.equals(movie, other.movie)
				&& Objects.equals(screen, other.screen) && Objects.equals(showDate, other.showDate)
				&& Objects.equals(showEndTime, other.showEndTime) && showId == other.showId
				&& Objects.equals(showName, other.showName) && Objects.equals(showStartTime, other.showStartTime)
				&& Objects.equals(theatre, other.theatre);
	}
	

	


	
}
