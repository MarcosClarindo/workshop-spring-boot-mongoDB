package com.marcosclarindo.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcosclarindo.workshopmongo.domain.User;
import com.marcosclarindo.workshopmongo.dto.UserDTO;
import com.marcosclarindo.workshopmongo.repository.UserRepository;
import com.marcosclarindo.workshopmongo.service.exception.objectNotFoundException;

@Service
public class UserService {
	
	@Autowired // injeção de dependencia automatica
	private UserRepository repo;
	
	// metodo para retornar todos os usuarios do BD
	public List<User> findAll() {
		return repo.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new objectNotFoundException("Objeto não encontrado"));
	}
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	// metodo dele tem que ser VOID
	public void delete (String id) {
		findById(id); //para fazer uma busca pelo ID aproveitando a exceção 
		repo.deleteById(id);
	}
	
	//atualização de dados 
	public User update(User obj) {
		User newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
		
	}
	
	private void updateData(User newObj, User obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
		
	}

	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
}
