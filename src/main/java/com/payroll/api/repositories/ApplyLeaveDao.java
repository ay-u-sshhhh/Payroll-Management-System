package com.payroll.api.repositories;

import com.payroll.api.entity.ApplyLeaveEntity;
import com.payroll.api.model.ApplyLeave;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplyLeaveDao extends JpaRepository<ApplyLeaveEntity, Integer> {

	List<ApplyLeave> findByEmployeeId(int employeeId);
}
