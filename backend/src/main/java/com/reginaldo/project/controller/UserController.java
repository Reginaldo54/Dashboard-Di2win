package com.reginaldo.project.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.reginaldo.project.DTO.UserDTO;
import com.reginaldo.project.Model.UserModel;
import com.reginaldo.project.repository.UserRepository;

import jakarta.validation.Valid;

@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping("/api/user")
public class UserController 
{

	@Autowired
	private UserRepository userRepository;
	
	// GetAll
	@GetMapping("/get")
	public List<UserDTO> getAllUsers() 
	{
		
		// Guardando todos os post no banco na lista
		List<UserModel> users = userRepository.findAll();
		
		// Covertente uma list de UserModel em uma lista de UserModelDTO e ent retornando ela
		return users.stream().map(this::convertToDto).collect(Collectors.toList());
	}

	// GetByID
	@GetMapping("/get/{id}")
	public ResponseEntity<UserDTO> getUserById(@Valid @PathVariable Long id) {
		
		Optional<UserModel> userOptional = userRepository.findById(id);
		
		// tem algo
		if (userOptional.isPresent()) {
			
			// Instanciando
			UserDTO userDTO = new UserDTO();
			
			// Convertendo UserModelModel para UserModel
			BeanUtils.copyProperties(userOptional.get(), userDTO);
			return ResponseEntity.ok(userDTO);
		} 
		
		// Se estiver vázio não retorna nada
		return ResponseEntity.notFound().build();
	
	}
	
	
	
	private UserDTO convertToDto(UserModel user) {
		
		// retornando um novo objeto da classe UserModelDTO
		return new UserDTO(
				user.getId(),
				user.getName(),
				user.getSegment()
				);
				
	}

}
