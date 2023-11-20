package com.cg.mts.dto;

import java.time.LocalDate;
import java.util.Objects;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class MovieDTO {
    private int movieId;
    @NotBlank(message = "Movie name is required")
    private String movieName;
    @NotBlank(message = "Movie genre is required")
    private String movieGenre;
    @NotBlank(message = "Movie hours are required")
    @Pattern(regexp = "^\\d{1,2}:\\d{2}$", message = "Invalid time format. Use HH:mm")
    private String movieHours;
    @NotBlank(message = "Movie language is required")
    private String movieLanguage;
    @NotBlank(message = "Movie description is required")
    private String movieDescription;
    @NotBlank(message = "Movie rating is required")
    @Pattern(regexp = "^[1-9]|10$", message = "Invalid rating. Use a number between 1 and 10")
    private String movieRating;
    @NotNull(message = "Movie date is required")
    private LocalDate movieDate;
    private ShowDTO shows;
	public MovieDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MovieDTO(int movieId,  String movieName,
			 String movieGenre,
			 String movieHours,
			String movieLanguage,
			 String movieDescription,
			String movieRating,
			 LocalDate movieDate, ShowDTO shows) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.movieGenre = movieGenre;
		this.movieHours = movieHours;
		this.movieLanguage = movieLanguage;
		this.movieDescription = movieDescription;
		this.movieRating = movieRating;
		this.movieDate = movieDate;
		this.shows = shows;
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
	public ShowDTO getShows() {
		return shows;
	}
	public void setShows(ShowDTO shows) {
		this.shows = shows;
	}
	@Override
	public int hashCode() {
		return Objects.hash(movieDate, movieDescription, movieGenre, movieHours, movieId, movieLanguage, movieName,
				movieRating, shows);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MovieDTO other = (MovieDTO) obj;
		return Objects.equals(movieDate, other.movieDate) && Objects.equals(movieDescription, other.movieDescription)
				&& Objects.equals(movieGenre, other.movieGenre) && Objects.equals(movieHours, other.movieHours)
				&& movieId == other.movieId && Objects.equals(movieLanguage, other.movieLanguage)
				&& Objects.equals(movieName, other.movieName) && Objects.equals(movieRating, other.movieRating)
				&& Objects.equals(shows, other.shows);
	}
    
    
    
}