package com.payroll.api.repositories;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.payroll.api.entity.EmployeeSalaryEntity;

public interface EmployeeSalaryRepository extends JpaRepository<EmployeeSalaryEntity, Integer> {

	@Query("SELECT COUNT(DISTINCT e.employee.employeeId) FROM EmployeeSalaryEntity e")
    int findDistinctEmployeeCount();

    @Query("SELECT AVG(e.basicSalary) FROM EmployeeSalaryEntity e")
    BigDecimal findAverageBasicSalary();

    List<EmployeeSalaryEntity> findByIsDelayed(boolean isDelayed);
    
    @Query("SELECT e.employee.department, AVG(e.basicSalary) FROM EmployeeSalaryEntity e GROUP BY e.employee.department")
    List<Object[]> findAverageSalaryByDepartment();
    
    @Query("SELECT SUM(e.basicSalary + e.allowances - e.deductions) FROM EmployeeSalaryEntity e")
    BigDecimal sumTotalPayouts();

    @Query("SELECT COALESCE(SUM(es.basicSalary + es.allowances - es.deductions), 0) FROM EmployeeSalaryEntity es WHERE es.isDelayed = true")
    BigDecimal sumSalaryByIsDelayed(boolean isDelayed);
    
}
