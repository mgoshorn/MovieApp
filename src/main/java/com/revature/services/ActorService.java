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
import com.revature.repositories.ActorRepository;

@Service
public class ActorService {

	private ActorRepository actorRepository;

	@Autowired
	public ActorService(ActorRepository actorRepository) {
		super();
		this.actorRepository = actorRepository;
	}

	@Transactional
	public Actor saveActor(Actor actor) {
		return actorRepository.save(actor);
	}

	@Transactional
	public Actor getActorById(int id) {
		return actorRepository
			.findById(id)
			.orElseThrow(
				() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
	}

	@Transactional
	public Actor update(Actor actor) {
		return actorRepository.save(actor);
	}

	@Transactional
	public List<Movie> getMoviesByActor(int id) {
		Actor actor = this.getActorById(id);
		return actor.getMovies();
	}

	public Page<Actor> getActors(Pageable pageable) {
		return actorRepository.findAll(pageable);
	}
	
	
}
