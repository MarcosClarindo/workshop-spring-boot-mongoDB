package com.marcosclarindo.workshopmongo.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcosclarindo.workshopmongo.domain.Post;
import com.marcosclarindo.workshopmongo.repository.PostRepository;
import com.marcosclarindo.workshopmongo.service.exception.objectNotFoundException;

@Service
public class PostService {
	
	@Autowired // injeção de dependencia automatica
	private PostRepository repo;
	
	
	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new objectNotFoundException("Objeto não encontrado"));
	}
	
	// Criando um método de busca
	public List<Post> findByTitle(String text) {
		return repo.findByTitle(text);
	}
	
	public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
		maxDate = new Date (maxDate.getTime() + 24 * 60 * 60 * 1000);
		return repo.fullSearch(text, minDate, maxDate);
	}
}
