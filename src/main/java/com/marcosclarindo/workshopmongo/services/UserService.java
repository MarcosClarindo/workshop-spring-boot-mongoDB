package com.marcosclarindo.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcosclarindo.workshopmongo.domain.User;
import com.marcosclarindo.workshopmongo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired // injeção de dependencia automatica
	private UserRepository repo;
	
	// metodo para retornar todos os usuarios do BD
	public List<User> findAll() {
		return repo.findAll();
	}
}
