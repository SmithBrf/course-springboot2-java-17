package com.aprendendoweb.course.resourses;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aprendendoweb.course.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResourse {

	@GetMapping
	public ResponseEntity<User> findAll(){
		User u = new User(1L,"Maria","maria@gmail.com","112223141","1234567");
		return ResponseEntity.ok().body(u);
	}
	
}
