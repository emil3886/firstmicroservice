package com.emil.moviecatalogservice.model;

import java.util.List;

public class UserRating {
	
	private List<MovieRating> movieRatings;

	public List<MovieRating> getMovieRatings() {
		return movieRatings;
	}

	public void setMovieRatings(List<MovieRating> movieRatings) {
		this.movieRatings = movieRatings;
	}
	
}
