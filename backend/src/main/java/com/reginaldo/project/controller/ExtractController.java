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

import com.reginaldo.project.DTO.ExtractDTO;
import com.reginaldo.project.Model.ExtractModel;
import com.reginaldo.project.repository.ExtractRepository;

@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping("/api/extract")
public class ExtractController {

	@Autowired
	private ExtractRepository extractRepository;
	
	// GetAll
	@GetMapping("/get")
	public List<ExtractDTO> getAllExtracts() {
		
		// Guardando todos os post no banco na lista
		List<ExtractModel> extracts = extractRepository.findAll();
		
		// Covertente uma list de Post em uma lista de ExtractDTO e ent retornando ela
		return extracts.stream().map(this::convertToDto).collect(Collectors.toList());
	}

	// GetByID
	@GetMapping("/get/{id}")
	public ResponseEntity<ExtractDTO> getExtractById(@PathVariable Long id) {
		
		Optional<ExtractModel> extractOptional = extractRepository.findById(id);
		
		// tem algo
		if (extractOptional.isPresent()) {
			
			// Instanciando
			ExtractDTO extractDTO = new ExtractDTO();
			
			// Convertendo PostModel para Post
			BeanUtils.copyProperties(extractOptional.get(), extractDTO);
			return ResponseEntity.ok(extractDTO);
		} 
		
		// Se estiver vázio não retorna nada
		return ResponseEntity.notFound().build();
	
	}
	
	 
	private ExtractDTO convertToDto(ExtractModel extract) {
		
		// retornando um novo objeto da classe ExtractDTO
		return new ExtractDTO(
				extract.getId(),
				extract.getCreated_at(),
				extract.getPages_process(),
				extract.getDoc_type(),
				extract.getUser_id()
				);
	}

}
