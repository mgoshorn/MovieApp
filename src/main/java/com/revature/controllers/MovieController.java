package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Actor;
import com.revature.models.Movie;
import com.revature.services.MovieService;

@RestController
@RequestMapping("movies")
public class MovieController {

	private MovieService movieService;

	@Autowired
	public MovieController(MovieService movieService) {
		this.movieService = movieService;
	}
	
	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public Movie createPost(@RequestBody Movie movie) {
		return this.movieService.saveMovie(movie);
	}
	
	@GetMapping(path="{id}", produces="application/json")
	public Movie getMovie(@PathVariable int id) {
		return this.movieService.getMovieById(id);
	}
	
	@GetMapping(path="{id}", produces="text/html")
	public String getMovieHTML(@PathVariable int id) {
		Movie movie = this.movieService.getMovieById(id);
		String Html = "<html><head><title>"+movie.getName()+
				"</title></head><body><h1>"+movie.getName()+
				"</h1><h3>Released: " + movie.getReleaseDate() +
				"</h3><h2>Starring</h2><ol>";
		
		for(Actor actor : movie.getActors()) {
			Html += "<li>" + actor.getFirstName() + " " + actor.getLastName() + "</li>";
		}
		Html += "</ol></body></html>";
		
		return Html;
	}
	
	@GetMapping("")
	public Page<Movie> getMovies(Pageable pageable) {
		return movieService.getMovies(pageable);
	}
	
	@PutMapping("")
	public Movie updateMovie(@RequestBody Movie movie) {
		return movieService.update(movie);
	}
	
	@GetMapping("{id}/actors")
	public List<Actor> getActorsByMovie(@PathVariable int id) {
		return movieService.getActorsByMovie(id);
	}
	
}
