package com.example.springbootproject.services;

import java.util.List;
import java.util.Map;

import com.example.springbootproject.dto.EmployeeDTO;
import com.example.springbootproject.entities.Employee;


public interface EmployeeService {

     Employee saveEmployee(Employee employee);

    Employee updateEmployee(Long id, Employee employee);

    void deleteEmployee(Long id);

    EmployeeDTO getEmployeeById(Long id);

    List<Employee> getAllEmployees();

	EmployeeDTO updateEmployeeID(Long id, EmployeeDTO employeeDTO);

	EmployeeDTO updatePartialEmployee(Long id, Map<String, Object> updatePartial);
}
