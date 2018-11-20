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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Actor;
import com.revature.models.Movie;
import com.revature.services.ActorService;

@RestController
@RequestMapping("actors")
public class ActorController {

	private ActorService actorService;

	@Autowired
	public ActorController(ActorService activeService) {
		this.actorService = activeService;
	}
	
	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public Actor createPost(@RequestBody Actor actor) {
		return this.actorService.saveActor(actor);
	}
	
	@GetMapping("{id}")
	public Actor getActor(@PathVariable int id) {
		return this.actorService.getActorById(id);
	}
	
	@PutMapping("")
	@ResponseBody
	public Actor updateActor(@RequestBody Actor actor) {
		return actorService.update(actor);
	}
	
	@GetMapping("{id}/movies")
	public List<Movie> getMoviesByActor(int id) {
		return actorService.getMoviesByActor(id);
	}
	
	@GetMapping("")
	public Page<Actor> getActors(Pageable pageable) {
		return actorService.getActors(pageable);
	}
	
	
}
