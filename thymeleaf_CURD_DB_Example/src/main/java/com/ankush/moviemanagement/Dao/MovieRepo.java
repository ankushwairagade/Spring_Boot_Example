package com.ankush.moviemanagement.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ankush.moviemanagement.Entity.Movie;

@Repository
public interface MovieRepo extends JpaRepository<Movie, Long> {

}
