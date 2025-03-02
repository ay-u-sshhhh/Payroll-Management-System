package com.payroll.api.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.payroll.api.entity.ApproverEntity;

public interface ApproverDao extends JpaRepository<ApproverEntity, Integer> {
	
	
}

