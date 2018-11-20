package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer>{

}
