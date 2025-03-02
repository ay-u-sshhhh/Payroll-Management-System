package com.payroll.api.service;

import com.payroll.api.entity.EmployeeEntity;
import com.payroll.api.model.Employee;
import com.payroll.api.repositories.EmployeeDao;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public List<Employee> getAllEmployees() {
        List<EmployeeEntity> entities = employeeDao.findAll();
        return entities.stream().map(this::convertToModel).collect(Collectors.toList());
    }

    @Override
    public Employee getEmployeeById(int employeeId) {
        EmployeeEntity entity = employeeDao.findById(employeeId).orElse(null);
        return (entity != null) ? convertToModel(entity) : null;
    }

    @Override
    public Employee createEmployee(Employee employee) {
        EmployeeEntity entity = convertToEntity(employee);
        entity = employeeDao.save(entity);
        return convertToModel(entity);
    }

    @Override
    public Employee updateEmployee(int employeeId, Employee employee) {
        EmployeeEntity existingEntity = employeeDao.findById(employeeId).orElse(null);
        if (existingEntity != null) {
            BeanUtils.copyProperties(employee, existingEntity, "employeeId");
            existingEntity = employeeDao.save(existingEntity);
            return convertToModel(existingEntity);
        }
        return null;
    }

    @Override
    public void deleteEmployee(int employeeId) {
        employeeDao.deleteById(employeeId);
    }

    private Employee convertToModel(EmployeeEntity entity) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(entity, employee);
        return employee;
    }

    private EmployeeEntity convertToEntity(Employee employee) {
        EmployeeEntity entity = new EmployeeEntity();
        BeanUtils.copyProperties(employee, entity);
        return entity;
    }
}
