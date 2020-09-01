package com.eumesmo.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eumesmo.workshopmongo.domain.Post;
import com.eumesmo.workshopmongo.repository.PostRepository;
import com.eumesmo.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repository;
		
	public Post findById(String id) {
		Optional<Post> post = repository.findById(id);
		if(post.isEmpty()) {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
		return post.get();
	}

	public List<Post> findByTitle(String text){
		return repository.findByTitleContainingIgnoreCase(text);
	}
}
