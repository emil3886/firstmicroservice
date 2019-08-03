package com.emil.moviecatalogservice.model;

public class Movie {
	
	private String movieName;
	private String movieId;
	
	
	public Movie() {
		super();
	}


	public Movie(String movieName, String movieId) {
		super();
		this.movieName = movieName;
		this.movieId = movieId;
	}
	
	
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getMovieId() {
		return movieId;
	}
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	
	

}
