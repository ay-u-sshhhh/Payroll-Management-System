package com.payroll.api.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.payroll.api.entity.EmployeeEntity;

public interface EmployeeDao extends JpaRepository<EmployeeEntity, Integer> {
	
	
	@Query("SELECT e.department, COUNT(e) FROM EmployeeEntity e GROUP BY e.department")
    List<Object[]> findEmployeeCountByDepartment();
	
}

