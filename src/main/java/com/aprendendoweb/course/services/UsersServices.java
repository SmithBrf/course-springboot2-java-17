package com.aprendendoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.aprendendoweb.course.entities.Users;
import com.aprendendoweb.course.repositories.UsersRepository;
import com.aprendendoweb.course.services.exceptions.DatabaseException;
import com.aprendendoweb.course.services.exceptions.ResourceNotFoundException;

@Service
public class UsersServices {

	@Autowired
	private UsersRepository repository;
	
	public List<Users> findAll(){
		return repository.findAll();
	}
	
	public Users findById(Long id) {
		Optional<Users> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Users insert(Users obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		try {
		repository.deleteById(id);
		}
		catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}
		catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public Users update(Long id, Users obj) {
		try {
		Users entity = repository.getOne(id);
		updateData(entity,obj);
		return repository.save(entity);
		}
		catch(RuntimeException e) {
			e.printStackTrace();
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Users entity, Users obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
		
	}
}
