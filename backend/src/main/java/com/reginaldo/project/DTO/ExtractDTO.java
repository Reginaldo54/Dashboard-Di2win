package com.reginaldo.project.DTO;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExtractDTO implements Serializable 
{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private LocalDateTime created_at = LocalDateTime.now();
	
	private Long pages_process;
	
	private String doc_type;
	
	private Long user_id;
}
