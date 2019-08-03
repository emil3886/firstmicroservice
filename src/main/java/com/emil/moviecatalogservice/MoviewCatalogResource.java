package com.emil.moviecatalogservice;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.emil.moviecatalogservice.model.CatalogItem;
import com.emil.moviecatalogservice.model.Movie;
import com.emil.moviecatalogservice.model.UserRating;

@RestController
@RequestMapping("/catalog")
public class MoviewCatalogResource {
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	@RequestMapping(path="/{userId}", method=RequestMethod.GET)
	public List<CatalogItem> getMovieCatalog(String userId){
		//return Collections.singletonList(new CatalogItem("Titanic", "Story of a Ship", 8));
		
		
		UserRating userRating = restTemplate.getForObject("http://localhost:8083/ratings/userRating/"+userId, UserRating.class);
		
		return userRating.getMovieRatings().stream().map(rating ->{
		
		Movie movie = restTemplate.getForObject("http://localhost:8082/movie/"+rating.getMovieId(), Movie.class);
		return new CatalogItem(movie.getMovieName(), "", rating.getRating());
			
			
		}).collect(Collectors.toList());
		
	}

}
