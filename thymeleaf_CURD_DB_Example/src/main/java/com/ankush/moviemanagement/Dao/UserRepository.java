package com.ankush.moviemanagement.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ankush.moviemanagement.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByName(String name);
	
}
