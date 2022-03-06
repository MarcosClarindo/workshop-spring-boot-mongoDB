package com.marcosclarindo.workshopmongo.dto;

import java.io.Serializable;

import com.marcosclarindo.workshopmongo.domain.User;

public class AuthorDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	
	public AuthorDTO() {
	}
	
	// recebendo o usuario como argumento
	public AuthorDTO(User obj) {
		// instanciando, compiando o name e id para o AuthorDTO
		id = obj.getId();
		name = obj.getName();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
