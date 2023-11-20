package com.cg.mts.entity;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.*;

import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;


@Entity

@Table(name = "movie")
@DynamicUpdate
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int movieId;
	private String movieName;
	private String movieGenre;
	private String movieHours;
	private String movieLanguage;
	private String movieDescription;
	private String movieRating;
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate movieDate;
	@JsonIgnore
	@OneToOne
	private Show show;
	
	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Movie(String movieName, String movieGenre, String movieHours, String movieLanguage, String movieDescription,
			String movieRating, LocalDate movieDate, Show show) {
		super();
		this.movieName = movieName;
		this.movieGenre = movieGenre;
		this.movieHours = movieHours;
		this.movieLanguage = movieLanguage;
		this.movieDescription = movieDescription;
		this.movieRating = movieRating;
		this.movieDate = movieDate;
		this.show = show;
	}
	@Override
	public int hashCode() {
		return Objects.hash(movieDate, movieDescription, movieGenre, movieHours, movieId, movieLanguage, movieName,
				movieRating, show);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		return Objects.equals(movieDate, other.movieDate) && Objects.equals(movieDescription, other.movieDescription)
				&& Objects.equals(movieGenre, other.movieGenre) && Objects.equals(movieHours, other.movieHours)
				&& movieId == other.movieId && Objects.equals(movieLanguage, other.movieLanguage)
				&& Objects.equals(movieName, other.movieName) && Objects.equals(movieRating, other.movieRating)
				&& Objects.equals(show, other.show);
	}

	

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getMovieGenre() {
		return movieGenre;
	}

	public void setMovieGenre(String movieGenre) {
		this.movieGenre = movieGenre;
	}

	public String getMovieHours() {
		return movieHours;
	}

	public void setMovieHours(String movieHours) {
		this.movieHours = movieHours;
	}

	public String getMovieLanguage() {
		return movieLanguage;
	}

	public void setMovieLanguage(String movieLanguage) {
		this.movieLanguage = movieLanguage;
	}

	public String getMovieDescription() {
		return movieDescription;
	}

	public void setMovieDescription(String movieDescription) {
		this.movieDescription = movieDescription;
	}

	public String getMovieRating() {
		return movieRating;
	}

	public void setMovieRating(String movieRating) {
		this.movieRating = movieRating;
	}

	public LocalDate getMovieDate() {
		return movieDate;
	}

	public void setMovieDate(LocalDate movieDate) {
		this.movieDate = movieDate;
	}

	public Show getShow() {
		return show;
	}

	public void setShow(Show show) {
		this.show = show;
	}


	
	}


