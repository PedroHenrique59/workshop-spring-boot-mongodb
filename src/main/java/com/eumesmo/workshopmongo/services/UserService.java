package com.eumesmo.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eumesmo.workshopmongo.domain.User;
import com.eumesmo.workshopmongo.repository.UserRepository;
import com.eumesmo.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(String id) {
		Optional<User> user = repository.findById(id);
		if(user.isEmpty()) {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
		return user.get();
	}
}
