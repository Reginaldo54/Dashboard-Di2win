package com.reginaldo.project.DTO;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO implements Serializable 
{
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String name;
	
	private String segment;
	
}
