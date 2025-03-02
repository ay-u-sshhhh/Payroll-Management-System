package com.payroll.api.service;

import com.payroll.api.entity.EmployeeSalaryEntity;
import com.payroll.api.model.Employee;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface DashboardService {
    Map<String, Object> getDashboardData();

	
}
