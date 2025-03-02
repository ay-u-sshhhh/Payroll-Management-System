package com.payroll.api.repositories;

import java.util.List;

 import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.payroll.api.entity.userEntity;



@Repository
public interface UserDao extends CrudRepository<userEntity, Integer> {

	userEntity findByUsername(String username);
 

    
    @Query(value = "SELECT *  FROM ayush_user ", nativeQuery = true)
	Page<userEntity> listallusersfromdb( Pageable pageable);
 
    
    }