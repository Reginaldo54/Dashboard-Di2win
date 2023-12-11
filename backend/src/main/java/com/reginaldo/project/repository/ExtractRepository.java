package com.reginaldo.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reginaldo.project.Model.ExtractModel;


@Repository
public interface ExtractRepository extends JpaRepository<ExtractModel, Long> 
{
	
}
