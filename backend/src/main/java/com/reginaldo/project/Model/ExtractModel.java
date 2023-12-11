package com.reginaldo.project.Model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity(name = "extracts")
public class ExtractModel 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private LocalDateTime created_at = LocalDateTime.now();
	
	private Long pages_process;
	
	@Size(max = 100)
	private String doc_type;
	
	//@ManyToOne(fetch = FetchType.LAZY)
	//@JoinColumn(name = "user_id", referencedColumnName = "id")
	private Long user_id;
}
