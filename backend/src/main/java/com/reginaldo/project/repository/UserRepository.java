package com.reginaldo.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reginaldo.project.Model.UserModel;


@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> 
{

}
