package com.aprendendoweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aprendendoweb.course.entities.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {

	
	
}
