package com.aprendendoweb.course.resourses;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aprendendoweb.course.entities.Users;

@RestController
@RequestMapping(value = "/users")
public class UsersResourse {

	@GetMapping
	public ResponseEntity<Users> findAll(){
		Users u = new Users(1L,"Maria","maria@gmail.com","112223141","1234567");
		return ResponseEntity.ok().body(u);
	}
	
}
