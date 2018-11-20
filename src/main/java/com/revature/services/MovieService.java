package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;

import com.revature.models.Actor;
import com.revature.models.Movie;
import com.revature.repositories.MovieRepository;

@Service
public class MovieService {
	private MovieRepository movieRepository;

	@Autowired
	public MovieService(MovieRepository movieRepository) {
		super();
		this.movieRepository = movieRepository;
	}

	@Transactional
	public Movie saveMovie(Movie movie) {
		return movieRepository.save(movie);
	}

	@Transactional
	public Movie getMovieById(int id) {
		return movieRepository
			.findById(id)
			.orElseThrow(
				() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
	}

	@Transactional
	public Movie update(Movie movie) {
		return movieRepository.save(movie);
	}

	@Transactional
	public List<Actor> getActorsByMovie(int id) {
		Movie movie = this.getMovieById(id);
		return movie.getActors();
	}

	public Page<Movie> getMovies(Pageable pageable) {
		return movieRepository.findAll(pageable);
	}
}
