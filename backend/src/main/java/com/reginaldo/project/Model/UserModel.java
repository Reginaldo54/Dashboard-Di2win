package com.reginaldo.project.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity(name = "users")
public class UserModel 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Size(max = 200)
	private String name;
	
	@Size(max = 50)
	private String segment;
	
	
}
